package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BounceCharm extends CharmItem implements ICurioItem {
    public BounceCharm(Properties properties) {
        super(properties, null, 0);
    }


    @Override
    public void playRightClickEquipSound(LivingEntity livingEntity, ItemStack stack) {
        livingEntity.level().playSound(null, livingEntity.blockPosition(),
                SoundEvents.ARMOR_EQUIP_ELYTRA, SoundSource.NEUTRAL,
                1.0F, 1.0F);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!entity.getBlockStateOn().isAir()) {
            if (!entity.isCrouching()) {
                double f = 0.91d + 0.04d;
                entity.setDeltaMovement(entity.getDeltaMovement().x() / f, -entity.getDeltaMovement().y() + 1, entity.getDeltaMovement().z() / f);
                entity.setOnGround(false);
                entity.playSound(SoundEvents.SLIME_SQUISH, 1f, 1f);
            }
        }
    }
}