package com.webs.darkgoul123.handlers;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.webs.darkgoul123.interfaces.EnvironmentImpl;
import com.webs.darkgoul123.interfaces.SaradominImpl;

public class SaradominHandler implements SaradominImpl, EnvironmentImpl {

	public static void handle() {
		if(Game.getClientState() == 7) {
			if(Mouse.click(400, 450, true)) {
				Time.sleep(Random.nextInt(750, 1250));
			}
		}
		Tile myLocation = Players.getLocal().getLocation();
		SceneObject portal = SceneEntities.getNearest(saradominPortalId);
		if(Widgets.get(985).getChild(2).isOnScreen()) {
			if(Widgets.get(985).getChild(77).click(true)){
				Time.sleep(Random.nextInt(750, 1250));
			}
		}
		if(castleArea.contains(myLocation)) {
			GuthixHandler.enterPortal(portal);
		} else {
			GuthixHandler.handle();
		}
	}
}
