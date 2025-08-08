package net.mcreator.utility.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.utility.init.UtilityModMenus;
import net.mcreator.utility.init.UtilityModItems;

public class EssenctiondistilizerGUIOgniTickMentreQuestaGUIEApertaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
					ItemStack stack = _menu.getSlots().get(sltid).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(7) <= 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.SHULKER_BOX.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.DRAGON_BREATH
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.END_STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.END_CRYSTAL
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.POWER_ESSENCE.get()
				&& (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) <= 1
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.ENDESSECE.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(1).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(2).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(3).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(4).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(5).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(6).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = 7;
					final ItemStack _setstack = new ItemStack(UtilityModItems.ENDKEY.get()).copy();
					_setstack.setCount(new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
								ItemStack stack = _menu.getSlots().get(sltid).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(7) + 1);
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
					ItemStack stack = _menu.getSlots().get(sltid).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(7) <= 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.ANCIENT_DEBRIS.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.MAGMA_BLOCK.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_SAND.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.BLACKSTONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.BASALT.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.NETHER_BRICK
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.POWER_ESSENCE.get()
				&& (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) <= 1
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.NEHTERESSENCE.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(1).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(2).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(3).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(4).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(5).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(6).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				ItemStack _setstack = new ItemStack(UtilityModItems.NETHERKEY.get()).copy();
				_setstack.setCount(new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) + 1);
				_menu.getSlots().get(7).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
					ItemStack stack = _menu.getSlots().get(sltid).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(7) <= 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.PRISMARINE_SHARD
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.RED_SAND.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.ECHO_SHARD
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.GLOW_BERRIES
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.POWDER_SNOW_BUCKET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.BAMBOO.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.POWER_ESSENCE.get()
				&& (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) <= 1
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == UtilityModItems.OVERWORLDESSENCE
								.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof UtilityModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(1).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(2).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(3).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(4).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(5).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(6).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
				ItemStack _setstack = new ItemStack(UtilityModItems.OVERWORDKEY.get()).copy();
				_setstack.setCount(new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) + 1);
				_menu.getSlots().get(7).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}