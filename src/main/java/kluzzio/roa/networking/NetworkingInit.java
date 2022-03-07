package kluzzio.roa.networking;

import kluzzio.roa.RealmOfAlora;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class NetworkingInit {

    public static void init() {

        // Skill Tree receiver
        ServerPlayNetworking.registerGlobalReceiver(RealmOfAlora.ID("effect_value"), (server, player, handler, buf, responseSender) -> {
            if (buf.readBoolean())
                player.giveItemStack(new ItemStack(Items.EMERALD));
        });
    }
}