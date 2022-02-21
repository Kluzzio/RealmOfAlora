package kluzzio.roa;

import kluzzio.roa.config.RoaConfig;
import kluzzio.roa.items.ItemsInit;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RealmOfAlora implements ModInitializer {

	public static final String MOD_ID = "roa";

	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static RoaConfig config;

	public static final Block ALTAR_OF_ALORA = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 4.0f).requiresTool());

	@Override
	public void onInitialize() {

		//Config
		RoaConfig.init();
		config = AutoConfig.getConfigHolder(RoaConfig.class).getConfig();

		//Item Creation
		ItemsInit.init();
		Registry.register(Registry.BLOCK, new Identifier("roa", "altar_of_alora"), ALTAR_OF_ALORA);
		Registry.register(Registry.ITEM, new Identifier("roa", "altar_of_alora"), new BlockItem(ALTAR_OF_ALORA, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
	}
}