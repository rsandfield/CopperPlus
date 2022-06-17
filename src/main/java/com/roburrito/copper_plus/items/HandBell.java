package com.roburrito.copper_plus.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;

public class HandBell extends Item implements Vanishable {
    public HandBell (Item.Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand handUsed) {
        ItemStack itemstack = player.getItemInHand(handUsed);
        
        if(attemptToRing(player, world, player.blockPosition())) {
            itemstack.hurtAndBreak(1, player, (p) -> { p.broadcastBreakEvent(handUsed); });
            player.awardStat(Stats.BELL_RING);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    void right(@Nullable Player player, Level world) {
        boolean flag1 = this.attemptToRing(player, world, player.blockPosition());
         if (flag1 && player != null) {
            player.awardStat(Stats.BELL_RING);
         }
    }

    boolean attemptToRing(@Nullable Player entity, Level level, BlockPos blockPos) {
        if(level.isClientSide) return false;

        level.playSound((Player)null, blockPos, SoundEvents.BELL_BLOCK, SoundSource.PLAYERS, 2.0F, 1.0F);
        level.gameEvent(entity, GameEvent.RING_BELL, blockPos);

        AABB aabb = (new AABB(blockPos)).inflate(36.0D);
        List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aabb);
        for(LivingEntity livingentity : nearbyEntities) {
            if (livingentity.isAlive() && !livingentity.isRemoved() && blockPos.closerToCenterThan(livingentity.position(), 32.0D)) {
               livingentity.getBrain().setMemory(MemoryModuleType.HEARD_BELL_TIME, level.getGameTime());
            }
         }

        return true;
    }
}
