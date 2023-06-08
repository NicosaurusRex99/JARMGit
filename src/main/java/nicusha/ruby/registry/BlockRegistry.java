package nicusha.ruby.registry;

import net.minecraft.util.valueproviders.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.registries.*;
import nicusha.ruby.*;
import nicusha.ruby.blocks.*;

import javax.annotation.*;

import static nicusha.ruby.Ruby.MODID;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3, NETHERITE = 4;

    public static final RegistryObject<Block> RUBY_ORE = createOreBlock("ruby_ore", MapColor.COLOR_RED, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> RUBY_ORE_DEEPSLATE = createOreBlock("ruby_ore_deepslate", MapColor.COLOR_RED, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> BRAUNITE_ORE = createOreBlock("braunite_ore", MapColor.COLOR_GRAY, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> BRAUNITE_ORE_DEEPSLATE = createOreBlock("braunite_ore_deepslate", MapColor.COLOR_GRAY, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> OPAL_ORE = createOreBlock("opal_ore", MapColor.COLOR_LIGHT_BLUE, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> OPAL_ORE_DEEPSLATE = createOreBlock("opal_ore_deepslate", MapColor.COLOR_LIGHT_BLUE, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> AMETHYST = createOreBlock("amethyst", MapColor.COLOR_PURPLE, 2, 4, DIAMOND, SoundType.STONE, false);
    public static final RegistryObject<Block> METEORITE_ORE = createOreBlock("meteorite_ore", MapColor.COLOR_ORANGE, 5, 8, NETHERITE, SoundType.STONE, false);
    public static final RegistryObject<Block> BRAUNITE_BLOCK = createOreBlock("braunite_block", MapColor.COLOR_GRAY, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> OPAL_BLOCK = createOreBlock("opal_block", MapColor.COLOR_LIGHT_BLUE, 2, 4, DIAMOND, SoundType.STONE, true);
    public static final RegistryObject<Block> RUBY_BLOCK = createOreBlock("ruby_block", MapColor.COLOR_RED, 2, 4, DIAMOND, SoundType.STONE, true);

    private static RegistryObject<Block> createOreBlock(@Nonnull String id, MapColor color, float hardness, float resistance, float harvestLevel, SoundType sound, boolean fullBlock){
        if(fullBlock){
            RegistryObject<Block> block = BLOCKS.register(id, () -> new Block(BlockBehaviour.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance)));
            ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
            return block;
        }
        if(id == "amethyst"){
            RegistryObject<Block> block = BLOCKS.register(id, () -> new Amethyst(BlockBehaviour.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).noOcclusion()));
            ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
            return block;
        }
        if(id == "meteorite_ore"){
            RegistryObject<Block> block = BLOCKS.register(id, () -> new Meteorite(BlockBehaviour.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).noOcclusion()));
            ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
            return block;
        }
        RegistryObject<Block> block = BLOCKS.register(id, () -> new Block(BlockBehaviour.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).noOcclusion()));
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
        return block;
    }

}
