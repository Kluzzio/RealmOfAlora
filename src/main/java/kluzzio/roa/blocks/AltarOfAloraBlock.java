package kluzzio.roa.blocks;

import kluzzio.roa.enums.BlocksID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class AltarOfAloraBlock extends Block {

    public AltarOfAloraBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (world.getBlockState(pos.offset(Direction.Axis.Y, 1)).isOf(BlocksInit.ROA_BLOCKS.get(BlocksID.CHALICE_OF_ALORA))) {
                //TODO make skill tree 4head
                player.heal(2);
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.SUCCESS;
    }
}