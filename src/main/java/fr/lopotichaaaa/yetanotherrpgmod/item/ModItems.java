package fr.lopotichaaaa.yetanotherrpgmod.item;

import fr.lopotichaaaa.yetanotherrpgmod.YetAnotherRPGMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    /**
     * Contains all the Item Classes of the mod
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YetAnotherRPGMod.MOD_ID);

    public static final DeferredItem<Item> STELLARIUM = ITEMS.register("stellarium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INFUSED_STELLARIUM = ITEMS.register("infused_stellarium",
            () -> new Item(new Item.Properties()));

    /**
     * Used to register the items contained in ITEMS into the eventBus
     * @param eventBus where the items will be registered
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
