package net.tigereye.facecavity.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.tigereye.chestcavity.items.ChestOpener;
import net.tigereye.chestcavity.registration.CCItems;
import net.tigereye.facecavity.FaceCavity;
import net.minecraft.client.gui.screen.TitleScreen;
import net.tigereye.facecavity.items.FaceOpenerItem;
import net.tigereye.facecavity.registration.FCItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MobEntityMixin {
	/*@Inject(at = @At("HEAD"), method = "canTarget", cancellable = true)
	private void faceCavityCanTargetMixin(EntityType<?> type, CallbackInfoReturnable<Boolean> info) {
		MobEntity entity = (MobEntity) (Object) this;
		if (entity.writeNbt(new NbtCompound()).contains("lastFed")) {
			if (entity.writeNbt(new NbtCompound()).getInt("lastFed") > 0) {
				info.setReturnValue(false);
			}
		}
	}*/

	@Inject(at = @At("HEAD"), method = "interactWithItem"/*"method_29506"*/, cancellable = true) //if this breaks, its likely because yarn changed the name to interactWithItem
	protected void faceCavityLivingEntityInteractMobMixin(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> info) {
		if(player.getStackInHand(hand).getItem() == FCItems.FACE_OPENER && (!(((LivingEntity)(Object)this) instanceof PlayerEntity))){
			((FaceOpenerItem)player.getStackInHand(hand).getItem()).openChestCavity(player,(LivingEntity)(Object)this);
			info.setReturnValue(ActionResult.SUCCESS);
		}
	}
}
