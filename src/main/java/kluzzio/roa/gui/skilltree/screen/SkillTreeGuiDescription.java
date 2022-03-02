package kluzzio.roa.gui.skilltree.screen;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import kluzzio.roa.RealmOfAlora;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class SkillTreeGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 1;

    public SkillTreeGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(RealmOfAlora.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(300, 200);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4, 1);

        WSprite buttonImg = new WSprite(new Identifier("minecraft:textures/item/amethyst_shard.png"));
        root.add(buttonImg, 100, 10, 18, 18);

        // If I want the Player Inventory. I currently don't
        //root.add(this.createPlayerInventoryPanel(), 0, 3);

        WToggleButton toggleButton = new WToggleButton(new LiteralText("This is a toggle button."));
        toggleButton.setOnToggle(on -> {
            // This code runs on the client when you toggle the button.
            System.out.println("Toggle button toggled to " + (on ? "on" : "off"));
        });

        root.add(toggleButton, 100, 10, 18, 18);

        root.validate(this);
    }
}