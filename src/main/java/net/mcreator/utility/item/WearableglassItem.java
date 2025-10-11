package net.mcreator.utility.item;

public class WearableglassItem extends Item {
	public WearableglassItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.utility.wearableglass.description_0"));
	}
}