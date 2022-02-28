package kluzzio.roa.blocks.blockentities;

import kluzzio.roa.blocks.BlocksInit;
import kluzzio.roa.enums.BlocksID;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntitiesInit {
    public static BlockEntityType<AltarOfAloraBlockEntity> ALTAR_OF_ALORA_BLOCK_ENTITY;

    public static void init() {
        ALTAR_OF_ALORA_BLOCK_ENTITY =
                Registry.register(
                        Registry.BLOCK_ENTITY_TYPE,
                        "roa:altar_of_alora_block_entity",
                        FabricBlockEntityTypeBuilder.create(AltarOfAloraBlockEntity::new, BlocksInit.ROA_BLOCKS.get(BlocksID.ALTAR_OF_ALORA))
                                .build(null));
    }
}