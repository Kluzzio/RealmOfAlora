package kluzzio.roa.mixin;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.api.interfaces.IDevotionEntity;
import kluzzio.roa.enums.DevotionID;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin
        extends LivingEntity
        implements IDevotionEntity {

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    private static final TrackedData<Integer> DEVOTION = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final int blind = RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.BLIND);

    @Override
    public DataTracker getDataTracker(){ return dataTracker; }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    protected void injectInitDataTracker(CallbackInfo ci) {
        dataTracker.startTracking(DEVOTION, blind);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void injectWriteCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("Devotion", getDevotion());
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    public void injectReadCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        setDevotion(nbt.getInt("Devotion"));
    }

    public int getMaxDevotion() { return RealmOfAlora.config.roaDevotionConfig.DEVOTION_THRESHOLDS.get(DevotionID.DEVOTEE); }

    public int getDevotion() { return dataTracker.get(DEVOTION); }

    public void setDevotion(int devotion) {
        if (devotion >= blind)
            dataTracker.set(DEVOTION, MathHelper.clamp(devotion, blind, getMaxDevotion()));
    }
}