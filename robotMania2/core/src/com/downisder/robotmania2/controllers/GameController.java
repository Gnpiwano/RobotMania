package com.downisder.robotmania2.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downisder.robotmania2.RobotMania;
import com.downisder.robotmania2.screens.PlayScreen;

/**
 * Created by Guus on 11-7-2016.
 */
public class GameController {

    public SpriteBatch batch;
    private PlayScreen playScreen;

    public GameController(RobotMania game) {
        //Set Hard Variables
        batch = new SpriteBatch();
        playScreen = new PlayScreen(this);

        //Do controller things
        game.setScreen(playScreen);
    }

}
