package kluzzio.roa.config;

import kluzzio.roa.enums.DevotionID;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.LinkedHashMap;

@Config(name = "roa_devotion_config")
public class RoaDevotionConfig implements ConfigData {

    @Comment("These are thresholds in order. It is recommended that the general ratios are kept the same.\n" +
            "Support will not be provided to those who do not follow this recommendation.")
    public final LinkedHashMap<DevotionID, Integer> DEVOTION_THRESHOLDS = new LinkedHashMap<>();

    @Comment("When a great deed (various actions) are performed, the player will gain this much devotion.")
    public final Integer GREAT_DEED_BONUS_DEVOTION = 30;

    public RoaDevotionConfig() {

        //Configurable thresholds for devotion
        DEVOTION_THRESHOLDS.put(DevotionID.BLIND, 0);
        DEVOTION_THRESHOLDS.put(DevotionID.FOLLOWER, 250);
        DEVOTION_THRESHOLDS.put(DevotionID.WORSHIPPER, 500);
        DEVOTION_THRESHOLDS.put(DevotionID.DEVOTEE, 1000);
    }
}