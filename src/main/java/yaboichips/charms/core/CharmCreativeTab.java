package yaboichips.charms.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.Charms;

public class CharmCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Charms.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = TAB_REGISTRY.register("tab", () -> CreativeModeTab.builder()
            .title(Component.literal("Charms"))
            .icon(CharmItems.CHARM_BASE.get()::getDefaultInstance)
            .displayItems((displayItems, output) -> CharmItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
            .build());
}
