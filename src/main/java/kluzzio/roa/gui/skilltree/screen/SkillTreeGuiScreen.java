package kluzzio.roa.gui.skilltree.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class SkillTreeGuiScreen extends CottonInventoryScreen<SkillTreeGuiDescription> {
    public SkillTreeGuiScreen(SkillTreeGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}