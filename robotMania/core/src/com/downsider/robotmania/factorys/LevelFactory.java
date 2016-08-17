package com.downsider.robotmania.factorys;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.downsider.robotmania.Constants;
import com.downsider.robotmania.model.level.Level;

/**
 * Created by Guus on 8-7-2016.
 */
public class LevelFactory  {

    private TmxMapLoader mapLoader;
    private World box2dWorld;

    public LevelFactory(World box2dWorld) {
        mapLoader = new TmxMapLoader();
        this.box2dWorld = box2dWorld;
    }

    public Level createLevel(String levelName) { // example level1.tmx
        TiledMap map;
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //map = mapLoader.load("level1.tmx");
        map = mapLoader.load(levelName);

        if(map == null) {
            System.out.println("levelName doesn't exist");
        }



        //Build al layers from the game by name with reflection white object factory.

        return new Level(box2dWorld, map);
    }
}
