package com.roburrito.copper_plus.common;

import com.google.common.base.Supplier;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum CopperTiers implements Tier {
    COPPER(1, 250, 4.0F, 1.0F, 5, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;
    
    CopperTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }
    
    public int getUses() {
        return maxUses;
    }

    public float getSpeed() {
        return efficiency;
    }

    public float getAttackDamageBonus() {
        return attackDamage;
    }

    public int getLevel() {
        return harvestLevel;
    }

    public int getEnchantmentValue() {
        return enchantability;
    }

    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
    
}