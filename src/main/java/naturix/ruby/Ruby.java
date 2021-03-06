package naturix.ruby;

import naturix.ruby.proxy.ClientProxy;
import naturix.ruby.proxy.IProxy;
import naturix.ruby.proxy.ModSetup;
import naturix.ruby.proxy.ServerProxy;
import naturix.ruby.world.ModOreFeature;
import naturix.ruby.world.OreGenerator;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Ruby.MODID)
public class Ruby
{
    public static final String MODID = "ruby";
    public static final String MODNAME = "Just Another Ruby Mod";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public Ruby() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("Just another ruby mod!.toml"));
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();

        ModOreFeature.initModFeatures();
        OreGenerator.setupOreGenerator();
    }

}