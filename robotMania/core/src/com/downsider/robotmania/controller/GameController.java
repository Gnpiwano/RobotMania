package com.downsider.robotmania.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.downsider.robotmania.Screens.PlayScreen;
import com.downsider.robotmania.factorys.LevelFactory;
import com.downsider.robotmania.model.level.Level;
import com.downsider.robotmania.model.states.PlayingState;
import com.downsider.robotmania.model.states.base.IGameState;

/**
 * Created by Guus on 7-7-2016.
 */
public class GameController {

    private World box2dWorld;
    private Game game;
    private Screen currentScreen;
    private IGameState currentState;
    private Level currentLevel;

    private SpriteBatch spriteBatch;
    private CameraManager cameraManager;

    //factorys
    LevelFactory levelFactory;

    public GameController(Game game) {
        box2dWorld = new World(new Vector2(0, -10), true);

        cameraManager = new CameraManager();

        levelFactory = new LevelFactory(box2dWorld);
        this.currentLevel = levelFactory.createLevel("level1.tmx");


        spriteBatch = new SpriteBatch();
        currentState = new PlayingState(currentScreen, spriteBatch, currentLevel, box2dWorld, cameraManager);
        currentScreen = new PlayScreen(currentState, spriteBatch);
        this.game = game;
        this.game.setScreen(currentScreen);


    }




}
