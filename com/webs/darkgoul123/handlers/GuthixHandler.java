package com.webs.darkgoul123.handlers;


import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.Player;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.webs.darkgoul123.Loop;
import com.webs.darkgoul123.interfaces.EnvironmentImpl;
import com.webs.darkgoul123.interfaces.GuthixImpl;

public class GuthixHandler implements GuthixImpl, EnvironmentImpl {

	public static void handle() {
		Tile myLocation = Players.getLocal().getLocation();
		boolean inWaitingRoom = Widgets.get(57).getChild(1).isOnScreen();
		SceneObject portal = SceneEntities.getNearest(guthixPortalId);
		SceneObject ladder = SceneEntities.getNearest(saradominLadderId, zamorakLadderId);
		SceneObject stairs = SceneEntities.getNearest(downStairsId);
		if(Widgets.get(985).getChild(2).isOnScreen()) {
			if(Widgets.get(985).getChild(77).click(true)){
				Time.sleep(Random.nextInt(750, 1250));
			}
		}
		if(castleArea.contains(myLocation)) {
			enterPortal(portal);
		} else if(inWaitingRoom) {
			if(Widgets.get(1188).getChild(3).isOnScreen()) {
				if(Widgets.get(1188).getChild(3).click(true)) {
					Time.sleep(Random.nextInt(750, 1250));
				}
			}
			waitForGame(myLocation);
		} else {
			if(Loop.s == Loop.Style.AFK) {
				if(ladder != null) {
					if(!ladder.isOnScreen()) {
						Camera.turnTo(ladder);
						Time.sleep(Random.nextInt(750, 1250));
					}
					ladder.interact("Climb");
					Time.sleep(Random.nextInt(750, 1250));
				} else {
					Tile t = new Tile(0, 0, 0);
					waitForGame(t);
				}
			} else {
				if(ladder != null && SceneEntities.getNearest(4472) == null && ladder.getLocation().canReach()) {
					if(!ladder.isOnScreen()) {
						Camera.turnTo(ladder);
						Time.sleep(Random.nextInt(750, 1250));
					}
					ladder.interact("Climb");
					Time.sleep(Random.nextInt(750, 1250));
				} else if(SceneEntities.getNearest(4472) != null) {
					Camera.turnTo(stairs);
					stairs.hover();
					stairs.click(true);
					Time.sleep(Random.nextInt(750, 1250));
				} else {
					fight();
				}
			}
		}
	}

	public static void enterPortal(SceneObject portal) {
		if(!portal.isOnScreen()) {
			Camera.turnTo(portal);
			Time.sleep(Random.nextInt(750, 1250));
		}
		portal.interact("Enter");
		Time.sleep(Random.nextInt(750, 1250));
	}

	private static void fight() {
		for(Player player : Players.getLoaded()) {
			if(player.getTeam() != Players.getLocal().getTeam()) {
				if(!Players.getLocal().isInCombat()) {
					if(player.isOnScreen()) {
						Camera.turnTo(player);
						Time.sleep(Random.nextInt(750, 1250));
					}
					if(player.interact("Attack")) {
						Time.sleep(Random.nextInt(750, 1250));
					}
				}
			} else {
				Tile t = new Tile(0, 0, 0);
				waitForGame(t);
			}
		}
	}

	private static void waitForGame(Tile myLocation) {
		int number = Random.nextInt(0, 10);
		switch(number) {
		case 0 :
			Mouse.move(Random.nextInt(0, 700), Random.nextInt(0, 503));
			Camera.setAngle(Random.nextInt(0, 360));
			Camera.setPitch(Random.nextInt(0, 20));
			break;
		case 1 :
			int x = Random.nextInt(0, 2);
			int y = Random.nextInt(2, 4);
			if(x == 1) {
				x = -x;
			}
			if(y == 3) {
				y = -y;
			}
			if(myLocation.getX() != 0) {
				Tile newLocation = new Tile(myLocation.getX() + x, myLocation.getY() + y, 0);
				Walking.walk(newLocation);
			}
			break;
		default :
			Time.sleep(Random.nextInt(700, 1250));
			break;
		}
	}

}