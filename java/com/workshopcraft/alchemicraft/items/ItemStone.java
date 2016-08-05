package com.workshopcraft.alchemicraft.items;

import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.items.recipes.RecipesWild;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemStone extends Item{
	
	private String name = "";
	
	
	public ItemStone (String uname)
	{
		
		name = uname;
		GameRegistry.register(this);
	
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(Alchemicraft.AlchemiTab);
	}
	
	
}
