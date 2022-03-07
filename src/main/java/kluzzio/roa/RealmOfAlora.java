package kluzzio.roa;

import kluzzio.roa.blocks.BlocksInit;
import kluzzio.roa.blocks.blockentities.BlockEntitiesInit;
import kluzzio.roa.config.RoaConfig;
import kluzzio.roa.entities.villager.AloranCardinalProfession;
import kluzzio.roa.gui.skilltree.screen.SkillTreeGuiDescription;
import kluzzio.roa.items.ItemsInit;
import kluzzio.roa.networking.NetworkingInit;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RealmOfAlora implements ModInitializer {

	// Universal / Housekeeping
	public static final String MOD_ID = "roa";
	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	// Config
	public static RoaConfig config;

	// GUI
	public static final ScreenHandlerType<SkillTreeGuiDescription> SCREEN_HANDLER_TYPE =
			ScreenHandlerRegistry.registerSimple(ID("altar_of_alora"), (syncId, inventory) ->
					new SkillTreeGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

	@Override
	public void onInitialize() {

		//Networking
		NetworkingInit.init();

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