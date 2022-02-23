package kluzzio.roa.items;

import kluzzio.roa.enums.BlocksID;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import java.util.EnumMap;

import static kluzzio.roa.RealmOfAlora.ID;

public class BlocksInit {

    //Blocks
    public static final Block ALTAR_OF_ALORA = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 4.0f).requiresTool());

    //EnumMap
    public static final EnumMap<BlocksID, Block> ROA_BLOCKS = new EnumMap<>(BlocksID.class);

    public static void init() {

        ROA_BLOCKS.put(BlocksID.ALTAR_OF_ALORA, ALTAR_OF_ALORA);
        registerBlockItem(BlocksID.ALTAR_OF_ALORA.toString().toLowerCase(), ALTAR_OF_ALORA, ItemGroup.DECORATIONS);
    }

    protected static void registerBlockItem(String id, Block block, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, ID(id), block);
        Registry.register(Registry.ITEM, ID(id), BI(block, itemGroup));
    }

    public static BlockItem BI(Block block, ItemGroup itemGroup) {
        return new BlockItem(block, new FabricItemSettings().group(itemGroup));
    }

}