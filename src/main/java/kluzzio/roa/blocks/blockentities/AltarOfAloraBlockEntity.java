package kluzzio.roa.blocks.blockentities;

import kluzzio.roa.gui.skilltree.AltarScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class AltarOfAloraBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public AltarOfAloraBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesInit.ALTAR_OF_ALORA_BLOCK_ENTITY, pos, state);
    }

    // NamedScreenHandlerFactory Interface Methods

    @org.jetbrains.annotations.Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new AltarScreenHandler(syncId, inv);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}