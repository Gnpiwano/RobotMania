package com.downsider.robotmania.controller;

import com.badlogic.gdx.Game;
import com.downsider.robotmania.Screens.PlayScreen;

/**
 * Created by Guus on 7-7-2016.
 */
public class GameController extends Game {

    private PlayScreen playScreen;

    public GameController() {
        playScreen = new PlayScreen();
    }

    @Override
    public void create() {
        setScreen(playScreen);
    }
}
