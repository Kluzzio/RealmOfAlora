package kluzzio.roa.config;

import kluzzio.roa.api.util.EntityHelper;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.entity.*;

import java.util.LinkedHashMap;
import java.util.List;

@Config(name = "roa_entity_devotion_config")
public class RoaEntityDevotionConfig implements ConfigData {

    @Comment("When entity dies, if entity is a TARGET_OF_ALORA, GAIN devotion equal to REWARD_OF_ALORA. Otherwise, LOSE that much.")
    public final LinkedHashMap<EntityType<? extends Entity>, Boolean> TARGET_OF_ALORA = new LinkedHashMap<>();
    public final LinkedHashMap<EntityType<? extends Entity>, Integer> REWARD_OF_ALORA = new LinkedHashMap<>();

    /* Messages from the Medallion */

    @Comment("""
            The following is related to what message is played when using the divine medallion item on an entity.\s
            The number is the threshold under which the message will play.\s
            It is advised that you leave these alone for the most part.
            """)

    // Low Messages
    public final int LOW_THRESHOLD_POSITIVE = 5;
    public final int LOW_THRESHOLD_NEGATIVE = 5;

    public final String LOW_MESSAGE_POSITIVE = "I love to watch it squirm";
    public final String LOW_MESSAGE_NEGATIVE = "Leave it alone. This one is a friend";

    // Medium Messages
    public final int MED_THRESHOLD_POSITIVE = 15;
    public final int MED_THRESHOLD_NEGATIVE = 15;

    public final String MED_MESSAGE_POSITIVE = "Vile creatures, eliminate it";
    public final String MED_MESSAGE_NEGATIVE = "Execution is out of the question";

    // High Messages
    public final String HIGH_MESSAGE_POSITIVE = "Purge this one and all like it. They have no place here";
    public final String HIGH_MESSAGE_NEGATIVE = "Don't dare to touch this one. Its life is above yours";

    // Neutral Message
    @Comment("This is correlated to any entity that neither adds nor lowers devotion")
    public final String NEUTRAL_MESSAGE = "It is irrelevant, do as you wish";

    // Special Messages
    @Comment("The following are special to specific mobs. Disable them if you change the respective mob's devotion \n" +
            "reward to be negative when it was positive or vice versa.")
    public final boolean ENDERMAN_SP_MESSAGE = true;
    public final String ENDERMAN_MESSAGE = "I find them funny, move along";

    public RoaEntityDevotionConfig() {

        /* Entity Devotion Alignment */

        //Default Positive Devotion
        for (EntityType<? extends Entity> entityType : EntityHelper.POS_ENTITY_TYPE_LIST)
            TARGET_OF_ALORA.put(entityType, true);

        //Default Negative Devotion
        for (EntityType<? extends Entity> entityType : EntityHelper.NEG_ENTITY_TYPE_LIST)
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
        REWARD_OF_ALORA.put(EntityType.PIGLIN, 3);
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
        REWARD_OF_ALORA.put(EntityType.TRADER_LLAMA, 12);
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