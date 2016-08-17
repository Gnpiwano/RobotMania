package com.downsider.robotmania.model.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.downsider.robotmania.controller.CameraManager;
import com.downsider.robotmania.model.level.Level;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class PlayingState implements IGameState {

    private Screen screen;
    private SpriteBatch spriteBatch;
    private Level currentLevel;
    private World gameWorld;
    private CameraManager cameraManager;

    Texture img;


    //TEMPORARY INTS
    private int imgX = 50;
    private int imgY = 50;

    public PlayingState(Screen screen, SpriteBatch spriteBatch, Level currentLevel, World world, CameraManager cameraManager) {
        img = new Texture("badlogic.jpg");
        this.spriteBatch = spriteBatch;
        this.gameWorld = world;
        this.screen = screen;
        this.currentLevel = currentLevel;
        this.cameraManager = cameraManager;
        this.entered();
    }

    @Override
    public void entered() {

    }

    @Override
    public void leaving() {
        img.dispose();
    }

    @Override
    public void update() {
        this.handleInput();
        gameWorld.step(1 / 60f, 6, 2);
        cameraManager.getGameCamera().update();
        currentLevel.getLevelRenderer().setView(cameraManager.getGameCamera());
        //this.currentLevel.getLevelDebugRenderer().render(world);
    }

    @Override
    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(img, imgX, imgY);
        spriteBatch.end();
        this.currentLevel.getLevelRenderer().render();
    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            cameraManager.getGameCamera().position.set(cameraManager.getGameCamera().position.x, cameraManager.getGameCamera().position.y + 10, 0);
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            cameraManager.getGameCamera().position.set(cameraManager.getGameCamera().position.x + 10, cameraManager.getGameCamera().position.y, 0);
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            cameraManager.getGameCamera().position.set(cameraManager.getGameCamera().position.x - 10, cameraManager.getGameCamera().position.y, 0);
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            cameraManager.getGameCamera().position.set(cameraManager.getGameCamera().position.x, cameraManager.getGameCamera().position.y - 10, 0);
        }

        System.out.println(cameraManager.getGameCamera().position);
    }
}
