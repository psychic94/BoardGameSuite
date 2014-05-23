package psy.boardgames.chess;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import psy.boardgames.core.BoardGameCore;
import psy.boardgames.core.GameModule;

public class ChessModule implements GameModule{
	BoardGameCore core;
	
	public ChessModule(BoardGameCore plugin){
		core = plugin;
	}
	
	@Override
	public boolean runCommand(CommandSender sender, Command command, String label, String[] args){
		// TODO Auto-generated method stub
		return false;
	}

}
