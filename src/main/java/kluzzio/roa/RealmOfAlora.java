package kluzzio.roa;

import kluzzio.roa.config.RoaConfig;
import kluzzio.roa.items.ItemsInit;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class RealmOfAlora implements ModInitializer {

	public static final String MOD_ID = "roa";

	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static RoaConfig config;

	@Override
	public void onInitialize() {

		//Config
		RoaConfig.init();
		config = AutoConfig.getConfigHolder(RoaConfig.class).getConfig();

		//Item Creation
		ItemsInit.init();
	}
}