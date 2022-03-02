package kluzzio.roa.gui;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.gui.skilltree.screen.SkillTreeGuiDescription;
import kluzzio.roa.gui.skilltree.screen.SkillTreeGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ScreenClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //noinspection RedundantTypeArguments Otherwise it breaks
        ScreenRegistry.<SkillTreeGuiDescription, SkillTreeGuiScreen>register(RealmOfAlora.SCREEN_HANDLER_TYPE, (gui, inventory, title) ->
                new SkillTreeGuiScreen(gui, inventory.player, title));
    }
}