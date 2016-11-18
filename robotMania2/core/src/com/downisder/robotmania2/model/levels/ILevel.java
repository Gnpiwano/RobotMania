package com.downisder.robotmania2.model.levels;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.downisder.robotmania2.screens.scenes.Hud;

/**
 * Created by Gebruiker on 17-8-2016.
 */
public interface ILevel {

    void createBox2dWorld();
    void render();


    OrthogonalTiledMapRenderer getRenderer();
    World getWorld();
    Box2DDebugRenderer getB2dr();
    TextureAtlas getAtlas();
    Hud getHud();

}
