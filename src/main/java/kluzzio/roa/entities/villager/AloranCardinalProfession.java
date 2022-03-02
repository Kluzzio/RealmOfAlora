package kluzzio.roa.entities.villager;

import kluzzio.roa.RealmOfAlora;
import kluzzio.roa.blocks.BlocksInit;
import kluzzio.roa.enums.BlocksID;
import kluzzio.roa.enums.ItemsID;
import kluzzio.roa.factories.AloranTradeFactory;
import kluzzio.roa.items.ItemsInit;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class AloranCardinalProfession {

    public static final PointOfInterestType ALORAN_CARDINAL_POI =
            PointOfInterestHelper.register(
            RealmOfAlora.ID("aloran_cardinal_poi"),
            5,
            5,
            BlocksInit.ALTAR_OF_ALORA
    );
    public static final VillagerProfession ALORAN_CARDINAL =
            VillagerProfessionBuilder.create()
                    .id(RealmOfAlora.ID("aloran_cardinal"))
                    .workstation(ALORAN_CARDINAL_POI)
                    .workSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_PLACE)
                    .build();

    public static void init() {
        // Register
        Registry.register(Registry.VILLAGER_PROFESSION, RealmOfAlora.ID("aloran_cardinal"), ALORAN_CARDINAL);

        /* New Trades */
        // Level 1
        TradeOfferHelper.registerVillagerOffers(ALORAN_CARDINAL, 1,
                factories -> factories.add(
                        AloranTradeFactory.createTrade(
                                Items.AMETHYST_SHARD, 32,
                                BlocksInit.ROA_BLOCKS.get(BlocksID.CHALICE_OF_ALORA).asItem(), 1,
                                8, 8, 1)
                )
        );
        // Level 3
        TradeOfferHelper.registerVillagerOffers(ALORAN_CARDINAL, 3,
                factories -> factories.add(
                        AloranTradeFactory.createTrade(
                                Items.AMETHYST_SHARD, 16, Items.ENDER_EYE, 4,
                                ItemsInit.ROA_ITEMS.get(ItemsID.DIVINE_MEDALLION), 1,
                                8, 4, 1)
                )
        );
        // Level 5
        TradeOfferHelper.registerVillagerOffers(ALORAN_CARDINAL, 5,
                factories -> factories.add(
                        AloranTradeFactory.createTrade(
                                Items.NETHERITE_BLOCK, 64,
                                Items.BUDDING_AMETHYST, 1,
                                1, 0, 100)
                )
        );
    }
}