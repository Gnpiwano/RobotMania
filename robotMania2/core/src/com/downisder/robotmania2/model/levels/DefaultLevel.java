package com.downisder.robotmania2.model.levels;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.downisder.robotmania2.model.CameraView;

/**
 * Created by Gebruiker on 17-8-2016.
 */
public abstract class DefaultLevel {

    protected CameraView cameraView;

    protected TmxMapLoader mapLoader;
    protected TiledMap map;
    protected OrthogonalTiledMapRenderer renderer;
    protected World world;
    protected Box2DDebugRenderer b2dr;
    protected TextureAtlas atlas;

}
