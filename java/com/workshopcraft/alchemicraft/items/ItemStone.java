package com.workshopcraft.alchemicraft.items;

import java.util.Iterator;
import java.util.List;

import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.items.recipes.AlchemicalRecipe;
import com.workshopcraft.alchemicraft.items.recipes.Recipes;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStone extends Item{
	
	private String name = "";
	int ether;
	int mode;
	public Recipes RECIPES;
	
	public ItemStone (String uname)
	{
		
		name = uname;
		setUnlocalizedName(name);
		this.setRegistryName(Alchemicraft.MODID+":"+name);
		GameRegistry.register(this);
		ether = 0;
		mode = 0;
		
		
		setMaxStackSize(1);
		setCreativeTab(Alchemicraft.AlchemiTab);
		

	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity playerIn,int slot,boolean selected)
	{
		
		if (stack.getTagCompound() == null)
		{
			stack.setTagCompound(new NBTTagCompound());
			setEther(stack,0);
			setMode(stack,0);
		}
		else
		{
			ether = stack.getTagCompound().getInteger("ether");
			mode = stack.getTagCompound().getInteger("mode");
		}
		
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,EntityPlayer playerIn,World worldIn,BlockPos pos,EnumHand hand,EnumFacing facing,float hitX,float hitY,float hitZ)
	{
		
		
		if (!worldIn.isRemote)
		{
			
			System.out.println(RECIPES.getClass().getName());
			Iterator<AlchemicalRecipe> recipeIterator = RECIPES.RecipeList.iterator();
			AlchemicalRecipe a;
			while (recipeIterator.hasNext()) {
				a = recipeIterator.next();
				System.out.println(a.getInput());
			}
			
			//System.out.println(RECIPES.RecipeList.);
			if (playerIn.isSneaking())
			{
				//set stone to opposite mode
				if (mode == 0)
				{
					mode = 1;
					System.out.println("Mode Change : Emit");
					return EnumActionResult.SUCCESS;
				} else
				{
					mode = 0;
					System.out.println("Mode Change : Absorb");
					return EnumActionResult.SUCCESS;
				}
			}
			RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
			
			if (raytraceresult == null)
	        {
	            return EnumActionResult.PASS;
	        }
	        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
	        {
	            //return new ActionResult(EnumActionResult.PASS, itemStackIn);
	        	BlockPos blockpos = raytraceresult.getBlockPos();
	        	String targetName = "";
	        	ResourceLocation r = worldIn.getBlockState(blockpos).getBlock().getRegistryName();
	        	targetName = r.getResourceDomain()+":"+r.getResourcePath();
				AlchemicalRecipe t = RECIPES.findInput(targetName,mode);
				System.out.println("Target : "+targetName);
						
				if (t== null)
				{
					
					return EnumActionResult.FAIL;
				}
				//System.out.println("Recipe Found");
				System.out.println("ERMAHGERD : "+t.getCost());
				if (t.getCost()+ether>0)
				{
					worldIn.setBlockState(blockpos, Block.getBlockFromName(t.getOutput()).getDefaultState());
					ether += t.getCost();
					System.out.println("Ether : "+ether);
				}
				//worldIn.mark
				return EnumActionResult.SUCCESS;
			}
	        else
	        {
	        	BlockPos blockpos = raytraceresult.getBlockPos();
	        	
	        	String targetName = "";
	        	ResourceLocation r = worldIn.getBlockState(blockpos).getBlock().getRegistryName();
	        	targetName = r.getResourceDomain()+":"+r.getResourcePath();
	            AlchemicalRecipe t = RECIPES.findInput(targetName, mode);
	            System.out.println("Target : "+targetName);
	            if (t==null)
	            {
	            	return EnumActionResult.FAIL;
	            }
	            if (t.getCost()+ether>0)
	            {
	            	worldIn.setBlockState(blockpos, Block.getBlockFromName(t.getOutput()).getDefaultState());
	            	ether += t.getCost();
	            	System.out.println("Ether : "+ether);
	            	setEther(stack,ether);
	            	setMode(stack,mode);
	            }
	            return EnumActionResult.SUCCESS;
	        }
		}
		return EnumActionResult.FAIL;
	}
	
	public static void setEther(ItemStack s, int e)
	{
		if (s.getTagCompound() == null)
		{
			s.setTagCompound(new NBTTagCompound());
			
		}
		s.getTagCompound().setInteger("ether", e);
		
	}
	
	public static void setMode(ItemStack s, int m)
	{
		if (s.getTagCompound() == null)
		{
			s.setTagCompound(new NBTTagCompound());
			
		}
		s.getTagCompound().setInteger("mode", m);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		
        if (stack.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            int s = nbttagcompound.getInteger("ether");

            
            tooltip.add(TextFormatting.BLUE + "Ether  :" + s);
            
            if (mode == 0)
            {
            	tooltip.add(TextFormatting.RED + "MODE : ABSORB");
            } else
            {
            	tooltip.add(TextFormatting.GREEN + "MODE : EMIT");
            }
        }
    }
	
	public Boolean customHandler(BlockPos pos, ItemStack stack, EntityPlayer player)
	{
		return false;
	}
	
}
