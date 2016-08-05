package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.items.recipes.RecipesWild;

import net.minecraftforge.common.config.Configuration;

public class ItemStoneWild extends ItemStone{

	private RecipesWild Recipes;
	
	public ItemStoneWild(String uname,Configuration config) {
		super(uname);
		Recipes = new RecipesWild("wild",config);
		
	}

}
