package com.downisder.robotmania2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downisder.robotmania2.controllers.GameController;
import com.downisder.robotmania2.screens.PlayScreen;

public class RobotMania extends Game {

	private GameController controller;
	//public SpriteBatch batch;

	@Override
	public void create () {
		controller = new GameController(this);
//		batch = new SpriteBatch();
//		setScreen(new PlayScreen(this));
	}

	@Override
	public void render() {
		super.render();
		//controller.render();
	}
}
