package fr.lopotichaaaa.yetanotherrpgmod.block;

import fr.lopotichaaaa.yetanotherrpgmod.YetAnotherRPGMod;
import fr.lopotichaaaa.yetanotherrpgmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    /**
     * Contains all the Blocks of the mod
     */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YetAnotherRPGMod.MOD_ID);

    public static final DeferredBlock<Block> STELLARIUM_BLOCK = registerBlock("stellarium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<Block> INFUSED_STELLARIUM_BLOCK = registerBlock("infused_stellarium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops().
                    sound(SoundType.AMETHYST)
            ));

    /**
     * create a block and automatically create the item associated
     * @param name the n,ame of the block
     * @param block the block supplier
     * @return the block created
     * @param <T> the type of the block
     */
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }


    /**
     * allows to automatically register an item associated to the block
     * @param name the name of the block
     * @param block the block associated to the item
     * @param <T> the type of the block
     */
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    /**
     * Used to register the blocks contained in BLOCKS into the eventBus
     * @param eventBus where the blocks will be registered
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
