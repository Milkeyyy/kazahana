
package mod.nor_parz.kazahana.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mod.nor_parz.kazahana.itemgroup.TabMaterialsItemGroup;
import mod.nor_parz.kazahana.KazahanaModElements;

import java.util.List;
import java.util.Collections;

@KazahanaModElements.ModElement.Tag
public class HardiceBlock extends KazahanaModElements.ModElement {
	@ObjectHolder("kazahana:hard_ice")
	public static final Block block = null;
	public HardiceBlock(KazahanaModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TabMaterialsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS).hardnessAndResistance(11.2f, 2.8f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).slipperiness(0.989f));
			setRegistryName("hard_ice");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
