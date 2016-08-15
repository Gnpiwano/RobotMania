package com.downsider.robotmania.model.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class PlayingState implements IGameState {

    private Screen screen;
    private SpriteBatch spriteBatch;
    Texture img;

    //TEMPORARY INTS
    private int imgX = 0;
    private int imgY = 0;

    public PlayingState(Screen screen, SpriteBatch spriteBatch) {
        img = new Texture("badlogic.jpg");
        this.spriteBatch = spriteBatch;
        this.screen = screen;
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
    }

    @Override
    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(img, imgX, imgY);
        spriteBatch.end();
    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            imgY += 5;
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            imgX += 5;
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            imgX -= 5;
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            imgY -= 5;
        }
    }
}
