package com.downsider.robotmania.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.downsider.robotmania.Screens.PlayScreen;
import com.downsider.robotmania.model.states.PlayingState;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class GameController {

    private Screen currentScreen;
    private Game game;
    private IGameState currentState;

    private SpriteBatch spriteBatch;

    public GameController(Game game) {
        spriteBatch = new SpriteBatch();
        currentState = new PlayingState(currentScreen, spriteBatch);
        currentScreen = new PlayScreen(currentState, spriteBatch);



        this.game = game;
        this.game.setScreen(currentScreen);
    }


}
