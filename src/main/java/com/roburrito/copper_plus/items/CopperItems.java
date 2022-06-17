package com.roburrito.copper_plus.items;

import com.roburrito.copper_plus.CopperPlus;
import com.roburrito.copper_plus.common.CopperArmorMaterials;
import com.roburrito.copper_plus.common.CopperTiers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CopperItems {   
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CopperPlus.MODID);

    public static final CreativeModeTab COPPER_CREATIVE_TAB = new CreativeModeTab(CreativeModeTab.TABS.length, CopperPlus.MODID) {
        @Override
        // CLIENT-SIDED
        public ItemStack makeIcon() {
            return new ItemStack(Items.COPPER_INGOT);
        }
    };


    private static final Item.Properties copperProperties = new Item.Properties()
        .tab(COPPER_CREATIVE_TAB);
    
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CopperTiers.COPPER, 1, -2.8F, copperProperties));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CopperTiers.COPPER, 6f, -3.1f, copperProperties));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CopperTiers.COPPER, 1.5F, -3.1F, copperProperties));
    public static final RegistryObject<Item> COPPER_SHEARS = ITEMS.register("copper_shears", () -> new ShearsItem(copperProperties));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(CopperTiers.COPPER, -1, -2.0f, copperProperties));

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CopperTiers.COPPER, 3, -2.4f, copperProperties));
        
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(CopperArmorMaterials.Copper, EquipmentSlot.HEAD, copperProperties));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(CopperArmorMaterials.Copper, EquipmentSlot.CHEST, copperProperties));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(CopperArmorMaterials.Copper, EquipmentSlot.LEGS, copperProperties));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(CopperArmorMaterials.Copper, EquipmentSlot.FEET, copperProperties));

    public static final RegistryObject<Item> HAND_BELL = ITEMS.register("hand_bell", () -> new HandBell((new Item.Properties()).tab(COPPER_CREATIVE_TAB).durability(16)));
}
