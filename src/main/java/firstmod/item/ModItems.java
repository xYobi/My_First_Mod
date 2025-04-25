package firstmod.item;

import firstmod.MyFirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

        public static final Item DRAGONS_DIAMOND = register("dragons_diamond",Item::new,new Item.Settings());
        public static final Item LORDS_INGOT = register("lords_ingot",Item::new,new Item.Settings());

        public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
            // Create the item key.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyFirstMod.MOD_ID, name));
            // Create the item instance.
            Item item = itemFactory.apply(settings.registryKey(itemKey));
            // Register the item.
            Registry.register(Registries.ITEM, itemKey, item);
            return item;
        }

    public static void initialize(){
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((fabricItemGroupEntries -> {
                fabricItemGroupEntries.add(DRAGONS_DIAMOND);
                fabricItemGroupEntries.add(LORDS_INGOT);

            }));

    };
  //  public static final Item PINK_GARNET=registerItem("pink_garnet",new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyFirstMod.MOD_ID,"pink_garnet")))));

  //  private static Item registerItem(String name, Item item) {
  //      return Registry.register(Registries.ITEM, Identifier.of(MyFirstMod.MOD_ID,name),item);
  //  }



  //  public static void registerModItems() {
    //    MyFirstMod.LOGGER.info("Registering Mod Items for" + MyFirstMod.MOD_ID);
    //    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
   //         fabricItemGroupEntries.add(PINK_GARNET);

    //    });
  //  }
}
