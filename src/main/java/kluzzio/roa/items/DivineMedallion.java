package kluzzio.roa.items;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.api.util.EntityHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class DivineMedallion extends Item {

    public DivineMedallion(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        if ((hit != null ? hit.getType() : null) == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) hit;
            if (entityHit.getEntity() instanceof LivingEntity le) {
                if (EntityHelper.validEntityType(le)) {
                    int devotion = RealmOfAlora.config.roaEntityDevotionConfig.REWARD_OF_ALORA.get(le.getType());
                    player.sendMessage(Text.of(String.valueOf(devotion)), true);
                    // TODO Implement fully
                }
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }
}
