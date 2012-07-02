package com.gmail.darkgoul123;

import org.powerbot.concurrent.LoopTask;

import com.gmail.darkgoul123.handlers.GuthixHandler;
import com.gmail.darkgoul123.handlers.SaradominHandler;
import com.gmail.darkgoul123.handlers.ZamorakHandler;

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
				new GuthixHandler();
			} else if(t == Team.SARADOMIN) {
				new SaradominHandler();
			} else {
				new ZamorakHandler();
			}
		}
		return 0;
	}

}
