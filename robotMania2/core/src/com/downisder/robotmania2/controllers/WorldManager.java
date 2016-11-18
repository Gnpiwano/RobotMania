package com.downisder.robotmania2.controllers;

import com.downisder.robotmania2.model.CameraView;
import com.downisder.robotmania2.model.inputHandlers.DefaultInputHandler;
import com.downisder.robotmania2.model.inputHandlers.IInputHandler;
import com.downisder.robotmania2.model.levels.ILevel;
import com.downisder.robotmania2.model.players.Player;

/**
 * Created by Gebruiker on 18-8-2016.
 */
public class WorldManager {

    private ILevel currentLevel;
    private IInputHandler inputHandler;
    private Player player;

    private GameController gameController;

    private CameraView cameraView;


    public WorldManager(CameraView cameraView, ILevel level, Player player, GameController gameController) {
        this.currentLevel = level;
        this.player = player;
        this.gameController = gameController;

        this.cameraView = cameraView;
        this.inputHandler = new DefaultInputHandler(cameraView, player);

        this.cameraView.getGamecam().position.set(cameraView.getGamePort().getWorldWidth() /2, cameraView.getGamePort().getWorldHeight() /2, 0);
        currentLevel = level;
    }

    private void handleInput(float deltaTime) {
        inputHandler.handleInput(deltaTime);
    }

    public void updateGame(float deltaTime) {
        handleInput(deltaTime);
        this.currentLevel.getWorld().step(1 / 60f, 6, 2);

        player.update(deltaTime);

        cameraView.getGamecam().position.x = player.b2body.getPosition().x;
        cameraView.getGamecam().position.y = player.b2body.getPosition().y;

        cameraView.getGamecam().update();
        currentLevel.getRenderer().setView(cameraView.getGamecam());
    }

    public void renderGame(float deltaTime) {
        currentLevel.render();

        gameController.batch.setProjectionMatrix(cameraView.getGamecam().combined);

        gameController.batch.begin();
        player.draw(gameController.batch);
        gameController.batch.end();


        gameController.batch.setProjectionMatrix(currentLevel.getHud().stage.getCamera().combined);
        currentLevel.getHud().stage.draw();
    }

    public void setLevel(ILevel level) {
        this.currentLevel = level;
    }
    public CameraView getCameraView() { return this.cameraView; }

}
