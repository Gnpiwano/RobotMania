package com.downsider.mariobros.sprites.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.downsider.mariobros.MarioBros;
import com.downsider.mariobros.Screens.PlayScreen;
import com.downsider.mariobros.sprites.Mario;

/**
 * Created by Gebruiker on 15-8-2016.
 */
public class SimpleGun extends Sprite {

    public World world;
    public Body b2body;

    public TextureRegion gunRegion;

    private Mario player;
    private boolean gunPointingRight;

    public SimpleGun(World world, PlayScreen screen, Mario player) {
        super(screen.getAtlas().findRegion("gun1"));
        gunRegion = screen.getAtlas().findRegion("gun1");

        this.world = world;
        this.player = player;

        gunPointingRight = true;

        setBounds(0, 0, 10 / MarioBros.PPM, 10 / MarioBros.PPM);



        setRegion(gunRegion);
    }

    public void update(float dt) {

        if(player.runningRight != gunPointingRight) {
            gunRegion.flip(true, false);

            this.gunPointingRight = player.runningRight;
            this.setRegion(gunRegion);
        }
        if(player.runningRight){
            setPosition(player.getX() + 14 / MarioBros.PPM, player.getY());
        } else {
            setPosition(player.getX() - 8 / MarioBros.PPM, player.getY());
        }


    }


}
