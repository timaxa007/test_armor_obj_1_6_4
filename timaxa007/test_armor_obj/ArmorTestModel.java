package timaxa007.test_armor_obj;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArmorTestModel extends ArmorCustomModel {

	public static final IModelCustom
	model = AdvancedModelLoader.loadModel("/assets/" + TestArmorObjMOD.MODID + "/model/armor/armor_plane.obj")
	;
	public static final ResourceLocation
	//texture = new ResourceLocation(TestArmorObjMOD.MODID, "textures/model/armor/armor_plane.png"),
	texture_glass = new ResourceLocation("minecraft", "textures/blocks/glass.png"),
	texture_wood = new ResourceLocation("minecraft", "textures/blocks/planks_oak.png")
	;
	private final int partType;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorTestModel(int armorType) {
		partType = armorType;
	}

	@Override
	public void pre() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}

	@Override
	public void post() {
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	public void partHead() {
		if (partType == 0) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_glass);
			model.renderPart("glass");
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("helm");
		}
	}

	@Override
	public void partBody() {
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("body");
			model.renderPart("plane");
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("right_arm");
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("left_arm");
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2) {
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("right_leg");
		}
		if (partType == 3) {
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("right_boot");
		}
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2) {
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("left_leg");
		}
		if (partType == 3) {
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("left_boot");
		}
	}

}