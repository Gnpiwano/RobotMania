package com.downsider.robotmania.model.level;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.downsider.robotmania.Constants;

/**
 * Created by Guus on 7-7-2016.
 */
public class Level {

    private World box2dWorld;
    private TiledMap tilemap;
    private OrthogonalTiledMapRenderer renderer;
    private Box2DDebugRenderer b2dr;

    public Level(World world, TiledMap tileMap) {
        box2dWorld = world;
        this.tilemap = tileMap;

        renderer = new OrthogonalTiledMapRenderer(tileMap, 1 / Constants.PPM);
        b2dr = new Box2DDebugRenderer();
    }

    public OrthogonalTiledMapRenderer getLevelRenderer() {
        return renderer;
    }

    public Box2DDebugRenderer getLevelDebugRenderer() {
        return b2dr;
    }
}
