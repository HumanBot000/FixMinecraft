package net.tobias.fixminecraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tobias.fixminecraft.FixMinecraft;
import net.tobias.fixminecraft.item.ModCreativeModeTab;
import net.tobias.fixminecraft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FixMinecraft.MOD_ID);

    public static final RegistryObject<Block> REINFORCED_IRON_BLOCK =registerBlock("reinforced_iron_block",()  -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(20f).jumpFactor(0.5f).explosionResistance(4f)), ModCreativeModeTab.FixMinecraft_Tab);



    //Do some register Stuff
    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerItem(name,toReturn,tab);
        return toReturn;
    }
    private static<T extends Block>RegistryObject<Item> registerItem(String name,RegistryObject<T> block,CreativeModeTab tab){
        return ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
