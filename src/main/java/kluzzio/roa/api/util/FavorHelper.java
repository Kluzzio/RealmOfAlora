package kluzzio.roa.api.util;

import kluzzio.roa.api.interfaces.IDevotionEntity;
import net.minecraft.entity.player.PlayerEntity;

public class FavorHelper {

    public static void increaseDevotion(PlayerEntity playerEntity, int amount) {
        int f = getDevotion(playerEntity);
        setDevotion(playerEntity, f + amount);
    }

    public static void decreaseDevotion(PlayerEntity playerEntity, int amount) {
        int f = getDevotion(playerEntity);
        setDevotion(playerEntity, f - amount);
    }

    public static int getDevotion(PlayerEntity playerEntity) {
        return ((IDevotionEntity) playerEntity).getDevotion();
    }

    public static void setDevotion(PlayerEntity playerEntity, int amount) {
        ((IDevotionEntity) playerEntity).setDevotion(amount);
    }
}
