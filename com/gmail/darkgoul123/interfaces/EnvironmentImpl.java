package com.gmail.darkgoul123.interfaces;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public interface EnvironmentImpl {

	public Area castleArea = new Area(
			new Tile(2435, 3081, 0),
			new Tile(2447, 3099, 0)
	);
	public Area saraAfkArea = new Area(
			new Tile(2431, 3072, 0),
			new Tile(2425, 3087, 0)
	);
	public Area zammyAfkArea = new Area(
			new Tile(2368, 3125, 0),
			new Tile(2374, 3129, 0)
	);

	public int downStairsId = 4415;

}
