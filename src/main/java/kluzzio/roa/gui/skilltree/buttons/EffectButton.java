package kluzzio.roa.gui.skilltree.buttons;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class EffectButton extends PressableWidget {

    private final Screen screen;

    public EffectButton(Screen screen, int x, int y, int width, int height) {
        super(x, y, width, height, Text.of(""));
        this.screen = screen;
    }

    @Override
    public void onPress() {
        //MinecraftClient client = MinecraftClient.getInstance();
        //PacketByteBuf buf = PacketByteBufs.create();
        //buf.writeIntArray(new int[] {1, 0, 1, 0, 0});
//
        //ServerPlayNetworking.send((ServerPlayerEntity) , );
        this.active = false;
    }
    
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float tickDelta) {
        super.render(matrices, mouseX, mouseY, tickDelta);
        if (this.isMouseOver(mouseX, mouseY)) {
            this.screen.renderTooltip(matrices, new LiteralText("You tried"), this.x, this.y);
        }
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder arg) {
    }
}
