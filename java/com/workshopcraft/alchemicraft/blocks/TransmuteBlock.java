package com.workshopcraft.alchemicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TransmuteBlock extends Block{

	public TransmuteBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		setHardness(50.0f);
		setResistance(50.0f);
		
		
	}
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return null;
	}
}
