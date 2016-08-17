package com.downsider.robotmania.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.downsider.robotmania.Constants;
import com.downsider.robotmania.RobotMania;
import com.sun.prism.image.ViewPort;

/**
 * Created by Guus on 8-7-2016.
 */
public class CameraManager {
    private OrthographicCamera gameCamera;
    private Viewport gameViewport;

    public CameraManager() {
        this.setDefaultCamera();
    }

    private void setDefaultCamera() {
        gameCamera = new OrthographicCamera();
        gameViewport = new ScreenViewport(); //FitViewport(Constants.V_WIDTH/ Constants.PPM, Constants.V_HEIGHT / Constants.PPM, gameCamera);
        gameCamera.position.set(gameViewport.getWorldWidth()/ 2, gameViewport.getWorldHeight() /2 , 0);
    }

    public OrthographicCamera getGameCamera() {
        return gameCamera;
    }

    public Viewport getGameViewPort() {
        return gameViewport;
    }
}
