package com.downsider.robotmania.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.downsider.robotmania.RobotMania;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class PlayScreen implements Screen{

    private IGameState gameState;
    private SpriteBatch spriteBatch;

    private OrthographicCamera gamecam;
    private Viewport gamePort;

    public PlayScreen(IGameState state, SpriteBatch spriteBatch) {
        this.gameState = state;
        this.spriteBatch = spriteBatch;


        gamecam = new OrthographicCamera();
        gamePort = new ScreenViewport();

        gamecam.position.set(gamePort.getWorldWidth() /2, gamePort.getWorldHeight() /2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gamecam.update();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameState.update();
        gameState.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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
