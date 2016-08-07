package com.workshopcraft.alchemicraft.items.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

/*
 *  This class is a root class for the alchemical stones to derive their base list of recipes from.
 *  This is done either via the default list of recipes or by loading a custom list of recipes from the configs.
 * 
 */
public class Recipes {
	
	public List<AlchemicalRecipe> RecipeList = new ArrayList();
	String name;
	public Recipes(String n,Configuration config) {
		name = n;
		PopulateListFromConfig(config);
	}
	
	//this function pulls info from config and populates if not present. Writes result to list.
	public void getRecipeFromConfig(Configuration con, String i, String o, int t, int c)
	{
		AlchemicalRecipe a = new AlchemicalRecipe();
		int id = RecipeList.size()+1;
		a.type = con.getInt("TYPE["+id+"]", "STONE"+name, t, 0, 1, "");
		a.cost = con.getInt("COST["+id+"]", "STONE"+name, c, -99999, 99999, "");
		a.input = con.getString("INPUT["+id+"]", "STONE"+name, i,  "");
		a.output = con.getString("OUTPUT["+id+"]", "STONE"+name, o,  "");
		RecipeList.add(a);
	}
	
	public AlchemicalRecipe findInput(String i,int mode)
	{
		
		for (AlchemicalRecipe t : RecipeList)
		{
			//System.out.println("Input : "+t.getInput());
			//System.out.println("Mode : "+t.getType());
			if ((t.getInput().equals(i)) && (t.getType()==mode))
			{
				return t;
			}
		}
		return null;
	}
	
	
	//returns true if successful, false if no reciepes found in configs.
	//each stone's subclass overrides this function
	//this function auto populates the config file.
	public void PopulateListFromConfig(Configuration config)
	{
		
	}
	
	
	
	
}
