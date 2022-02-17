package kluzzio.roa.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.entity.*;

import java.util.LinkedHashMap;
import java.util.List;

@Config(name = "roa_entity_devotion_config")
public class RoaEntityDevotionConfig implements ConfigData {

    public final LinkedHashMap<EntityType<? extends Entity>, Boolean> TARGET_OF_ALORA = new LinkedHashMap<>();
    public final LinkedHashMap<EntityType<? extends Entity>, Integer> REWARD_OF_ALORA = new LinkedHashMap<>();

    public static final List<EntityType<? extends Entity>> POS_ENTITY_TYPE_LIST = List.of(EntityType.BAT, EntityType.BEE, EntityType.BLAZE,
            EntityType.CAVE_SPIDER, EntityType.CHICKEN, EntityType.COD, EntityType.COW, EntityType.CREEPER, EntityType.DONKEY, EntityType.DROWNED,
            EntityType.ELDER_GUARDIAN, EntityType.ENDER_DRAGON, EntityType.ENDERMITE, EntityType.EVOKER, EntityType.GHAST, EntityType.GLOW_SQUID,
            EntityType.GOAT, EntityType.GUARDIAN, EntityType.HOGLIN, EntityType.HORSE, EntityType.HUSK, EntityType.IRON_GOLEM, EntityType.LLAMA,
            EntityType.MAGMA_CUBE, EntityType.MULE, EntityType.MOOSHROOM, EntityType.OCELOT, EntityType.PANDA, EntityType.PARROT, EntityType.PHANTOM, EntityType.PIG,
            EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.PILLAGER, EntityType.POLAR_BEAR, EntityType.PUFFERFISH, EntityType.RABBIT,
            EntityType.RAVAGER, EntityType.SALMON, EntityType.SHEEP, EntityType.SHULKER, EntityType.SILVERFISH, EntityType.SKELETON, EntityType.SKELETON_HORSE,
            EntityType.SLIME, EntityType.SNOW_GOLEM, EntityType.SPIDER, EntityType.SQUID, EntityType.STRAY, EntityType.STRIDER, EntityType.TRADER_LLAMA,
            EntityType.TROPICAL_FISH, EntityType.TURTLE, EntityType.VEX, EntityType.VILLAGER, EntityType.VINDICATOR, EntityType.WANDERING_TRADER,
            EntityType.WITCH, EntityType.WITHER, EntityType.WITHER_SKELETON, EntityType.ZOGLIN, EntityType.ZOMBIE, EntityType.ZOMBIE_HORSE, EntityType.ZOMBIE_VILLAGER,
            EntityType.ZOMBIFIED_PIGLIN);

    public static final List<EntityType<? extends Entity>> NEG_ENTITY_TYPE_LIST = List.of(EntityType.AXOLOTL, EntityType.CAT, EntityType.DOLPHIN,
            EntityType.ENDERMAN, EntityType.FOX, EntityType.WOLF);

    public RoaEntityDevotionConfig() {

        /* Entity Devotion Alignment */

        //Default Positive Devotion
        for (EntityType<? extends Entity> entityType : POS_ENTITY_TYPE_LIST)
            TARGET_OF_ALORA.put(entityType, true);

        //Default Negative Devotion
        for (EntityType<? extends Entity> entityType : NEG_ENTITY_TYPE_LIST)
            TARGET_OF_ALORA.put(entityType, false);

        //ASSIGN VALUES
        REWARD_OF_ALORA.put(EntityType.AXOLOTL, 10);
        REWARD_OF_ALORA.put(EntityType.BAT, 20);
        REWARD_OF_ALORA.put(EntityType.BEE, 2);
        REWARD_OF_ALORA.put(EntityType.BLAZE, 3);
        REWARD_OF_ALORA.put(EntityType.CAT, 9);
        REWARD_OF_ALORA.put(EntityType.CAVE_SPIDER, 8);
        REWARD_OF_ALORA.put(EntityType.CHICKEN, 1);
        REWARD_OF_ALORA.put(EntityType.COD, 1);
        REWARD_OF_ALORA.put(EntityType.COW, 1);
        REWARD_OF_ALORA.put(EntityType.CREEPER, 4);
        REWARD_OF_ALORA.put(EntityType.DOLPHIN, 15);
        REWARD_OF_ALORA.put(EntityType.DONKEY, 5);
        REWARD_OF_ALORA.put(EntityType.DROWNED, 4);
        REWARD_OF_ALORA.put(EntityType.ELDER_GUARDIAN, 30);
        REWARD_OF_ALORA.put(EntityType.ENDER_DRAGON, 50);
        REWARD_OF_ALORA.put(EntityType.ENDERMAN, 2);
        REWARD_OF_ALORA.put(EntityType.ENDERMITE, 5);
        REWARD_OF_ALORA.put(EntityType.EVOKER, 4);
        REWARD_OF_ALORA.put(EntityType.FOX, 7);
        REWARD_OF_ALORA.put(EntityType.GHAST, 4);
        REWARD_OF_ALORA.put(EntityType.GLOW_SQUID, 2);
        REWARD_OF_ALORA.put(EntityType.GOAT, 2);
        REWARD_OF_ALORA.put(EntityType.GUARDIAN, 5);
        REWARD_OF_ALORA.put(EntityType.HOGLIN, 4);
        REWARD_OF_ALORA.put(EntityType.HORSE, 2);
        REWARD_OF_ALORA.put(EntityType.HUSK, 4);
        REWARD_OF_ALORA.put(EntityType.IRON_GOLEM, 6);
        REWARD_OF_ALORA.put(EntityType.LLAMA, 8);
        REWARD_OF_ALORA.put(EntityType.MAGMA_CUBE, 2);
        REWARD_OF_ALORA.put(EntityType.MULE, 10);
        REWARD_OF_ALORA.put(EntityType.MOOSHROOM, 14);
        REWARD_OF_ALORA.put(EntityType.OCELOT, 8);
        REWARD_OF_ALORA.put(EntityType.PANDA, 4);
        REWARD_OF_ALORA.put(EntityType.PARROT, 1);
        REWARD_OF_ALORA.put(EntityType.PHANTOM, 10);
        REWARD_OF_ALORA.put(EntityType.PIG, 1);
        REWARD_OF_ALORA.put(EntityType.PIGLIN, 2);
        REWARD_OF_ALORA.put(EntityType.PIGLIN_BRUTE, 6);
        REWARD_OF_ALORA.put(EntityType.PILLAGER, 3);
        REWARD_OF_ALORA.put(EntityType.POLAR_BEAR, 2);
        REWARD_OF_ALORA.put(EntityType.PUFFERFISH, 1);
        REWARD_OF_ALORA.put(EntityType.RABBIT, 1);
        REWARD_OF_ALORA.put(EntityType.RAVAGER, 17);
        REWARD_OF_ALORA.put(EntityType.SALMON, 1);
        REWARD_OF_ALORA.put(EntityType.SHEEP, 1);
        REWARD_OF_ALORA.put(EntityType.SHULKER, 3);
        REWARD_OF_ALORA.put(EntityType.SILVERFISH, 13);
        REWARD_OF_ALORA.put(EntityType.SKELETON, 3);
        REWARD_OF_ALORA.put(EntityType.SKELETON_HORSE, 25);
        REWARD_OF_ALORA.put(EntityType.SLIME, 4);
        REWARD_OF_ALORA.put(EntityType.SNOW_GOLEM, 12);
        REWARD_OF_ALORA.put(EntityType.SPIDER, 3);
        REWARD_OF_ALORA.put(EntityType.SQUID, 1);
        REWARD_OF_ALORA.put(EntityType.STRAY, 3);
        REWARD_OF_ALORA.put(EntityType.STRIDER, 2);
        REWARD_OF_ALORA.put(EntityType.TRADER_LLAMA, 7);
        REWARD_OF_ALORA.put(EntityType.TROPICAL_FISH, 1);
        REWARD_OF_ALORA.put(EntityType.TURTLE, 1);
        REWARD_OF_ALORA.put(EntityType.VEX, 6);
        REWARD_OF_ALORA.put(EntityType.VILLAGER, 3);
        REWARD_OF_ALORA.put(EntityType.VINDICATOR, 5);
        REWARD_OF_ALORA.put(EntityType.WANDERING_TRADER, 10);
        REWARD_OF_ALORA.put(EntityType.WITCH, 5);
        REWARD_OF_ALORA.put(EntityType.WITHER, 42);
        REWARD_OF_ALORA.put(EntityType.WITHER_SKELETON, 11);
        REWARD_OF_ALORA.put(EntityType.WOLF, 12);
        REWARD_OF_ALORA.put(EntityType.ZOGLIN, 6);
        REWARD_OF_ALORA.put(EntityType.ZOMBIE, 2);
        REWARD_OF_ALORA.put(EntityType.ZOMBIE_HORSE, 25);
        REWARD_OF_ALORA.put(EntityType.ZOMBIE_VILLAGER, 6);
        REWARD_OF_ALORA.put(EntityType.ZOMBIFIED_PIGLIN, 7);
    }
}