package psy.boardgames.core;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import psy.boardgames.chess.ChessBoard;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class GameBoardManager{
	private HashMap<String, GameBoard> boards;
	
	public GameBoardManager(){
		// TODO
	}
	
	public boolean runCommand(CommandSender sender, Command command, String label, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage("Only in-game players can run this command");
			return true;
		}
		Player player = (Player)sender;
		if(args[1].equalsIgnoreCase("create")){
	        WorldEditPlugin worldEdit = (WorldEditPlugin)player.getServer().getPluginManager().getPlugin("WorldEdit");
	        Selection selection = worldEdit.getSelection(player);
	        if(args[2].equalsIgnoreCase("chess")){
	        	boards.put(args[3], new ChessBoard(args[3], selection.getMinimumPoint(), selection.getMaximumPoint()));
	        	saveBoards();
	        }else
	        	sender.sendMessage("Invalid game name");
	        return true;
		}else if(args[1].equalsIgnoreCase("delete")){
			boards.remove(args[2]);
			saveBoards();
		}
		return false;
	}
	
	/**
	 * Saves boards to a file
	 */
	public void saveBoards(){
		// TODO
	}
	
	/**
	 * Populates boards from a file
	 */
	public void getBoards(){
		// TODO
	}
}
