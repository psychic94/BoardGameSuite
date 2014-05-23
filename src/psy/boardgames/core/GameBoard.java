package psy.boardgames.core;

import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.regions.CuboidRegion;

public class GameBoard extends CuboidRegion{
	protected final String name;
	protected final LocalWorld world;

	public GameBoard(String name, LocalWorld world, Vector pos1, Vector pos2){
		super(world, pos1, pos2);
		this.name = name;
		this.world = world;
	}

}
