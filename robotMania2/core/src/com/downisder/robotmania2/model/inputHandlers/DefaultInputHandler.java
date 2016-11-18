package com.downisder.robotmania2.model.inputHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.downisder.robotmania2.model.CameraView;
import com.downisder.robotmania2.model.players.Player;

/**
 * Created by Gebruiker on 18-8-2016.
 */
public class DefaultInputHandler implements IInputHandler{

    private CameraView cameraView;
    private Player player;

    public DefaultInputHandler(CameraView cameraView , Player player) {
        this.cameraView = cameraView;
        this.player = player;
    }

    @Override
    public void handleInput(float deltaTime) {
        if (Gdx.input.isTouched()) {
            cameraView.getGamecam().position.x += 100 * deltaTime;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            cameraView.getGamecam().position.x += 1500 * deltaTime;
            player.b2body.applyLinearImpulse(new Vector2(0, 4f), player.b2body.getWorldCenter(), true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            cameraView.getGamecam().position.x -= 1500 * deltaTime;
            player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
            cameraView.getGamecam().position.x += 1500 * deltaTime;
            player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
        }
    }
}
