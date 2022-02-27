package kluzzio.roa.api.util;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHelper {

    public static void roa$dropItem(LivingEntity le, Item item) {
        roa$dropItem(le, item, 1);
    }

    public static void roa$dropItem(LivingEntity le, Item item, int amount) {
        ItemEntity it = new ItemEntity(
                le.world, le.getX(), le.getY(), le.getZ(),
                new ItemStack(item, amount));
        le.world.spawnEntity(it);
    }

}
