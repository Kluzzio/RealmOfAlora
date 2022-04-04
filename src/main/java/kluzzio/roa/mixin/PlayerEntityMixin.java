package kluzzio.roa.mixin;

import kluzzio.roa.api.util.FavorHelper;
import kluzzio.roa.api.util.InventoryHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    public void roa$onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity damagedPlayer = (PlayerEntity) (Object) this;
        if (source.getAttacker() instanceof PlayerEntity attackingPlayer) {
            if (FavorHelper.getDevotion(damagedPlayer) >= FavorHelper.worshipper && InventoryHelper.roa$hasChalice(damagedPlayer)) {
                FavorHelper.greatMisdeed(attackingPlayer);
            }
        }
    }

    @Inject(method = "getMovementSpeed", at = @At("RETURN"), cancellable = true)
    public void roa$keybindTest(CallbackInfoReturnable<Float> cir) {
        if ((Object) this instanceof PlayerEntity player) {
            ItemStack feetstack = player.getEquippedStack(EquipmentSlot.FEET);
            if (feetstack == null || feetstack.getNbt() == null || feetstack.getNbt().get("keybinding") == null) return;
            if (feetstack.getNbt().getBoolean("keybinding")) {
                cir.setReturnValue(cir.getReturnValue() * 3);
            }
        }
    }
}