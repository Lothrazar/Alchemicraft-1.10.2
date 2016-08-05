package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.items.recipes.RecipesDeep;

import net.minecraftforge.common.config.Configuration;

public class ItemStoneDeep extends ItemStone{

	private RecipesDeep Recipes;
	
	public ItemStoneDeep(String uname,Configuration config) {
		super(uname);
		Recipes = new RecipesDeep("deep",config);
	}

}
