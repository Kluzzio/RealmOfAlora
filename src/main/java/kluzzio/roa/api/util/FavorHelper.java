package kluzzio.roa.api.util;

import kluzzio.roa.api.interfaces.IDevotionEntity;
import net.minecraft.entity.player.PlayerEntity;

public class FavorHelper {

    // These are thresholds of Devotion
    public static final int blind = 0;
    public static final int follower = 250;
    public static final int worshipper = 500;
    public static final int devotee = 1000;

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
        if (getDevotion(playerEntity) < follower)
            setDevotion(playerEntity, follower);
        else if (getDevotion(playerEntity) < worshipper)
            setDevotion(playerEntity, worshipper);
        else if (getDevotion(playerEntity) < devotee)
            setDevotion(playerEntity, devotee);
    }

    public static void greatMisdeed(PlayerEntity playerEntity) {
        if (getDevotion(playerEntity) > worshipper)
            setDevotion(playerEntity, worshipper);
        else if (getDevotion(playerEntity) > follower)
            setDevotion(playerEntity, follower);
        else if (getDevotion(playerEntity) > blind)
            setDevotion(playerEntity, blind);
    }
}