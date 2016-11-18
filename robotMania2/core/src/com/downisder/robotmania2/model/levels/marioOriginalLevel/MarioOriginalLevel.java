package com.downisder.robotmania2.model.levels.marioOriginalLevel;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.downisder.robotmania2.Constants;
import com.downisder.robotmania2.controllers.GameController;
import com.downisder.robotmania2.model.CameraView;
import com.downisder.robotmania2.model.levels.DefaultLevel;
import com.downisder.robotmania2.model.levels.ILevel;
import com.downisder.robotmania2.screens.scenes.Hud;

/**
 * Created by Gebruiker on 17-8-2016.
 */
public class MarioOriginalLevel extends DefaultLevel implements ILevel{

    private Hud hud;

    public MarioOriginalLevel(CameraView cameraView, GameController gameController) {
        this.mapLoader = new TmxMapLoader();
        //this.map = mapLoader.load("level1.tmx");
        this.map = mapLoader.load("Test1.tmx");
        this.renderer = new OrthogonalTiledMapRenderer(map, 1 / Constants.PPM);

        this.world = new World(new Vector2(0, -10), true);
        this.b2dr = new Box2DDebugRenderer();

        this.createBox2dWorld();

        this.atlas = new TextureAtlas("Mario_and_Enemies.pack");

        hud = new Hud(gameController.batch);
        this.cameraView = cameraView;
    }

    public void createBox2dWorld() {
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Constants.PPM, (rect.getY() + rect.getHeight() / 2) / Constants.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Constants.PPM, rect.getHeight() / 2 / Constants.PPM);
            fdef.shape = shape;

            body.createFixture(fdef);
        }
//
//        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Constants.PPM, (rect.getY() + rect.getHeight() / 2) / Constants.PPM);
//
//            body = world.createBody(bdef);
//
//            shape.setAsBox(rect.getWidth() / 2 / Constants.PPM, rect.getHeight() / 2 / Constants.PPM);
//            fdef.shape = shape;
//
//            body.createFixture(fdef);
//        }
//
//        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//
//            new Brick(world, map, rect);
//        }
//
//        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//            new Coin(world, map, rect);
//        }
    }

    public void render() {
        this.renderer.render();
        this.b2dr.render(this.world, cameraView.getGamecam().combined);
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public World getWorld() {
        return world;
    }

    public Box2DDebugRenderer getB2dr() {
        return b2dr;
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    public Hud getHud() { return this.hud; }
}