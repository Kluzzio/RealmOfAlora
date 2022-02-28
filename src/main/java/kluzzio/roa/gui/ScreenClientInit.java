package kluzzio.roa.gui;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.gui.skilltree.AltarScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ScreenClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(RealmOfAlora.ALTAR_SCREEN_HANDLER, AltarScreen::new);
    }

}
