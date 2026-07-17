package net.mcreator.utility.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.utility.procedures.OmniWandsQuandoUnentitaViventeEColpitaConLoggettoProcedure;
import net.mcreator.utility.procedures.OmniWandsQuandoSiFaClicConIlPulsanteDestroDelMouseProcedure;

public class OmniWandsItem extends Item {
	public OmniWandsItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		OmniWandsQuandoSiFaClicConIlPulsanteDestroDelMouseProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		OmniWandsQuandoUnentitaViventeEColpitaConLoggettoProcedure.execute(entity, sourceentity);
		return retval;
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}