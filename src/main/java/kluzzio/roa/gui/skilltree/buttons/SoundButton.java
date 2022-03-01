package kluzzio.roa.gui.skilltree.buttons;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

public class SoundButton extends PressableWidget {

    public SoundButton(int x, int y, int width, int height) {
        super(x, y, width, height, Text.of("Sound Button"));
    }

    @Override
    public void onPress() {
        final SoundEvent event = SoundEvents.ENTITY_GENERIC_EXPLODE;
        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(event, 1.0F, 1.0F));
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder arg) {
    }
}