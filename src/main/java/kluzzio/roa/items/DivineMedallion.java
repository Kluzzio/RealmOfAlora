package kluzzio.roa.items;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.api.util.EntityHelper;
import kluzzio.roa.api.util.FavorHelper;
import kluzzio.roa.config.RoaEntityDevotionConfig;
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
                if (alorasWill(le, player))
                    return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
            }
        }
        return new TypedActionResult<>(ActionResult.FAIL, itemStack);
    }

    private static Boolean alorasWill(LivingEntity le, PlayerEntity player) {
        String stringToSend;
        if (EntityHelper.validEntityType(le)) {
            RoaEntityDevotionConfig rEDC = RealmOfAlora.config.roaEntityDevotionConfig;
            int devotion = rEDC.REWARD_OF_ALORA.get(le.getType());
            //Entity rewards no devotion
            if (devotion == 0) {
                stringToSend = rEDC.NEUTRAL_MESSAGE;
                player.sendMessage(Text.of(stringToSend), true);
                return true;
            }
            //Entity is positive
            if (rEDC.TARGET_OF_ALORA.get(le.getType())) {
                if (devotion > rEDC.MED_THRESHOLD_POSITIVE)
                    stringToSend = rEDC.HIGH_MESSAGE_POSITIVE;
                else if (devotion > rEDC.LOW_THRESHOLD_POSITIVE)
                    stringToSend = rEDC.MED_MESSAGE_POSITIVE;
                else
                    stringToSend = rEDC.LOW_MESSAGE_POSITIVE;
            } else { //Entity is negative
                if (devotion > rEDC.MED_THRESHOLD_NEGATIVE)
                    stringToSend = rEDC.HIGH_MESSAGE_NEGATIVE;
                else if (devotion > rEDC.LOW_THRESHOLD_NEGATIVE)
                    stringToSend = rEDC.MED_MESSAGE_NEGATIVE;
                else
                    stringToSend = rEDC.LOW_MESSAGE_NEGATIVE;
            }
            player.sendMessage(Text.of(stringToSend), true);
            return true;
        } else if (le instanceof PlayerEntity pe) { //Entity is player
            if (FavorHelper.getDevotion(pe) >= FavorHelper.worshipper) {
                stringToSend = "Do not fight your kin, they are my child as are you";
                player.sendMessage(Text.of(stringToSend), true);
                return true;
            }
        }
        //Entity is not player or vanilla mob
        return false;
    }
}
