package com.workshopcraft.alchemicraft.items.recipes;

import net.minecraft.block.Block;

public class AlchemicalRecipe {

	int type; //input or output or other?
	int cost; //amount of energy to add or remove from stone
	String input; //this is what we are targeting
	String output; //this is what we are converting it to.
	
	public AlchemicalRecipe()
	{
		
	}
	
	public AlchemicalRecipe(String i, String o, int t, int c)
	{
		type = t;
		cost = c;
		input = i;
		output = o;
		
		
	}
	
	public Boolean isTarget(String i)
	{
		if (i.equals(input))
		{
			return true;
		}
		return false;
	}
	
	public String getInput()
	{
		return input;
	}
	public String getOutput()
	{
		return output;
	}
	public int getType()
	{
		return type;
	}
	public int getCost()
	{
		return cost;
	}
}
