package kluzzio.roa.blocks;

import kluzzio.roa.enums.BlocksID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChaliceOfAloraBlock extends Block {
    public ChaliceOfAloraBlock(Settings settings) {
        super(settings);
    }

    private VoxelShape shape() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(6f/16f, 0, 6f/16f, 10f/16f, 0.5f/16f, 10f/16f),
                VoxelShapes.cuboid(6.8f/16f, 0.5f/16f, 6.8f/16f, 9.2f/16f, 5.5f/16f, 9.2f/16f),
                VoxelShapes.cuboid(5.3f/16f, 5.5f/16f, 5.3f/16f, 10.7f/16f, 12.5f/16f, 10.7f/16f));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.getStackInHand(hand).isEmpty()) {
                player.setStackInHand(hand, new ItemStack(BlocksInit.ROA_BLOCKS.get(BlocksID.CHALICE_OF_ALORA)));
                world.breakBlock(pos,false, player);
            } else
                world.breakBlock(pos,true, player);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return shape();
    }
}