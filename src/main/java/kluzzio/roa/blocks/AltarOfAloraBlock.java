package kluzzio.roa.blocks;

import kluzzio.roa.blocks.blockentities.AltarOfAloraBlockEntity;
import kluzzio.roa.enums.BlocksID;
import kluzzio.roa.gui.skilltree.AltarScreenHandler;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class AltarOfAloraBlock extends BlockWithEntity implements BlockEntityProvider {

    public AltarOfAloraBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (world.getBlockState(pos.offset(Direction.Axis.Y, 1)).isOf(BlocksInit.ROA_BLOCKS.get(BlocksID.CHALICE_OF_ALORA))) {
                //TODO make skill tree 4head
                NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

                if (screenHandlerFactory != null) {
                    //With this call the server will request the client to open the appropriate Screenhandler
                    player.openHandledScreen(screenHandlerFactory);
                }
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public AltarOfAloraBlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        //Spawns Block Entity alongside block which makes them connected
        return new AltarOfAloraBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }
}