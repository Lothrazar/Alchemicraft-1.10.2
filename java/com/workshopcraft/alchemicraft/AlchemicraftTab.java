package com.workshopcraft.alchemicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AlchemicraftTab extends CreativeTabs{

	public AlchemicraftTab(String tabName)
	{
		super(tabName);
		
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return Items.ENDER_EYE;
	}
}
