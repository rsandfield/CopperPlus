package com.roburrito.copper_plus.common;

import com.google.common.base.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CopperArmorMaterials implements ArmorMaterial {
    Copper("copper", 5, new int[]{1, 4, 5, 2}, 18, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
       return Ingredient.of(Items.COPPER_INGOT);
    });
 
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;
 
    private CopperArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
       this.name = name;
       this.durabilityMultiplier = durabilityMultiplier;
       this.slotProtections = slotProtections;
       this.enchantmentValue = enchantmentValue;
       this.sound = sound;
       this.toughness = toughness;
       this.knockbackResistance = knockbackResistance;
       this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
       return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }
 
    public int getDefenseForSlot(EquipmentSlot slot) {
       return this.slotProtections[slot.getIndex()];
    }
 
    public int getEnchantmentValue() {
       return this.enchantmentValue;
    }
 
    public SoundEvent getEquipSound() {
       return this.sound;
    }
 
    public Ingredient getRepairIngredient() {
       return this.repairIngredient.get();
    }
 
    public String getName() {
       return this.name;
    }
 
    public float getToughness() {
       return this.toughness;
    }
 
    public float getKnockbackResistance() {
       return this.knockbackResistance;
    }
}