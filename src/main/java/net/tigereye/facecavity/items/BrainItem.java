package net.tigereye.facecavity.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class BrainItem extends Item {
    public BrainItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity.isUndead() && entity.getHealth() < entity.getMaxHealth()) {
            if (!user.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            entity.heal(3);

            entity.playSound(SoundEvents.ENTITY_PLAYER_BURP, 0.7f, 0.9f + (entity.getRandom().nextFloat() * 0.2f));
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
