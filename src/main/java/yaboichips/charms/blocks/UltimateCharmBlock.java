package yaboichips.charms.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import yaboichips.charms.core.CharmTileEntityTypes;
import yaboichips.charms.tileentitys.UltimateCharmTE;

import javax.annotation.Nullable;

public class UltimateCharmBlock extends BaseEntityBlock {

    public UltimateCharmBlock(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
                                 InteractionHand handIn, BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof UltimateCharmTE) {
                NetworkHooks.openScreen((ServerPlayer) player, (UltimateCharmTE) tile, pos);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }


    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof UltimateCharmTE) {
                Containers.dropContents(worldIn, pos, ((UltimateCharmTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return CharmTileEntityTypes.ULTAMITE_CHARM_CONTAINER.get().create(blockPos, blockState);

    }

    @Override
    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }


    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> type) {
        return createTickerHelper(type, CharmTileEntityTypes.ULTAMITE_CHARM_CONTAINER.get(), UltimateCharmTE::tick);
    }
}