package psy.boardgames.core;

import org.bukkit.Location;
import org.bukkit.World;

public abstract class GameBoard{
	protected final String name;
	protected final World world;
	protected final Location loc1, loc2;
	
	public GameBoard(String name, Location loc1, Location loc2){
		this(name, loc1.getWorld(), loc1, loc2);
	}
	
	public GameBoard(String name, World world, Location loc1, Location loc2){
		this.name = name;
		this.world = world;
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	
	public abstract void setUp();
	
	public abstract void putAway();
}
