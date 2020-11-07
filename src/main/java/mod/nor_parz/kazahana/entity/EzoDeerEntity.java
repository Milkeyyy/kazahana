
package mod.nor_parz.kazahana.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.block.Blocks;

import mod.nor_parz.kazahana.itemgroup.TabMaterialsItemGroup;
import mod.nor_parz.kazahana.KazahanaModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KazahanaModElements.ModElement.Tag
public class EzoDeerEntity extends KazahanaModElements.ModElement {
	public static EntityType entity = null;
	public EzoDeerEntity(KazahanaModElements instance) {
		super(instance, 13);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.2000000000000002f))
						.build("ezo_deer").setRegistryName("ezo_deer");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(TabMaterialsItemGroup.tab)).setRegistryName("ezo_deer"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_tundra")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 2, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelezo_deer(), 1.9f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("kazahana:textures/ezo_deer.png");
				}
			};
		});
	}
	public static class CustomEntity extends AnimalEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 2;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + 0.7;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			return (CustomEntity) entity.create(this.world);
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Blocks.GRASS, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Blocks.TALL_GRASS, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Blocks.OAK_LEAVES, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelezo_deer extends EntityModel {
		private final ModelRenderer Doutai;
		private final ModelRenderer cube_r1;
		private final ModelRenderer Shippo;
		private final ModelRenderer Atama;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Tsuno;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer Kubi;
		private final ModelRenderer cube_r12;
		private final ModelRenderer Ashi;
		private final ModelRenderer Mae_Migi;
		private final ModelRenderer Mae_Hidari;
		private final ModelRenderer Ushiro_Migi;
		private final ModelRenderer Ushiro_Hidari;
		public Modelezo_deer() {
			textureWidth = 64;
			textureHeight = 64;
			Doutai = new ModelRenderer(this);
			Doutai.setRotationPoint(0.0F, 12.6F, 0.5F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Doutai.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
			addBoxHelper(cube_r1, 22, 51, -7.5F, -3.5F, -3.0F, 15, 7, 6, 0.0F, false);
			Shippo = new ModelRenderer(this);
			Shippo.setRotationPoint(2.0F, 15.2F, 11.55F);
			addBoxHelper(Shippo, 60, 47, -2.5F, -3.8F, -3.55F, 1, 3, 1, 0.0F, false);
			Atama = new ModelRenderer(this);
			Atama.setRotationPoint(-0.5F, 3.95F, -7.05F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.5029F, 5.64F, 2.7587F);
			Atama.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
			addBoxHelper(cube_r2, 60, 0, -8.1087F, -2.99F, -0.4971F, 1, 1, 1, 0.0F, false);
			addBoxHelper(cube_r2, 0, 0, -7.1087F, -4.99F, -1.9971F, 4, 4, 4, 0.0F, false);
			Tsuno = new ModelRenderer(this);
			Tsuno.setRotationPoint(-0.5F, -2.95F, 1.65F);
			Atama.addChild(Tsuno);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-1.6539F, 0.6229F, -3.5F);
			Tsuno.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0873F, -1.5708F, 0.0F);
			addBoxHelper(cube_r3, 8, 61, -0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r4);
			setRotationAngle(cube_r4, 1.0472F, -1.5708F, -0.3054F);
			addBoxHelper(cube_r4, 8, 61, -5.1087F, -5.8784F, 6.6756F, 1, 2, 1, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.5236F, -1.5708F, -0.3054F);
			addBoxHelper(cube_r5, 8, 61, -5.1087F, -5.3003F, -8.0132F, 1, 2, 1, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.3491F, -1.5708F, 0.0F);
			addBoxHelper(cube_r6, 8, 61, -5.1087F, -9.4004F, 4.9859F, 1, 2, 1, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.48F, -1.5708F, 0.0F);
			addBoxHelper(cube_r7, 8, 61, -5.1087F, -8.5533F, -6.9326F, 1, 2, 1, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.6981F, -1.5708F, 0.0F);
			addBoxHelper(cube_r8, 8, 61, -5.1087F, -9.7698F, -3.7703F, 1, 2, 1, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.0029F, 8.69F, 1.1087F);
			Tsuno.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.6981F, -1.5708F, 0.0F);
			addBoxHelper(cube_r9, 8, 61, -5.1087F, -9.8573F, 2.666F, 1, 2, 1, 0.0F, false);
			addBoxHelper(cube_r9, 8, 61, -5.1087F, -7.5378F, 2.0899F, 1, 4, 1, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(3.671F, 0.6198F, -3.5F);
			Tsuno.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.0873F, -1.5708F, 0.0F);
			addBoxHelper(cube_r10, 8, 61, -0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-0.5786F, 2.783F, -3.5F);
			Tsuno.addChild(cube_r11);
			setRotationAngle(cube_r11, -0.6981F, -1.5708F, 0.0F);
			addBoxHelper(cube_r11, 8, 61, -0.5F, -2.0F, -0.5F, 1, 4, 1, 0.0F, false);
			Kubi = new ModelRenderer(this);
			Kubi.setRotationPoint(0.0F, 23.2F, 1.5F);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0029F, -13.61F, -5.7413F);
			Kubi.addChild(cube_r12);
			setRotationAngle(cube_r12, -1.0908F, 0.0F, 0.0F);
			addBoxHelper(cube_r12, 38, 0, -1.5029F, 1.2473F, -4.9567F, 3, 4, 9, 0.0F, false);
			Ashi = new ModelRenderer(this);
			Ashi.setRotationPoint(0.0F, 24.0F, 0.0F);
			Mae_Migi = new ModelRenderer(this);
			Mae_Migi.setRotationPoint(-3.5F, -6.75F, 0.5F);
			Ashi.addChild(Mae_Migi);
			addBoxHelper(Mae_Migi, 0, 59, 0.85F, -3.15F, -5.6F, 1, 10, 1, 0.0F, false);
			Mae_Hidari = new ModelRenderer(this);
			Mae_Hidari.setRotationPoint(2.5F, -6.75F, 0.5F);
			Ashi.addChild(Mae_Hidari);
			addBoxHelper(Mae_Hidari, 0, 59, -0.95F, -3.15F, -5.6F, 1, 10, 1, 0.0F, false);
			Ushiro_Migi = new ModelRenderer(this);
			Ushiro_Migi.setRotationPoint(-3.5F, -6.25F, 11.5F);
			Ashi.addChild(Ushiro_Migi);
			addBoxHelper(Ushiro_Migi, 4, 58, 0.85F, -2.85F, -6.1F, 1, 9, 1, 0.0F, false);
			Ushiro_Hidari = new ModelRenderer(this);
			Ushiro_Hidari.setRotationPoint(2.5F, -6.25F, 11.5F);
			Ashi.addChild(Ushiro_Hidari);
			addBoxHelper(Ushiro_Hidari, 4, 58, -0.85F, -2.85F, -6.1F, 1, 9, 1, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			Doutai.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Shippo.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Atama.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Kubi.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Ashi.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Mae_Migi.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Ushiro_Migi.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Atama.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Atama.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Ushiro_Hidari.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Mae_Hidari.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
