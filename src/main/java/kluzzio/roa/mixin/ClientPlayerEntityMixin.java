package kluzzio.roa.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntityMixin.class)
public abstract class ClientPlayerEntityMixin extends Entity {

    public ClientPlayerEntityMixin(EntityType<?> type, World world, DataTracker dataTracker) {
        super(type, world);
        this.dataTracker = dataTracker;
        this.dataTracker.startTracking(DEVOTION, 0);
    }

    protected final DataTracker dataTracker;

    protected abstract void initDataTracker();

    public DataTracker getDataTracker() {
        return this.dataTracker;
    }

    private static final TrackedData<Integer> DEVOTION;

    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt("Devotion", this.getDevotion());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Devotion", DEVOTION.getId())) {
            this.setDevotion(nbt.getInt("Devotion"));
        }
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

    public int getDevotion() { return this.dataTracker.get(DEVOTION); }

    public void setDevotion(int devotion) {
        this.dataTracker.set(DEVOTION, MathHelper.clamp(devotion, 0, this.getMaxDevotion()));
    }

    static {
        DEVOTION = DataTracker.registerData(ClientPlayerEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
