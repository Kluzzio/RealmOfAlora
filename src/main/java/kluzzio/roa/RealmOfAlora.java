package kluzzio.roa;

import kluzzio.roa.items.ItemsInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class RealmOfAlora implements ModInitializer {

	public static final String MOD_ID = "roa";

	public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {

		//Item Creation
		ItemsInit.init();
	}
}