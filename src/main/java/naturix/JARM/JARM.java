package naturix.JARM;


import naturix.JARM.integration.ProjectECompat;
import naturix.JARM.integration.baubles.ModItemsBaubles;
import naturix.JARM.proxy.CommonProxy;
import naturix.JARM.registry.ModBlocks;
import naturix.JARM.registry.ModItems;
import naturix.JARM.registry.ModOreDict;
import naturix.JARM.registry.ModRecipes;
import naturix.JARM.world.ModWorldGeneration;
import naturix.JARM.world.tree.TreeWorldGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@Mod(modid = JARM.MODID, name = JARM.MOD_NAME, version = JARM.VERSION, updateJSON = JARM.UPDATE_URL, useMetadata = true, dependencies = JARM.DEPENDENCIES)
public class JARM
{ 
	public static final String MODID = "jarm";
    public static final String VERSION = "1.12.2.24";
    public static final String MOD_NAME = "Just Another Ruby Mod!";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/NicosaurusRex99/JARMGit/1.12.2/jarm_update.json";
    public static final String DEPENDENCIES = "after:projecte";
    
    @SidedProxy(clientSide = "naturix.JARM.proxy.ClientProxy", serverSide = "naturix.JARM.proxy.ServerProxy")
    
    public static CommonProxy proxy;

    @Mod.Instance
    public static JARM instance;

    public static org.apache.logging.log4j.Logger logger;
    
    public static EntityPlayer player;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event); 
        GameRegistry.registerWorldGenerator(new TreeWorldGen(), 3);
        GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
        }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModOreDict.initOreDict();
        ModRecipes.init();
        
    }
    public static boolean ProjectE = false;
    public static void modChecks()
	{
		ProjectE = Loader.isModLoaded("projecte");
		logger.info(ProjectE);
	}
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        if(ProjectE) {
            ProjectECompat.init();
        }
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    	
    }

    public static final CreativeTabs JARM = new CreativeTabs("JARMTab")
    {

        @Override
		@SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.block_ruby);
        }
		
    };
    @Mod.EventBusSubscriber
	public static class RegistrationHandler {
	
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
			if(Loader.isModLoaded("baubles")) {
				ModItemsBaubles.register(event.getRegistry());
			}
		}
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
			if(Loader.isModLoaded("baubles")) {
				ModItemsBaubles.registerModels();
			}
		}
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
		
    
}
    
    public static void registerEvent(Object event)
	{
		FMLCommonHandler.instance().bus().register(event);
		MinecraftForge.EVENT_BUS.register(event);
	}
}

