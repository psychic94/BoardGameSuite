package psy.boardgames.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface GameModule{
	public boolean runCommand(CommandSender sender, Command command, String label, String[] args);
}
