package net.mcreator.utility.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.utility.procedures.LiminalyKeyQuandoSiFaClicConIlPulsanteDestroDelMouseProcedure;

public class LiminalyKeyItem extends Item {
	public LiminalyKeyItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		LiminalyKeyQuandoSiFaClicConIlPulsanteDestroDelMouseProcedure.execute(entity);
		return ar;
	}
}