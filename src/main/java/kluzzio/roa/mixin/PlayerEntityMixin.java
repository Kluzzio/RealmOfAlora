package kluzzio.roa.mixin;

import kluzzio.roa.api.interfaces.IDevotionEntity;
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
public abstract class PlayerEntityMixin
        extends LivingEntity
        implements IDevotionEntity {

    private int devotion;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world, DataTracker dataTracker) {
        super(entityType, world);
        this.dataTracker = dataTracker;
    }

    private final DataTracker dataTracker;

    static {
    //    DEVOTION = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    //protected static final TrackedData<Integer> DEVOTION;

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    protected void injectInitDataTracker(CallbackInfo ci) {
   //     this.dataTracker.startTracking(DEVOTION, 0);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void injectWriteCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        //nbt.putInt("Devotion", this.getDevotion());
        nbt.putInt("Devotion", this.devotion);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void injectReadCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.devotion = nbt.getInt("Devotion");
    }

    public void increaseDevotion(int amount) {
        int f = this.getDevotion();
        this.setDevotion(f + amount);
    }

    public void decreaseDevotion(int amount) {
        int f = this.getDevotion();
        this.setDevotion(f - amount);
    }

    public int getMaxDevotion() { return 500; }

    //public int getDevotion() { return this.dataTracker.get(DEVOTION); }

    public void setDevotion(int devotion) {
   //     this.dataTracker.set(DEVOTION, MathHelper.clamp(devotion, 0, this.getMaxDevotion()));
    }
}