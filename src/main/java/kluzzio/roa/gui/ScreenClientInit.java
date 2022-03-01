package kluzzio.roa.gui;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.systems.RenderSystem;
import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.gui.skilltree.AltarScreen;
import kluzzio.roa.gui.skilltree.buttons.SoundButton;
import kluzzio.roa.gui.skilltree.buttons.StopSoundButton;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ClickableWidget;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ScreenClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(RealmOfAlora.ALTAR_SCREEN_HANDLER, AltarScreen::new);
        //LOGGER.info("Started Screen Testmod");
        ScreenEvents.BEFORE_INIT.register((client, screen, width, height) -> {
            // TODO: Write tests listening to addition of child elements
        });

        ScreenEvents.AFTER_INIT.register(this::afterInitScreen);
    }

    private void afterInitScreen(net.minecraft.client.MinecraftClient client, Screen screen, int windowWidth, int windowHeight) {
        //LOGGER.info("Initializing {}", screen.getClass().getName());

        if (screen instanceof TitleScreen) {
            final List<ClickableWidget> buttons = Screens.getButtons(screen);

            // Shrink the realms button, should be the third button on the list
            final ClickableWidget optionsButton = buttons.get(2);
            optionsButton.setWidth(98);

            // Add a new button
            buttons.add(new SoundButton((screen.width / 2) + 2, ((screen.height / 4) + 96), 72, 20));
            // And another button
            buttons.add(new StopSoundButton(screen, (screen.width / 2) + 80, ((screen.height / 4) + 95), 20, 20));

            // Testing:
            // Some automatic validation that the screen list works, make sure the buttons we added are on the list of child elements
            screen.children().stream()
                    .filter(element -> element instanceof SoundButton)
                    .findAny()
                    .orElseThrow(() -> new AssertionError("Failed to find the \"Sound\" button in the screen's elements"));

            screen.children().stream()
                    .filter(element -> element instanceof StopSoundButton)
                    .findAny()
                    .orElseThrow(() -> new AssertionError("Failed to find the \"Stop Sound\" button in the screen's elements"));

            // Register render event to draw an icon on the screen
            ScreenEvents.afterRender(screen).register((_screen, matrices, mouseX, mouseY, tickDelta) -> {
                // Render an armor icon to test
                RenderSystem.setShaderTexture(0, InGameHud.GUI_ICONS_TEXTURE);
                DrawableHelper.drawTexture(matrices, (screen.width / 2) - 124, (screen.height / 4) + 96, 20, 20, 34, 9, 9, 9, 256, 256);
            });

            ScreenKeyboardEvents.allowKeyPress(screen).register((_screen, key, scancode, modifiers) -> {
                //LOGGER.info("After Pressed, Code: {}, Scancode: {}, Modifiers: {}", key, scancode, modifiers);
                return true; // Let actions continue
            });

            ScreenKeyboardEvents.afterKeyPress(screen).register((_screen, key, scancode, modifiers) -> {
                //LOGGER.warn("Pressed, Code: {}, Scancode: {}, Modifiers: {}", key, scancode, modifiers);
            });
        }
    }

}