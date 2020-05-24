package com.teamacronymcoders.quantumquarry.quarry;

import com.hrznstudio.titanium.api.IFactory;
import com.hrznstudio.titanium.block.BasicTileBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class QuarryBlock extends BasicTileBlock<QuarryTile> {

    public QuarryBlock() {
        super(Block.Properties.create(Material.IRON), QuarryTile.class);
    }

    @Override
    public IFactory<QuarryTile> getTileEntityFactory() {
        return QuarryTile::new;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
        if (worldIn.isRemote) return ActionResultType.SUCCESS;
        TileEntity te = worldIn.getTileEntity(pos);
        if (te instanceof QuarryTile) {
            ((QuarryTile) te).openGui(player);
        }
        return super.onBlockActivated(state, worldIn, pos, player, hand, ray);
    }
}
