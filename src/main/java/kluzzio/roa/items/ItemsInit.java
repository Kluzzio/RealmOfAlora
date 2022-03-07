package kluzzio.roa.items;

import kluzzio.roa.enums.ItemsID;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import java.util.EnumMap;

import static kluzzio.roa.RealmOfAlora.ID;

public class ItemsInit {
    public static final EnumMap<ItemsID, Item> ROA_ITEMS = new EnumMap<>(ItemsID.class);
    public static final DivineMedallion DIVINE_MEDALLION = new DivineMedallion(new Item.Settings().group(ItemGroup.MISC).maxCount(1));

    public static void init() {

        ROA_ITEMS.put(ItemsID.DIVINE_MEDALLION, DIVINE_MEDALLION);
        registerItem(ItemsID.DIVINE_MEDALLION.toString().toLowerCase(), DIVINE_MEDALLION);
    }
    protected static void registerItem(String id, Item item) {
        Registry.register(Registry.ITEM, ID(id), item);
    }
}