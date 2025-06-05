package fr.lopotichaaaa.yetanotherrpgmod.item;

import fr.lopotichaaaa.yetanotherrpgmod.YetAnotherRPGMod;
import fr.lopotichaaaa.yetanotherrpgmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, YetAnotherRPGMod.MOD_ID
    );

    public static final Supplier<CreativeModeTab> STELLARIUM_ITEMS_TAB = CREATIVE_MODE_TABS.register("stellarium_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.STELLARIUM.get()))
                    .title(Component.translatable("creativetab.yetanotherrpgmod.stellarium_items"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModItems.STELLARIUM);
                        output.accept(ModItems.INFUSED_STELLARIUM);
                    })
                    .build()
    );

    public static final Supplier<CreativeModeTab> STELLARIUM_BLOCKS_TAB = CREATIVE_MODE_TABS.register("stellarium_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.STELLARIUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(YetAnotherRPGMod.MOD_ID, "stellarium_items_tab"))
                    .title(Component.translatable("creativetab.yetanotherrpgmod.stellarium_blocks"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModBlocks.STELLARIUM_BLOCK);
                        output.accept(ModBlocks.INFUSED_STELLARIUM_BLOCK);
                        output.accept(ModBlocks.STELLARIUM_ORE);
                        output.accept(ModBlocks.STELLARIUM_DEEPSLATE_ORE);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
