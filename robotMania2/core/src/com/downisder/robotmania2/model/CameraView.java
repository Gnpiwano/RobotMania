package com.downisder.robotmania2.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.downisder.robotmania2.Constants;

/**
 * Created by Guus on 11-7-2016.
 */
public class CameraView {

    private OrthographicCamera gamecam;
    private Viewport gamePort;

    public CameraView() {
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(Constants.V_WIDTH / Constants.PPM, Constants.V_HEIGHT / Constants.PPM ,gamecam);
    }

    public OrthographicCamera getGamecam() {
        return gamecam;
    }

    public Viewport getGamePort() {
        return gamePort;
    }
}
