
package mod.nor_parz.kazahana.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import mod.nor_parz.kazahana.itemgroup.TabToolsItemGroup;
import mod.nor_parz.kazahana.KazahanaModElements;

@KazahanaModElements.ModElement.Tag
public class HardiceSwordItem extends KazahanaModElements.ModElement {
	@ObjectHolder("kazahana:hardice_sword")
	public static final Item block = null;
	public HardiceSwordItem(KazahanaModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 240;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 1.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IceIngotItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(TabToolsItemGroup.tab)) {
		}.setRegistryName("hardice_sword"));
	}
}
