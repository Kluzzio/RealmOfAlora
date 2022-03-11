package kluzzio.roa.gui.skilltree.screen;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.gui.skilltree.buttons.EffectButton;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Identifier;

public class SkillTreeGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 0;

    public SkillTreeGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(RealmOfAlora.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(200, 300);
        root.setInsets(Insets.ROOT_PANEL);

        WSprite backgroundTexture = new WSprite(new Identifier("roa:textures/client/gui/background.png"));
        root.add(backgroundTexture, 0, 0, 200, 300);


        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4, 1);

        WSprite buttonImg = new WSprite(new Identifier("minecraft:textures/item/amethyst_shard.png"));
        root.add(buttonImg, 100, 10, 18, 18);

        // Change to nbt check

        /*
        if(!child.hasnbt) {
            root.add(child);
            if (!parent.hasnbt)
                root.add(parent);
            }
        }
        */

        if (!playerInventory.contains(new ItemStack(Items.EMERALD))) {

            EffectButton toggleButton = new EffectButton();
            toggleButton.setOnToggle(on -> {
                // This code runs on the client when you toggle the button.
                System.out.println("Toggle button toggled to " + (on ? "on" : "off"));
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeBoolean(true);

                ClientPlayNetworking.send(RealmOfAlora.ID("effect_value"), buf);
                root.remove(toggleButton);
            });
            root.add(toggleButton, 100, 10, 18, 18);
        }

        root.validate(this);
    }
}