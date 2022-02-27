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

    public static int getDevotion(PlayerEntity playerEntity) {
        return ((IDevotionEntity) playerEntity).getDevotion();
    }

    public static void setDevotion(PlayerEntity playerEntity, int amount) {
        ((IDevotionEntity) playerEntity).setDevotion(amount);
    }

    public static void increaseDevotion(PlayerEntity playerEntity, int amount) {
        int f = getDevotion(playerEntity);
        setDevotion(playerEntity, f + amount);
    }

    public static void decreaseDevotion(PlayerEntity playerEntity, int amount) {
        int f = getDevotion(playerEntity);
        setDevotion(playerEntity, f - amount);
    }

    public static void greatDeed(PlayerEntity playerEntity) {
        increaseDevotion(playerEntity, RealmOfAlora.config.roaDevotionConfig.GREAT_DEED_BONUS_DEVOTION);
        if (getDevotion(playerEntity) == devotee)
            ItemHelper.roa$dropItem(playerEntity, Items.AMETHYST_SHARD);
        // Maybe other stuff here at some point
    }

    public static void greatMisdeed(PlayerEntity playerEntity) {
        // Drop devotion to next threshold
        if (getDevotion(playerEntity) > worshipper)
            setDevotion(playerEntity, worshipper);
        else if (getDevotion(playerEntity) > follower)
            setDevotion(playerEntity, follower);
        else if (getDevotion(playerEntity) > blind)
            setDevotion(playerEntity, blind);
    }

    public static void deathDevotionChange(PlayerEntity playerEntity, LivingEntity livingEntity) {
        if (EntityHelper.validEntityType(livingEntity)) {
            int devotion = RealmOfAlora.config.roaEntityDevotionConfig.REWARD_OF_ALORA.get(livingEntity.getType());

            if (RealmOfAlora.config.roaEntityDevotionConfig.TARGET_OF_ALORA.get(livingEntity.getType())) {
                if (InventoryHelper.roa$hasChalice(playerEntity))
                    increaseDevotion(playerEntity, devotion);
            }
            else
                decreaseDevotion(playerEntity, devotion);
        }
    }
}