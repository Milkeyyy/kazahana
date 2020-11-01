
package mod.nor_parz.kazahana.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import mod.nor_parz.kazahana.itemgroup.TabToolsItemGroup;
import mod.nor_parz.kazahana.block.HardiceBlock;
import mod.nor_parz.kazahana.KazahanaModElements;

@KazahanaModElements.ModElement.Tag
public class HardiceShovelItem extends KazahanaModElements.ModElement {
	@ObjectHolder("kazahana:hardice_shovel")
	public static final Item block = null;
	public HardiceShovelItem(KazahanaModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 240;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(HardiceBlock.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(TabToolsItemGroup.tab)) {
		}.setRegistryName("hardice_shovel"));
	}
}
