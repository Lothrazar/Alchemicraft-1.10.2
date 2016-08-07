package com.workshopcraft.alchemicraft.items.recipes;

import net.minecraftforge.common.config.Configuration;

public class RecipesWild extends Recipes{

	public RecipesWild(String n,Configuration config) 
	{
		super(n,config);
		
	}

	@Override
	public void PopulateListFromConfig(Configuration config)
	{
		
		getRecipeFromConfig(config,"minecraft:grass","minecraft:dirt",0,1);//grass -> dirt
		getRecipeFromConfig(config,"minecraft:dirt","minecraft:grass",1,-2);//grass -> dirt
	}
}
