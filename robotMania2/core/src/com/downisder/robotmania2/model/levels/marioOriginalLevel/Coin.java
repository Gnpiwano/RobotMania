package com.downisder.robotmania2.model.levels.marioOriginalLevel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Gebruiker on 17-8-2016.
 */
public class Coin extends InteractiveTileObject {

    public Coin(World world , TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin","Collision");
    }
}
