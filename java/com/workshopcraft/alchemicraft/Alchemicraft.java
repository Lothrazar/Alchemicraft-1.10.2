package com.workshopcraft.alchemicraft;

import java.io.File;

import com.workshopcraft.alchemicraft.items.ItemStoneDeep;
import com.workshopcraft.alchemicraft.items.ItemStoneWild;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = Alchemicraft.MODID, version = Alchemicraft.VERSION)
public class Alchemicraft
{
	//#TeamEclipse
	
    public static final String MODID = "alchemicraft";
    public static final String VERSION = "1.0";
    public Configuration config;	
    public static AlchemicraftTab AlchemiTab;
    //alchemical stones
    public static File CONFIGFILE;
    //stone of the wild
    public static ItemStoneWild STONEWILD; 
    //stone of the deep
    public static ItemStoneDeep STONEDEEP; 
    //stone of hell
    //stone of the end
    
    //activation blocks
    
    //wooden pedistal
    //stone pedistal
    //quartz pedistal
    //end pedistal
    
    //alchemical energy storage blocks
    
    //alchemical wooden capacitor
    //alchemical stone capacitor
    //alchemical hell capacitor
    //alchemical ender capacitor
    
    //alchemical energy transfer blocks
    
    //alchemical wooden pylon
    //alchemical stone pylon
    //alchemical hell pylon
    //alchemical ender pylon
    
    //alchemical machines
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	AlchemiTab = new AlchemicraftTab("tabAlchemicraft");
    	CONFIGFILE = event.getSuggestedConfigurationFile();
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	//stones go here
    	STONEWILD = new ItemStoneWild("stonewild",config);
    	STONEDEEP = new ItemStoneDeep("stonedeep",config);
    	
    	config.save();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (event.getSide()==Side.CLIENT)
        {
        	//fix this add getName()
        	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        	renderItem.getItemModelMesher().register(STONEWILD, 0, new ModelResourceLocation(Alchemicraft.MODID + ":stonewild","inventory"));
        	renderItem.getItemModelMesher().register(STONEDEEP, 0, new ModelResourceLocation(Alchemicraft.MODID + ":stonedeep","inventory"));
            
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(STONEWILD, new Object[]{
        		"DMD",
        		"WEW",
        		"DMD",
        		'D',Blocks.DIRT,'M',Blocks.MELON_BLOCK,'W',Items.WHEAT,'E',Items.ENDER_PEARL
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(STONEDEEP, new Object[]{
        		"SIS",
        		"GEG",
        		"SIS",
        		'S',Blocks.STONE,'I',Blocks.IRON_ORE,'G',Blocks.GOLD_ORE,'E',Items.ENDER_PEARL
        }));
        
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	/*
    	CommandController alchemicommand = new CommandController();
    	if (alchemicommand!=null)
    	{
    		event.registerServerCommand(alchemicommand);
    	} else
    	{
    		System.out.println("Didnt create command object");
    	}*/
    }
}
