package com.workshopcraft.alchemicraft.items.recipes;

import net.minecraftforge.common.config.Configuration;

public class RecipesDeep extends Recipes{

	public RecipesDeep(String n,Configuration config) 
	{
		super(n,config);
		
	}

	@Override
	public void PopulateListFromConfig(Configuration config)
	{
		//ABSORB RECIPES
		getRecipeFromConfig(config,"minecraft:stone","minecraft:cobblestone",0,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:cobblestone","minecraft:gravel",0,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:gravel","minecraft:sand",0,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:sand","minecraft:air",0,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:lava","minecraft:obsidian",0,64);//stone -> cobble +1 ether
		
		//EMIT RECIPES
		getRecipeFromConfig(config,"minecraft:obsidian","minecraft:lava",1,-64);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:cobblestone","minecraft:stone",1,-1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:gravel","minecraft:cobblestone",1,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:sand","minecraft:gravel",1,1);//stone -> cobble +1 ether
		
		
		
		
	}
}
