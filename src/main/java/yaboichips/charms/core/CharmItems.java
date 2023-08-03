package yaboichips.charms.core;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.common.items.*;

import static yaboichips.charms.Charms.MOD_ID;

public class CharmItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);


    public static RegistryObject<Item> SATURATION_CHARM = ITEMS.register("saturation_charm", () -> new SaturationCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> SPEED_CHARM = ITEMS.register("speed_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SPEED, 50));
    public static RegistryObject<Item> SPEED_2_CHARM = ITEMS.register("speed_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SPEED, 50));
    public static RegistryObject<Item> HASTE_CHARM = ITEMS.register("haste_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SPEED, 50));
    public static RegistryObject<Item> HASTE_2_CHARM = ITEMS.register("haste_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SPEED, 50));
    public static RegistryObject<Item> STRENGTH_CHARM = ITEMS.register("strength_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_BOOST, 50));
    public static RegistryObject<Item> STRENGTH_2_CHARM = ITEMS.register("strength_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_BOOST, 50));
    public static RegistryObject<Item> ABSORPTION_CHARM = ITEMS.register("absorption_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.ABSORPTION, 50));
    public static RegistryObject<Item> GLOWING_CHARM = ITEMS.register("glowing_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.GLOWING, 50));
    public static RegistryObject<Item> DOLPHIN_CHARM = ITEMS.register("dolphin_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DOLPHINS_GRACE, 50));
    public static RegistryObject<Item> BLINDNESS_CHARM = ITEMS.register("blindness_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.BLINDNESS, 50));
    public static RegistryObject<Item> NAUSEA_CHARM = ITEMS.register("nausea_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.CONFUSION, 220));
    public static RegistryObject<Item> INVISIBILITY_CHARM = ITEMS.register("invisibility_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.INVISIBILITY, 50));
    public static RegistryObject<Item> LUCK_CHARM = ITEMS.register("luck_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.LUCK, 50));
    public static RegistryObject<Item> LEVITATION_CHARM = ITEMS.register("levitation_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.LEVITATION, 50));
    public static RegistryObject<Item> CHARM_BASE = ITEMS.register("charm_base", () -> new Item(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> SLOWNESS_CHARM = ITEMS.register("slowness_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SLOWDOWN, 50));
    public static RegistryObject<Item> SLOW_FALLING_CHARM = ITEMS.register("slow_falling_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.SLOW_FALLING, 50));
    public static RegistryObject<Item> ABSORPTION_2_CHARM = ITEMS.register("absorption_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.ABSORPTION, 50));
    public static RegistryObject<Item> FIRE_RESISTANCE_CHARM = ITEMS.register("fire_resistance_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.FIRE_RESISTANCE, 50));
    public static RegistryObject<Item> WATER_BREATHING_CHARM = ITEMS.register("water_breathing_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.WATER_BREATHING, 50));
    public static RegistryObject<Item> MINING_FATIGUE_CHARM = ITEMS.register("mining_fatigue_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SLOWDOWN, 50));
    public static RegistryObject<Item> NIGHT_VISION_CHARM = ITEMS.register("night_vision_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.NIGHT_VISION, 220));
    public static RegistryObject<Item> RESISTANCE_CHARM = ITEMS.register("resistance_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_RESISTANCE, 50));
    public static RegistryObject<Item> RESISTANCE_2_CHARM = ITEMS.register("resistance_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_RESISTANCE, 50));
    public static RegistryObject<Item> JUMP_CHARM = ITEMS.register("jump_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.JUMP, 50));
    public static RegistryObject<Item> JUMP_2_CHARM = ITEMS.register("jump_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.JUMP, 50));
    public static RegistryObject<Item> SPIDER_CHARM = ITEMS.register("spider_charm", () -> new SpiderCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> FALL_CHARM = ITEMS.register("fall_charm", () -> new FallCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> BOUNCE_CHARM = ITEMS.register("bounce_charm", () -> new BounceCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> STEEL_TOED_CHARM = ITEMS.register("steel_toed_charm", () -> new SteelToedCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> STEP_UP_CHARM = ITEMS.register("step_up_charm", () -> new StepUpCharm(new Item.Properties().stacksTo(1)));

    public static RegistryObject<Item> CHARM_CONTAINER = ITEMS.register("charm_container", () -> new BlockItem(CharmBlocks.CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> ADVANCED_CHARM_CONTAINER = ITEMS.register("advanced_charm_container", () -> new BlockItem(CharmBlocks.ADVANCED_CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> ULTIMATE_CHARM_CONTAINER = ITEMS.register("ultimate_charm_container", () -> new BlockItem(CharmBlocks.ULTIMATE_CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));
}