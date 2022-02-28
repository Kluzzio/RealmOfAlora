package kluzzio.roa.gui.skilltree;

import kluzzio.roa.RealmOfAlora;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class AltarScreenHandler extends ScreenHandler {

    public AltarScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public AltarScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(RealmOfAlora.ALTAR_SCREEN_HANDLER, syncId);
        checkSize(inventory, 9);
        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job
        int m;
        int l;
        //Our inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, l + m * 3, 62 + l * 18, 17 + m * 18));
            }
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
