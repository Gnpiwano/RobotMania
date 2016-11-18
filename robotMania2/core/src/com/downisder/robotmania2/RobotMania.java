package com.downisder.robotmania2;

import com.badlogic.gdx.Game;
import com.downisder.robotmania2.controllers.GameController;

public class RobotMania extends Game {

	private GameController controller;

	@Override
	public void create () {
		controller = new GameController(this);
	}

	@Override
	public void render() {
		super.render();
	}
}
