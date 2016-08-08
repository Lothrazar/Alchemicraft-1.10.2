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
		getRecipeFromConfig(config,"minecraft:iron_ore","minecraft:stone",0,256);
		getRecipeFromConfig(config,"minecraft:gold_ore","minecraft:iron_ore",0,512);
		getRecipeFromConfig(config,"minecraft:lapis_ore","minecraft:gold_ore",0,2048);
		getRecipeFromConfig(config,"minecraft:diamond_ore","minecraft:lapis_ore",0,4096);
		getRecipeFromConfig(config,"minecraft:emerald_ore","minecraft:diamond_ore",0,8192);
		//getRecipeFromConfig(config,"minecraft:redstone_ore","minecraft:emerald_ore",0,1024);//BROKEN
		
		//EMIT RECIPES
		getRecipeFromConfig(config,"minecraft:obsidian","minecraft:lava",1,-64);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:cobblestone","minecraft:stone",1,-1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:gravel","minecraft:cobblestone",1,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:sand","minecraft:gravel",1,1);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:stone","minecraft:iron_ore",1,-256);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:iron_ore","minecraft:gold_ore",1,-512);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:gold_ore","minecraft:lapis_ore",1,-1024);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:lapis_ore","minecraft:diamond_ore",1,-4096);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:diamond_ore","minecraft:emerald_ore",1,-8192);//stone -> cobble +1 ether
		getRecipeFromConfig(config,"minecraft:emerald_ore","minecraft:redstone_ore",1,-2048);//stone -> cobble +1 ether
		
		
		
	}
}
