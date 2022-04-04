package kluzzio.roa.networking;

import kluzzio.roa.RealmOfAlora;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class ROAClient implements ClientModInitializer {

    private static boolean enabled = false;

    private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.roa.keybind",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "category.roa.test"
    ));

    public static void toggleIsEnabled(){
        enabled = !enabled;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(keyBinding.wasPressed()) {
                toggleIsEnabled();
                if (client.player != null)
                    client.player.sendMessage(new LiteralText("Key was turned " + (isEnabled() ? "on" : "off")), false);
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeBoolean(isEnabled());

                ClientPlayNetworking.send(RealmOfAlora.ID("keybind"), buf);
            }
        });
    }
}