package com.myname.bouncingball;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbox.bus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// ID мода должен совпадать с тем, что в mods.toml
@Mod("bouncingball")
public class BouncingBallMod {

    // Регистратор предметов
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bouncingball");

    // Создаем предмет "Мячик"
    // Мы используем SnowballItem, так как у него уже прописана физика полета
    public static final RegistryObject<Item> SUPER_BALL = ITEMS.register("super_ball", 
        () -> new SnowballItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));

    public BouncingBallMod() {
        // Получаем шину событий
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Регистрируем предметы
        ITEMS.register(modEventBus);
        
        // Регистрируем сам мод
        MinecraftForge.EVENT_BUS.register(this);
    }
}
