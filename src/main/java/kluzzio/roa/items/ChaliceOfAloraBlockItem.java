package kluzzio.roa.items;

import kluzzio.roa.api.util.CleanlinessHelper;
import kluzzio.roa.api.util.FavorHelper;
import kluzzio.roa.api.util.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ChaliceOfAloraBlockItem extends BlockItem {

    public ChaliceOfAloraBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (!FavorHelper.isBlind(player)) {
                if (world.getTime() % 100 == 0)
                    if (CleanlinessHelper.percentToOccur((int) ((float) (FavorHelper.getThreshold(player) / FavorHelper.devotee) * 100)))
                        ItemHelper.roa$dropItem(player, Items.AMETHYST_SHARD);
            }
        }
    }
}