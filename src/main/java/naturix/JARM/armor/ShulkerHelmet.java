package naturix.JARM.armor;

import naturix.JARM.JARM;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShulkerHelmet  extends ItemArmor 
{

	public ShulkerHelmet()
	{
		super(JARM.AmethystArmorMaterial, 0, EntityEquipmentSlot.HEAD);
		ItemBase.registerItem("ShulkerHelmet", this);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.RARE;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		return "jarm:textures/models/armor/shulkerhelmet.png";
	}


	@Override
	public int getMaxDamage()
	{
		return 2010;
	}


	@Override
	public boolean isDamageable()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}