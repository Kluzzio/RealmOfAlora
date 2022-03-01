package kluzzio.roa.gui.skilltree.screen;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SkillTreeGui extends LightweightGuiDescription {

    public SkillTreeGui() {
        super();
        //WPlainPanel root = new WPlainPanel();
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 300);
        root.setInsets(Insets.ROOT_PANEL);

        WSprite buttonImg = new WSprite(new Identifier("minecraft:textures/item/amethyst_shard.png"));
        root.add(buttonImg, 100, 10, 2 , 5);
        root.validate(this);
    }

}