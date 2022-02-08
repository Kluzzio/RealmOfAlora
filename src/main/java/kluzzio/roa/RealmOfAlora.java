package kluzzio.roa;

import net.fabricmc.api.ModInitializer;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealmOfAlora implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("roa");

	public static final Identifier DEVOTION_TO_ALORA = new Identifier("roa", "devotion_to_alora");

	@Override
	public void onInitialize() {
		Registry.register(Registry.CUSTOM_STAT, "devotion_to_alora", DEVOTION_TO_ALORA);
		Stats.CUSTOM.getOrCreateStat(DEVOTION_TO_ALORA, StatFormatter.DEFAULT);
	}
}