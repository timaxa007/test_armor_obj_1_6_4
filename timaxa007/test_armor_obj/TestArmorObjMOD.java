package timaxa007.test_armor_obj;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

@Mod(modid = TestArmorObjMOD.MODID, name = TestArmorObjMOD.NAME, version = TestArmorObjMOD.VERSION)
public class TestArmorObjMOD {

	public static final String
	MODID = "test_armor_obj",
	NAME = "Test Armor Obj",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static TestArmorObjMOD instance;

	public Configuration main;

	private static int
	item_armor_test_obj_helm_id,
	item_armor_test_obj_vest_id,
	item_armor_test_obj_pants_id,
	item_armor_test_obj_boots_id
	;

	public static Item
	itemArmorTestObjHelm,
	itemArmorTestObjVest,
	itemArmorTestObjPants,
	itemArmorTestObjBoots
	;

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		itemArmorTestObjHelm = new ItemArmorTestObj(item_armor_test_obj_helm_id, EnumArmorMaterial.IRON, 0)
				.setUnlocalizedName("armor_test_obj_helm").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(itemArmorTestObjHelm, "item_armor_test_obj_helm");

		itemArmorTestObjVest = new ItemArmorTestObj(item_armor_test_obj_vest_id, EnumArmorMaterial.IRON, 1)
				.setUnlocalizedName("armor_test_obj_vest").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(itemArmorTestObjVest, "item_armor_test_obj_vest");

		itemArmorTestObjPants = new ItemArmorTestObj(item_armor_test_obj_pants_id, EnumArmorMaterial.IRON, 2)
				.setUnlocalizedName("armor_test_obj_pants").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(itemArmorTestObjPants, "item_armor_test_obj_pants");

		itemArmorTestObjBoots = new ItemArmorTestObj(item_armor_test_obj_boots_id, EnumArmorMaterial.IRON, 3)
				.setUnlocalizedName("armor_test_obj_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(itemArmorTestObjBoots, "item_armor_test_obj_boots");
	}

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		main = new Configuration(event.getSuggestedConfigurationFile());
		main.load();
		item_armor_test_obj_helm_id = main.getItem("item_armor_test_obj_helm_id", 4000).getInt();
		item_armor_test_obj_vest_id = main.getItem("item_armor_test_obj_vest_id", 4001).getInt();
		item_armor_test_obj_pants_id = main.getItem("item_armor_test_obj_pants_id", 4002).getInt();
		item_armor_test_obj_boots_id = main.getItem("item_armor_test_obj_boots_id", 4003).getInt();
		main.save();
	}

}
