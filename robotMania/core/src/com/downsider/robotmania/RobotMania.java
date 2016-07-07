package com.downsider.robotmania;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downsider.robotmania.controller.GameController;

public class RobotMania extends ApplicationAdapter {

	@Override
	public void create () {
		GameController gameController = new GameController();
	}

	@Override
	public void render () {
		super.render();
	}
}
