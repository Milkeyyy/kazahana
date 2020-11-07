package mod.nor_parz.kazahana.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.widget.TextFieldWidget;

import mod.nor_parz.kazahana.KazahanaModElements;

import java.util.Map;
import java.util.HashMap;

@KazahanaModElements.ModElement.Tag
public class EntityGotoDimensionProcedure extends KazahanaModElements.ModElement {
	public EntityGotoDimensionProcedure(KazahanaModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EntityGotoDimension!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure EntityGotoDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure EntityGotoDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure EntityGotoDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure EntityGotoDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure EntityGotoDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							(("excute in ") + "" + ((new Object() {
								public String getText() {
									TextFieldWidget textField = (TextFieldWidget) guistate.get("text:DimensionName");
									if (textField != null) {
										return textField.getText();
									}
									return "";
								}
							}.getText())) + "" + ((("run tp ") + "" + (((entity) + "" + (" "))) + "" + ((new Object() {
								public String getText() {
									TextFieldWidget textField = (TextFieldWidget) guistate.get("text:DimensionPosition");
									if (textField != null) {
										return textField.getText();
									}
									return "";
								}
							}.getText()))))));
		}
	}
}
