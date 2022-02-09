package kluzzio.roa.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DevotedEntity extends PlayerEntity {

    public DevotedEntity(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    static {
        DEVOTION = DataTracker.registerData(DevotedEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    protected static final TrackedData<Integer> DEVOTION;

    protected void initDataTracker() {
        this.dataTracker.startTracking(DEVOTION, 0);
    }

    public DataTracker getDataTracker() {
        return this.dataTracker;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt("Devotion", this.getDevotion());
    }

    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return null;
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
}
