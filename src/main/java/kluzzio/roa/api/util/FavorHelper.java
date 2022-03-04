package kluzzio.roa.api.util;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.api.interfaces.IDevotionEntity;
import kluzzio.roa.enums.DevotionID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class FavorHelper {

    // These are thresholds of Devotion
    public static final int blind = // 0
            RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.BLIND);
    public static final int follower = // 250
            RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.FOLLOWER);
    public static final int worshipper = // 500
            RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.WORSHIPPER);
    public static final int devotee = // 1000
            RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.DEVOTEE);

    // Integral core methods

    public static int getDevotion(PlayerEntity pe) {
        return ((IDevotionEntity) pe).getDevotion();
    }

    public static void setDevotion(PlayerEntity pe, int a) {
        ((IDevotionEntity) pe).setDevotion(a);
    }

    public static void increaseDevotion(PlayerEntity pe, int a) {
        int f = getDevotion(pe);
        setDevotion(pe, f + a);
    }

    public static void decreaseDevotion(PlayerEntity pe, int a) {
        int f = getDevotion(pe);
        setDevotion(pe, f - a);
    }

    // Event based / triggered methods

    public static void deathDevotionChange(PlayerEntity pe, LivingEntity le) {
        if (EntityHelper.validEntityType(le)) {
            int devotion = RealmOfAlora.config.roaEntityDevotionConfig.REWARD_OF_ALORA.get(le.getType());

            if (RealmOfAlora.config.roaEntityDevotionConfig.TARGET_OF_ALORA.get(le.getType())) {
                if (InventoryHelper.roa$hasChalice(pe))
                    increaseDevotion(pe, devotion);
            }
            else
                decreaseDevotion(pe, devotion);
        }
    }

    public static void greatDeed(PlayerEntity pe) {
        increaseDevotion(pe, RealmOfAlora.config.roaDevotionConfig.GREAT_DEED_BONUS_DEVOTION);
        if (getDevotion(pe) == devotee)
            ItemHelper.roa$dropItem(pe, Items.AMETHYST_SHARD);
        // Maybe other stuff here at some point
    }

    public static void greatMisdeed(PlayerEntity pe) {
        // Drop devotion to next threshold
        setDevotion(pe, getThreshold(pe));
    }

    // Threshold Methods

    public static int getThreshold(PlayerEntity pe) {
        if (isBlind(pe))
            return blind;
        else if (isFollower(pe))
            return follower;
        else if (isWorshipper(pe))
            return worshipper;
        else if (isDevotee(pe))
            return devotee;
        else return getDevotion(pe);
    }

    public static boolean isBlind(PlayerEntity pe) {
        int f = getDevotion(pe);
        return f >= blind && f < follower;
    }

    public static boolean isFollower(PlayerEntity pe) {
        int f = getDevotion(pe);
        return f >= follower && f < worshipper;
    }

    public static boolean isWorshipper(PlayerEntity pe) {
        int f = getDevotion(pe);
        return f >= worshipper && f < devotee;
    }

    public static boolean isDevotee(PlayerEntity pe) {
        return getDevotion(pe) >= devotee;
    }

}