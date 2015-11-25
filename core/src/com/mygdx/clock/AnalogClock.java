package com.mygdx.clock;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Besten on 2015-11-24.
 */
public class AnalogClock {

    float x = 540; // Mitt på skärmen
    float y = 960;
    float radius = 470;
    float SecondAngle = MathUtils.degreesToRadians * 270;
    float MinuteAngle = MathUtils.degreesToRadians * 270;
    float HourAngle = MathUtils.degreesToRadians * 270;

    int seconds;
    String time;
    BitmapFont Bitmap;
    SpriteBatch batch;

    AnalogClock() {
        seconds = 0;
        time = "Time: 0.0.00";
        Bitmap = new BitmapFont();
        batch = new SpriteBatch();
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(x, y, radius + 20);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(x, y, 10);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.line(x, y - 450, x, y);

        shapeRenderer.line(x, y, (int) (x + (radius - 20) * Math.cos(SecondAngle)), (int) (y + (radius - 20) * Math.sin(SecondAngle)));
        shapeRenderer.circle((int) (x + (radius - 20) * Math.cos(SecondAngle)), (int) (y + (radius - 20) * Math.sin(SecondAngle)), 10);
        shapeRenderer.line(x, y, (int) (x + (radius - 60) * Math.cos(MinuteAngle)), (int) (y + (radius - 60) * Math.sin(MinuteAngle)));
        shapeRenderer.circle((int) (x + (radius - 60) * Math.cos(MinuteAngle)), (int) (y + (radius - 60) * Math.sin(MinuteAngle)), 10);
        shapeRenderer.line(x, y, (int) (x + (radius - 100) * Math.cos(HourAngle)), (int) (y + (radius - 100) * Math.sin(HourAngle)));
        shapeRenderer.circle((int) (x + (radius - 100) * Math.cos(HourAngle)), (int) (y + (radius - 100) * Math.sin(HourAngle)), 10);
        shapeRenderer.rect(538, 475, 4, 60);
        shapeRenderer.rect(538, 1390, 4, 60);
        shapeRenderer.rect(50, 960, 60, 4);
        shapeRenderer.rect(960, 960, 60, 4);
        shapeRenderer.end();

        batch.begin();
        Bitmap.setColor(Color.BLACK);
        Bitmap.draw(batch, time, 500, 1700);
        batch.end();
    }

    public void update() {
        SecondAngle += (MathUtils.PI * 2) / 60; //Ta reda på hur snabbt den ska snurra
        MinuteAngle += (MathUtils.PI * 2) / 3600; //
        HourAngle += (MathUtils.PI * 2) / 216000;

    }
}
