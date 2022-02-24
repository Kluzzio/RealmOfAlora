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

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.getStackInHand(hand).isEmpty()) {
                player.setStackInHand(hand, new ItemStack(BlocksInit.ROA_BLOCKS.get(BlocksID.CHALICE_OF_ALORA)));
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(6, 0, 6, 10, 0.5, 10),
                VoxelShapes.cuboid(6.8, 0.5, 6.8, 9.2, 5.5, 9.2),
                VoxelShapes.cuboid(5.3, 5.5, 5.3, 10.7, 12.5, 10.7));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(6, 0, 6, 10, 0.5, 10),
                VoxelShapes.cuboid(6.8, 0.5, 6.8, 9.2, 5.5, 9.2),
                VoxelShapes.cuboid(5.3, 5.5, 5.3, 10.7, 12.5, 10.7));
    }
}
