package com.webs.darkgoul123;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;

import com.webs.darkgoul123.gui.TeamChooser;

@Manifest(
		authors = { "DarkGhoul45" },
		name = "CastleWars",
		version = 1.00D,
		description = "Plays Castle Wars."
)

public class CastleWars extends ActiveScript {

	@Override
	protected void setup() {
		new TeamChooser().setVisible(true);
		submit(new Loop());
	}

}
