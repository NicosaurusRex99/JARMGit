package naturix.JARM.blocks;

import naturix.JARM.JARM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOre extends Block {

	protected String name;

	public BlockOre(Material material, String name, int level) {
		super(material);
		this.name = name;
		setCreativeTab(JARM.JARM);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", level);
        setHardness(4f);
		setResistance(5f);
	}
	public BlockOre(Material material, String name, float luminance, int level) {
		super(material);
		this.name = name;
		setCreativeTab(JARM.JARM);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", level);
        setHardness(4f);
		setResistance(5f);
		this.setLightLevel(luminance);
	}
	
	public void registerItemModel(Item itemBlock) {
		JARM.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}


}