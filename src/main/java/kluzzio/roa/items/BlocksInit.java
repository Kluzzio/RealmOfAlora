package kluzzio.roa.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static kluzzio.roa.RealmOfAlora.ID;

public class BlocksInit {

    public static final Block ALTAR_OF_ALORA = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 4.0f).requiresTool());

    public static void init() {

        registerBlockItem("altar_of_alora", ALTAR_OF_ALORA, ItemGroup.DECORATIONS);
    }

    protected static void registerBlockItem(String id, Block block, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, ID(id), block);
        Registry.register(Registry.ITEM, ID(id), BI(block, itemGroup));
    }

    public static BlockItem BI(Block block, ItemGroup itemGroup) {
        return new BlockItem(block, new FabricItemSettings().group(itemGroup));
    }

}