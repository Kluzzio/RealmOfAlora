package kluzzio.roa;

import kluzzio.roa.blocks.blockentities.BlockEntitiesInit;
import kluzzio.roa.config.RoaConfig;
import kluzzio.roa.blocks.BlocksInit;
import kluzzio.roa.entities.villager.AloranCardinalProfession;
import kluzzio.roa.enums.BlocksID;
import kluzzio.roa.gui.skilltree.AltarScreenHandler;
import kluzzio.roa.items.ItemsInit;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RealmOfAlora implements ModInitializer {

	public static final String MOD_ID = "roa";

	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static RoaConfig config;

	public static final ScreenHandlerType<AltarScreenHandler> ALTAR_SCREEN_HANDLER;

	static {
		ALTAR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(RealmOfAlora.ID(BlocksID.CHALICE_OF_ALORA.toString().toLowerCase()), AltarScreenHandler::new);
	}

	@Override
	public void onInitialize() {

		//Config
		RoaConfig.init();
		config = AutoConfig.getConfigHolder(RoaConfig.class).getConfig();

		//Item Creation
		ItemsInit.init();
		BlocksInit.init();
		BlockEntitiesInit.init();

		//Entities
		AloranCardinalProfession.init();
	}
}