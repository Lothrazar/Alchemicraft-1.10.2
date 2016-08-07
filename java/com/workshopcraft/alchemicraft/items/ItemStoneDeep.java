package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.items.recipes.RecipesDeep;

import net.minecraftforge.common.config.Configuration;

public class ItemStoneDeep extends ItemStone{

	
	
	public ItemStoneDeep(String uname,Configuration config) {
		super(uname);
		RECIPES = new RecipesDeep("deep",config);
	}

}
