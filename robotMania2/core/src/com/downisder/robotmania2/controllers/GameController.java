package com.downisder.robotmania2.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downisder.robotmania2.RobotMania;
import com.downisder.robotmania2.model.CameraView;
import com.downisder.robotmania2.model.levels.ILevel;
import com.downisder.robotmania2.model.levels.marioOriginalLevel.MarioOriginalLevel;
import com.downisder.robotmania2.model.players.Player;
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

        CameraView cameraView = new CameraView();
        ILevel level = new MarioOriginalLevel(cameraView, this);
        Player player = new Player(level);
        WorldManager worldManager = new WorldManager(cameraView, level, player, this);


        playScreen = new PlayScreen(worldManager);

        //Do controller things
        game.setScreen(playScreen);
    }

}
