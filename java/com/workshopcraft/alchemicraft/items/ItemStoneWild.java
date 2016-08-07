package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.items.recipes.RecipesWild;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.config.Configuration;

public class ItemStoneWild extends ItemStone{

	
	
	public ItemStoneWild(String uname,Configuration config) {
		super(uname);
		RECIPES = new RecipesWild("wild",config);
		
	}
	
	@Override
	public Boolean customHandler(BlockPos pos, ItemStack stack, EntityPlayer player)
	{
		return false;
	}

}
