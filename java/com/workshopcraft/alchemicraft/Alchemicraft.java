package com.workshopcraft.alchemicraft;

import com.workshopcraft.alchemicraft.items.ItemStoneDeep;
import com.workshopcraft.alchemicraft.items.ItemStoneWild;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Alchemicraft.MODID, version = Alchemicraft.VERSION)
public class Alchemicraft
{
    public static final String MODID = "alchemicraft";
    public static final String VERSION = "1.0";
    public Configuration config;	
    public static AlchemicraftTab AlchemiTab;
    //alchemical stones
    
    //stone of the wild
    ItemStoneWild STONEWILD; 
    //stone of the deep
    ItemStoneDeep STONEDEEP; 
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
        	//RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        	//renderItem.getItemModelMesher().register(STONEWILD, 0, new ModelResourceLocation(Alchemicraft.MODID + ":" + ( STONEWILD).getName(),"inventory"));
            
        }
    }
}
