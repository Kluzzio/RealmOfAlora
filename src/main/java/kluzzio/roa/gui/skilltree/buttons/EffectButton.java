package kluzzio.roa.gui.skilltree.buttons;

import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EffectButton extends WToggleButton {

    public EffectButton() {
    }

    public EffectButton(Text label) {
        super(label);
    }

    public EffectButton(Identifier onImage, Identifier offImage) {
        super(onImage, offImage);
    }


    public EffectButton(Identifier onImage, Identifier offImage, Text label) {
        super(onImage, offImage, label);
    }


    public EffectButton(Texture onImage, Texture offImage) {
        super(onImage, offImage);
    }


    public EffectButton(Texture onImage, Texture offImage, Text label) {
        super(onImage, offImage, label);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public InputResult onClick(int x, int y, int button) {
        if (!this.isOn) {
            //TODO replace sound effect
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));

            this.isOn = true;
            onToggle(true);
        }

        return InputResult.PROCESSED;
    }
}
