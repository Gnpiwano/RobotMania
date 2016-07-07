package com.downsider.robotmania.model.states.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Guus on 7-7-2016.
 */
public interface IGameState {
    public void entered();
    public void leaving();
    public void update();
    public void draw();
}
