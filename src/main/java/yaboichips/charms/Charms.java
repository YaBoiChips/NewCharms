package yaboichips.charms;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import yaboichips.charms.client.gui.AdvancedContainerScreen;
import yaboichips.charms.client.gui.CharmContainerScreen;
import yaboichips.charms.client.gui.UltamiteContainerScreen;
import yaboichips.charms.core.CharmBlocks;
import yaboichips.charms.core.CharmContainerTypes;
import yaboichips.charms.core.CharmItems;
import yaboichips.charms.core.CharmTileEntityTypes;
import yaboichips.charms.util.CharmsConfig;
import yaboichips.charms.util.CuriosModCheck;
import yaboichips.charms.util.events.CharmProperties;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Charms.MOD_ID)
public class Charms {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "charms";
    public static CreativeModeTab TAB;
    private static final Logger LOGGER = LogUtils.getLogger();


    public Charms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(new CharmProperties());
        CharmBlocks.BLOCKS.register(bus);
        CharmContainerTypes.MENUS.register(bus);
        CharmItems.ITEMS.register(bus);
        CharmTileEntityTypes.BLOCK_ENTITY.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::creativeTab);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::enqueueIMC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CharmsConfig.getConfigSpec(), "charms.toml");
    }

    public void creativeTab(final CreativeModeTabEvent.Register event) {
        TAB = event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "charms_tab"), (builder) -> builder.title(Component.translatable("Charms"))
                .icon(() -> new ItemStack(CharmItems.CHARM_BASE.get()))
                .displayItems((smthn, items) -> {
                    CharmItems.ITEMS.getEntries().forEach(item -> items.accept(item.get()));
                }));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void clientSetup(FMLClientSetupEvent e) {
        LOGGER.debug("Charms: Client Setup event starting...");
        MenuScreens.register(CharmContainerTypes.CHARM_CONTAINER.get(), CharmContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ULTIMATE_CHARM_CONTAINER.get(), UltamiteContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ADVANCED_CHARM_CONTAINER.get(), AdvancedContainerScreen::new);

    }
    private void enqueueIMC(final InterModEnqueueEvent e) {
        {
            InterModComms.sendTo("charms", "helloworld", () -> {
                LOGGER.info("Hello world from Charms");
                return "Hello world";
            });
            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(CharmsConfig.getInstance().charmSlots()).build());
            }
        }
    }
}
