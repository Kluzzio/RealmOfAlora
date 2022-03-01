package kluzzio.roa.gui.skilltree;

import kluzzio.roa.RealmOfAlora;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;

public class AltarScreenHandler extends ScreenHandler {

    public AltarScreenHandler(int syncId) {
        this(syncId, new SimpleInventory(1));
    }

    public AltarScreenHandler(int syncId, Inventory inventory) {
        super(RealmOfAlora.ALTAR_SCREEN_HANDLER, syncId);
        checkSize(inventory, 1);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}