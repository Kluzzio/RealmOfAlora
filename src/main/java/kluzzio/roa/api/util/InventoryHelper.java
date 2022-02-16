package kluzzio.roa.api.util;

import kluzzio.roa.enums.ItemsID;
import kluzzio.roa.items.ItemsInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryHelper {

    public static boolean roa$hasItem(PlayerEntity playerEntity, Item item) {
        PlayerInventory playerInventory = playerEntity.getInventory();
        for (int slotID = 0; slotID < playerInventory.size(); slotID++) {
            ItemStack currentStack = playerInventory.getStack(slotID);
            if (currentStack.getItem() == item) {
                return true;
            }
        }
        return false;
    }

    public static boolean roa$hasItem(PlayerEntity playerEntity, Item item, int count) {
        PlayerInventory playerInventory = playerEntity.getInventory();
        for (int slotID = 0; slotID < playerInventory.size(); slotID++) {
            ItemStack currentStack = playerInventory.getStack(slotID);
            if (currentStack.getItem() == item) {
                count -= currentStack.getCount();
                if (count <= 0)
                    return true;
            }
        }
        return false;
    }

    public static boolean roa$hasChalice(PlayerEntity playerEntity) {
        return InventoryHelper.roa$hasItem(playerEntity, ItemsInit.roaItems.get(ItemsID.CHALICE_OF_ALORA));
    }
}