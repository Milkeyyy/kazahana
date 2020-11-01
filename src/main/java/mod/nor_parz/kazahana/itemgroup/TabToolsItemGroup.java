
package mod.nor_parz.kazahana.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import mod.nor_parz.kazahana.item.HardicePickaxeItem;
import mod.nor_parz.kazahana.KazahanaModElements;

@KazahanaModElements.ModElement.Tag
public class TabToolsItemGroup extends KazahanaModElements.ModElement {
	public TabToolsItemGroup(KazahanaModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtab_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HardicePickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
