package com.workshopcraft.alchemicraft;

import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.config.Configuration;



public class CommandController implements ICommand {

	
	public CommandController()
	{
		
	}
	
	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "alchemiconfig";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "alchemiconfig";
	}

	@Override
	public List<String> getCommandAliases() {
	
		return null;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Configuration config = new Configuration(Alchemicraft.CONFIGFILE);
		config.load();
		Alchemicraft.STONEWILD.RECIPES.RecipeList.clear();
		Alchemicraft.STONEWILD.RECIPES.PopulateListFromConfig(config);
		Alchemicraft.STONEDEEP.RECIPES.RecipeList.clear();
		Alchemicraft.STONEDEEP.RECIPES.PopulateListFromConfig(config);
		config.save();
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
