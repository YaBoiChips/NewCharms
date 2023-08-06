package yaboichips.charms.core;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import yaboichips.charms.Charms;
import yaboichips.charms.mixin.LootTableAccessor;

import java.util.Map;
import java.util.Set;

public class CharmLoot {

    @Mod.EventBusSubscriber(modid = Charms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class LootTableInjection {
        private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();
        private static final Map<String, ResourceLocation> INJECTION_TABLES = Maps.newHashMap();
        public static final ResourceLocation abandoned_mineshaft = registerInject("abandoned_mineshaft");
        public static final ResourceLocation jungle_temple = registerInject("jungle_temple");
        public static final ResourceLocation stronghold_crossing = registerInject("stronghold_crossing");
        public static final ResourceLocation nether_bridge = registerInject("nether_bridge");
        public static final ResourceLocation pillager_outpost = registerInject("pillager_outpost");
        public static final ResourceLocation simple_dungeon = registerInject("simple_dungeon");
        public static final ResourceLocation woodland_mansion = registerInject("woodland_mansion");
        private static int injected = 0;

        public LootTableInjection() {
        }

        @NotNull
        static ResourceLocation registerInject(String resourceName) {
            ResourceLocation registryName = register("inject/" + resourceName);
            INJECTION_TABLES.put(resourceName, registryName);
            return registryName;
        }

        @NotNull
        static ResourceLocation register(@NotNull String resourceName) {
            return register(new ResourceLocation("charms", resourceName));
        }

        @NotNull
        static ResourceLocation register(@NotNull ResourceLocation resourceLocation) {
            LOOT_TABLES.add(resourceLocation);
            return resourceLocation;
        }

        @NotNull
        public static Set<ResourceLocation> getLootTables() {
            return ImmutableSet.copyOf(LOOT_TABLES);
        }

        @SubscribeEvent
        public static void onChestLootLoad(@NotNull LootTableLoadEvent event) {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();
            if (name.startsWith(prefix)) {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                if (INJECTION_TABLES.containsKey(file)) {
                    try {
                        ((LootTableAccessor) event.getTable()).getPools().add(getInjectPool(file));
                        ++injected;
                    } catch (NullPointerException var5) {
                        Charms.LOGGER.error("Charms {} is broken by some other mod. Cannot add Customized Dungeon Loot to" + name);
                    }
                }
            }

        }

        @SubscribeEvent
        public static void onSandLootLoad(@NotNull LootTableLoadEvent event) {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();
            if (name.startsWith(prefix)) {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                if (INJECTION_TABLES.containsKey(file)) {
                    try {
                        ((LootTableAccessor) event.getTable()).getPools().add(getInjectPool(file));
                        ++injected;
                    } catch (NullPointerException var5) {
                        Charms.LOGGER.error("Charms {} is broken by some other mod. Cannot add Customized Dungeon Loot to" + name);
                    }
                }
            }

        }

        @NotNull
        private static LootPool getInjectPool(String entryName) {
            LootPoolEntryContainer.Builder<?> entryBuilder = LootTableReference.lootTableReference(INJECTION_TABLES.get(entryName)).setWeight(1);
            return LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F)).setBonusRolls(ConstantValue.exactly(1.0F)).add(entryBuilder).build();
        }

        public static int checkAndResetInsertedAll() {
            int i = injected;
            injected = 0;
            return Math.max(0, INJECTION_TABLES.size() - i);
        }
    }
}
