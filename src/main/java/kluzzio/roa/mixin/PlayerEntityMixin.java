package kluzzio.roa.mixin;

import kluzzio.roa.api.util.FavorHelper;
import kluzzio.roa.api.util.InventoryHelper;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    public void roa$onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity damagedPlayer = (PlayerEntity) (Object) this;
        if (source.getAttacker() instanceof PlayerEntity attackingPlayer) {
            if (FavorHelper.getDevotion(damagedPlayer) > FavorHelper.worshipper && InventoryHelper.roa$hasChalice(damagedPlayer)) {
                FavorHelper.greatMisdeed(attackingPlayer);
            }
        }
    }
}