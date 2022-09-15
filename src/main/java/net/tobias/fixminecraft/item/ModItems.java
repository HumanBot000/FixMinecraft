package net.tobias.fixminecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tobias.fixminecraft.FixMinecraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FixMinecraft.MOD_ID);


    public static final RegistryObject<Item> REINFORCED_IRON = ITEMS.register("reinforced_iron",() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(128)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}