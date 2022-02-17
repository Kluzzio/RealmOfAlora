package kluzzio.roa.config;

import kluzzio.roa.enums.DevotionID;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import java.util.LinkedHashMap;

@Config(name = "roa_devotion_config")
public class RoaDevotionConfig implements ConfigData {

    public final LinkedHashMap<DevotionID, Integer> DEVOTION_THRESHOLDS = new LinkedHashMap<>();

    public RoaDevotionConfig() {

        //Configurable thresholds for devotion
        DEVOTION_THRESHOLDS.put(DevotionID.BLIND, 0);
        DEVOTION_THRESHOLDS.put(DevotionID.FOLLOWER, 250);
        DEVOTION_THRESHOLDS.put(DevotionID.WORSHIPPER, 500);
        DEVOTION_THRESHOLDS.put(DevotionID.DEVOTEE, 1000);
    }
}
