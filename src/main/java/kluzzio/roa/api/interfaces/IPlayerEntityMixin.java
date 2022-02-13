package kluzzio.roa.api.interfaces;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface IPlayerEntityMixin {
    default void initDataTracker() {}
}