package kluzzio.roa.mixin;

import kluzzio.roa.api.util.FavorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {super(type, world);}

    @Inject(method = "onDeath", at = @At("HEAD"))
    public void deathModifyDevotion(DamageSource source, CallbackInfo ci) {
        if (source.getSource() instanceof PlayerEntity playerEntity) {
            FavorHelper.increaseDevotion(playerEntity, 1);
            //Output to Log
            //FavorHelper.decreaseDevotion(playerEntity, 1); I AM ECSTATIC! IT WORKS
        }
    }
}