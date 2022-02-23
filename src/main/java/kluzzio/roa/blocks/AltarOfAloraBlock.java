package kluzzio.roa.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AltarOfAloraBlock extends Block {

    public AltarOfAloraBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.heal(2);
            return ActionResult.CONSUME;
        }
        return ActionResult.SUCCESS;
    }

    //@Override
    //public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    //    if (!world.isClient) {
    //        if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()))){
//
    //        }
    //    }
    //    return ActionResult.SUCCESS;
    //}
//
    //public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
    //    return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
    //        return new CraftingScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos));
    //    }, TITLE);
    //}
}
