package com.downsider.vsr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
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

/**
 * Created by Gebruiker on 15-11-2016.
 */
public class Gamescreen implements Screen, InputProcessor {

    Texture img;
    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthographicCamera camera2;
    TiledMapRenderer tiledMapRenderer;


    private Box2DDebugRenderer b2dr;
    private World world;

    public Gamescreen () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        b2dr = new Box2DDebugRenderer();
        world = new World(new Vector2(0, -10), true);

        camera = new OrthographicCamera();
        camera2 = new OrthographicCamera();

//        camera2.viewportWidth = 300;
//        camera2.viewportHeight = 300;


        camera.setToOrtho(false,w,h);
        camera2.setToOrtho(false,w,h);
        camera.update();
        camera.translate(-208, -152);
        camera2.translate(-208, -152);
        camera.zoom = 0.3f;
        tiledMap = new TmxMapLoader().load("level2.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        Gdx.input.setInputProcessor(this);

        this.boxedWorldCreator();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        camera2.update();

        tiledMapRenderer.setView(camera2);
//        tiledMapRenderer.setView(camera2);
        tiledMapRenderer.render();

        b2dr.render(world, camera.combined);
//        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//        stage.draw();
    }

    public void boxedWorldCreator() {

        BodyDef bodyDefinement = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        // floor
        MapLayer a = tiledMap.getLayers().get("ground");
        System.out.println(a);
        for (MapObject object : tiledMap.getLayers().get("ground").getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDefinement.type = BodyDef.BodyType.StaticBody;
            bodyDefinement.position.set((rect.getX() + rect.getWidth() / 2) , (rect.getY() + rect.getHeight() / 2));

            body = world.createBody(bodyDefinement);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
