package com.downsider.robotmania;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downsider.robotmania.Screens.PlayScreen;
import com.downsider.robotmania.controller.GameController;

public class RobotMania extends Game {

	GameController controller;

	@Override
	public void create () {
		controller = new GameController(this);
	}

	@Override
	public void render () {
		super.render();
	}
}
