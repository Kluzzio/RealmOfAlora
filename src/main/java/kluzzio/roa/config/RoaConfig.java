package kluzzio.roa.config;

import kluzzio.roa.RealmOfAlora;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = RealmOfAlora.MOD_ID)
public class RoaConfig extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("roa_devotion_config")
    public RoaDevotionConfig roaDevotionConfig = new RoaDevotionConfig();

    @ConfigEntry.Category("roa_entity_devotion_config")
    public RoaEntityDevotionConfig roaEntityDevotionConfig = new RoaEntityDevotionConfig();

    public static void init() {
        AutoConfig.register(RoaConfig.class,
                PartitioningSerializer.wrap(JanksonConfigSerializer::new));
    }
}