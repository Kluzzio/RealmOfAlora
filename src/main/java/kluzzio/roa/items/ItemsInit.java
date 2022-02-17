package kluzzio.roa.items;

import kluzzio.roa.enums.ItemsID;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import java.util.EnumMap;

import static kluzzio.roa.RealmOfAlora.ID;

public class ItemsInit {
    public static final EnumMap<ItemsID, Item> ROA_ITEMS = new EnumMap<>(ItemsID.class);

    public static void init() {

        for (ItemsID itemsID : ItemsID.values()) {
            var roaItem = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(1));
            ROA_ITEMS.put(itemsID, roaItem);
            registerItem(itemsID.toString().toLowerCase(), roaItem);
        }
    }
    protected static void registerItem(String id, Item item) {
        Registry.register(Registry.ITEM, ID(id), item);
    }
}