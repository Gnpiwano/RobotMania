package com.downisder.robotmania2.model.players;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.downisder.robotmania2.Constants;
import com.downisder.robotmania2.model.levels.ILevel;

/**
 * Created by Gebruiker on 17-8-2016.
 */
public class Player extends Sprite {

    public enum State {STANDING, FALLING , RUNNING, JUMPING}
    public State currentState;
    public State previousState;

    public World world;
    public Body b2body;
    private TextureRegion marioStand;

    private Animation marioRun;
    private Animation marioJump;
    private float stateTimer;
    public boolean runningRight;

    public Player(ILevel currentLevel) {
        super(currentLevel.getAtlas().findRegion("little_mario"));
        this.world = currentLevel.getWorld();
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        this.setDefaultAnimations(currentLevel);
    }

    private void setDefaultAnimations(ILevel level) {
        Array<TextureRegion> frames = new Array<TextureRegion>();

        for(int i = 1; i < 4; i++) {
            frames.add(new TextureRegion(level.getAtlas().findRegion("little_mario"), i * 16, 0, 16, 16));
        }
        marioRun = new Animation(0.1f, frames);
        frames.clear();

        for(int i = 4; i < 6; i++) {
            frames.add(new TextureRegion(level.getAtlas().findRegion("little_mario"), i * 16, 0, 16, 16));
        }
        marioJump = new Animation(0.1f, frames);
        frames.clear();


        definePlayer();

        marioStand = new TextureRegion(getTexture(), 0,0, 16, 16);
        setBounds(0,0,16 / Constants.PPM,16 / Constants.PPM);
        setRegion(marioStand);
    }

    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() /2, b2body.getPosition().y - getHeight() /2);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        currentState = getState();
        TextureRegion region;
        switch (currentState) {
            case JUMPING:
                region = marioJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = marioRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = marioStand;
                break;
        }

        if((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        }
        else if ((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;

        return  region;
    }


    public State getState() {
        if(b2body.getLinearVelocity().y > 0 || b2body.getLinearVelocity().y < 0 && previousState == State.JUMPING){
            return State.JUMPING;
        }
        else if(b2body.getLinearVelocity().y < 0) {
            return State.FALLING;
        }
        else if(b2body.getLinearVelocity().x != 0) {
            return State.RUNNING;
        } else {
            return State.STANDING;
        }
    }

    public void definePlayer() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(100 / Constants.PPM, 100 / Constants.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();

        CircleShape shape = new CircleShape();
        shape.setRadius(6 / Constants.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2 / Constants.PPM, 6 / Constants.PPM), new Vector2(+2 / Constants.PPM, 6 / Constants.PPM));
        fdef.shape = head;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData("head");
    }

}
