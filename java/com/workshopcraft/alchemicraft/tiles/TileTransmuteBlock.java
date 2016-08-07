package com.workshopcraft.alchemicraft.tiles;

import com.workshopcraft.alchemicraft.items.recipes.AlchemicalRecipe;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileTransmuteBlock extends TileEntity{
	AlchemicalRecipe recipe;
	int transitionTimer;
	int transitionSize;
	boolean running = false;
	
	public TileTransmuteBlock()
	{
		recipe = new AlchemicalRecipe();
		transitionTimer = 0;
		transitionSize = 0;
		running = false;
	}
	
	public void init(AlchemicalRecipe r, int t,int d)
	{
		recipe = r;
		transitionTimer = t;
		running = true;
		transitionSize = d;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
	}

}
