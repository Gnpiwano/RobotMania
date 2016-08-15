package com.downsider.robotmania.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downsider.robotmania.RobotMania;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class PlayScreen implements Screen{

    private IGameState gameState;
    private SpriteBatch spriteBatch;

    public PlayScreen(IGameState state, SpriteBatch spriteBatch) {
        this.gameState = state;
        this.spriteBatch = spriteBatch;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameState.update();
        gameState.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
