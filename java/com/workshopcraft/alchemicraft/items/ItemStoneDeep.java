package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.items.recipes.RecipesDeep;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.config.Configuration;

public class ItemStoneDeep extends ItemStone{

	
	
	public ItemStoneDeep(String uname,Configuration config) {
		super(uname);
		RECIPES = new RecipesDeep("deep",config);
	}

	@Override
	public Boolean customHandler(BlockPos pos, ItemStack stack, EntityPlayer player)
	{
		return false;
	}
}
