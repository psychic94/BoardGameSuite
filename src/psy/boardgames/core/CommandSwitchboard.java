package psy.boardgames.core;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSwitchboard implements CommandExecutor{
	private HashMap<String,GameModule> modules;
	private GameBoardManager boardManager;
	
	public CommandSwitchboard(){
		// TODO
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(args[0].equalsIgnoreCase("board")){
			boardManager.runCommand(sender, command, label, args);
		}else{
			modules.get(args[0]).runCommand(sender, command, label, args);
		}
		return false;
	}

	public void registerModule(String name, GameModule module){
		modules.put(name, module);
	}
}
