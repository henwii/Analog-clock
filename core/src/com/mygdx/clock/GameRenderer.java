package com.mygdx.clock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Besten on 2015-11-24.
 */
public class GameRenderer {

    AnalogClock clock = new AnalogClock();

    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;


    public GameRenderer() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1080, 1920);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        clock.render(shapeRenderer);
    }

    public void update(float delta) {
        clock.update();
    }
}
