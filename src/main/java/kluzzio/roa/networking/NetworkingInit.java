package kluzzio.roa.networking;

import kluzzio.roa.RealmOfAlora;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class NetworkingInit {

    public static void init() {

        // Skill Tree receiver
        ServerPlayNetworking.registerGlobalReceiver(RealmOfAlora.ID("effect_value"), (server, player, handler, buf, responseSender) -> {
            if (buf.readBoolean())
                player.giveItemStack(new ItemStack(Items.EMERALD));
        });

        // Skill Tree receiver
        ServerPlayNetworking.registerGlobalReceiver(RealmOfAlora.ID("keybind"), (server, player, handler, buf, responseSender) -> {
            boolean keybindBool = buf.readBoolean();
            server.execute(() -> {
                ItemStack feetstack = player.getEquippedStack(EquipmentSlot.FEET);
                if (!feetstack.isEmpty()) {
                    feetstack.getOrCreateNbt().putBoolean("keybinding", keybindBool);
                }
            });
        });
    }
}