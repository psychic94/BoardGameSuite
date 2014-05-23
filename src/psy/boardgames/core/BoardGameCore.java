package psy.boardgames.core;

import org.bukkit.plugin.java.JavaPlugin;

import psy.boardgames.chess.ChessModule;

public class BoardGameCore extends JavaPlugin{
	private CommandSwitchboard switchboard;
	
	public void onEnable(){
		switchboard = new CommandSwitchboard();
		getCommand("game").setExecutor(switchboard);
		
		if(getConfig().getBoolean("chess.enabled")){
			saveResource("chess.yml", false);
			switchboard.registerModule("chess", new ChessModule(this));
		}
	}
}
