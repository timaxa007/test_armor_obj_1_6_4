package timaxa007.test_armor_obj;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorTestObj extends ItemArmor {

	public ItemArmorTestObj(int id, EnumArmorMaterial armorMaterial, int partArmor) {
		super(id, armorMaterial, 0, partArmor);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack is, int armorSlot) {
		ModelBiped armorModel = new ArmorTestModel(armorSlot);
		if (is.getItem() instanceof ItemArmorTestObj) {
			armorModel = fillingArmorModel(armorModel, entityLiving);
			if (hasColor(is) && armorModel instanceof ArmorCustomModel)
				((ArmorCustomModel)armorModel).color = getColor(is);
		}
		return armorModel;
	}

	public static ModelBiped fillingArmorModel(ModelBiped model, EntityLivingBase entityLiving) {
		if (model == null) return model;
		model.bipedHead.showModel = 
				model.bipedHeadwear.showModel = 
				model.bipedBody.showModel = 
				model.bipedRightArm.showModel = 
				model.bipedLeftArm.showModel = 
				model.bipedRightLeg.showModel = 
				model.bipedLeftLeg.showModel = false;
		model.isSneak = entityLiving.isSneaking();
		model.isRiding = entityLiving.isRiding();
		model.isChild = entityLiving.isChild();
		/*
		Я хотел model.bipedHead.showModel, model.isSneak и т.п. писать в самой модели, но они не страбатывают.
		Дальше код не проверял в модели, да уже не собирался из-за кода выше.
		 */
		//model.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 : 0;
		ItemStack held_item = entityLiving.getCurrentItemOrArmor(0);
		if (held_item != null) {
			model.heldItemRight = 1;

			if (entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entityLiving;

				if (player.getItemInUseCount() > 0) {
					EnumAction enumaction = held_item.getItemUseAction();
					if (enumaction == EnumAction.bow) model.aimedBow = true;
					else if (enumaction == EnumAction.block) model.heldItemRight = 3;
				}

			}

		} else model.heldItemRight = 0;

		if (entityLiving instanceof EntitySkeleton)
			model.aimedBow = ((EntitySkeleton)entityLiving).getSkeletonType() == 1;

		return model;
	}

}
