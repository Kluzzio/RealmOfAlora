package kluzzio.roa.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow protected abstract void playBlockFallSound();

    @Shadow protected abstract void playEquipmentBreakEffects(ItemStack stack);

    public LivingEntityMixin(EntityType<?> type, World world) {super(type, world);}

    @Inject(method = "onDeath", at = @At("HEAD"))
    public void deathModifyDevotion(DamageSource source, CallbackInfo ci) {
        if (source.getSource() instanceof PlayerEntity playerEntity) {
            //if (source.getSource() instanceof LivingEntity devotee)
            //((PlayerEntityMixin) devotee).roa$setDevotion(1);
            //playerEntity
        }
    }
}