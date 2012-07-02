package com.webs.darkgoul123;

import org.powerbot.concurrent.LoopTask;

import com.webs.darkgoul123.handlers.GuthixHandler;
import com.webs.darkgoul123.handlers.SaradominHandler;
import com.webs.darkgoul123.handlers.ZamorakHandler;

public class Loop extends LoopTask {

	public enum Team {
		GUTHIX, ZAMORAK, SARADOMIN
	}

	public enum Style {
		AFK, ATTACK
	}

	public static Team t;
	public static Style s;

	@Override
	public int loop() {
		boolean gotTeam = t != null;
		boolean gotStyle = s != null;
		if(gotTeam && gotStyle) {
			if(t == Team.GUTHIX) {
				GuthixHandler.handle();
			} else if(t == Team.SARADOMIN) {
				SaradominHandler.handle();
			} else {
				ZamorakHandler.handle();
			}
		}
		return 0;
	}

}
