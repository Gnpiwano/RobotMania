package com.downisder.robotmania2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.downisder.robotmania2.controllers.WorldManager;

/**
 * Created by Guus on 11-7-2016.
 */
public class PlayScreen implements Screen {

    private WorldManager worldManager;

    public PlayScreen(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.worldManager.updateGame(delta);

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.worldManager.renderGame(delta);
    }

    @Override
    public void resize(int width, int height) {
        worldManager.getCameraView().getGamePort().update(width, height);
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
