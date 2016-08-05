package com.workshopcraft.alchemicraft.api;

import java.util.ArrayList;
import java.util.List;

import com.workshopcraft.alchemicraft.items.ItemStone;

/*
 *  This Class Handles the main repository of alchemical stones.  It allows for a central place to check recipes etc. 
 *  It also allows for the addition of additional stones if required.
 * 
 * 
 * 
 */

public class StoneHandler {

	List<ItemStone> Stones = new ArrayList();
	public StoneHandler()
	{
		 
	}
	
	public void AddStone(ItemStone stone)
	{
		Stones.add(stone);
	}
}
