package com.mygdx.clock;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Besten on 2015-11-24.
 */
public class AnalogClock {

    int x = 540; // Mitt på skärmen
    int y = 960;
    int radius = 470;
    double SecondAngle = 4.7;
    double MinuteAngle = 4.7; // Startvinkel, blir kl 12 om man har 4.7 av nån anledning
    double HourAngle = 4.7;



    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(x,y,radius + 20);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(x, y, 10);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.line(x, y, (int) (x + (radius-20) * Math.cos(SecondAngle)), (int) (y + (radius-20) * Math.sin(SecondAngle)));
        shapeRenderer.circle((int) (x + (radius-20) * Math.cos(SecondAngle)), (int) (y + (radius-20) * Math.sin(SecondAngle)), 10);
        shapeRenderer.line(x, y, (int) (x + (radius-20) * Math.cos(MinuteAngle)), (int) (y + (radius-20) * Math.sin(MinuteAngle)));
        shapeRenderer.circle((int) (x + (radius-20) * Math.cos(MinuteAngle)), (int) (y + (radius-20) * Math.sin(MinuteAngle)), 10);
        shapeRenderer.line(x, y, (int) (x + (radius-20) * Math.cos(HourAngle)), (int) (y + (radius-20) * Math.sin(HourAngle)));
        shapeRenderer.circle((int) (x + (radius-20) * Math.cos(HourAngle)), (int) (y + (radius-20) * Math.sin(HourAngle)), 10);
        shapeRenderer.end();
    }

    public void update() {
        SecondAngle += 0.16; //Ta reda på hur snabbt den ska snurra
        MinuteAngle += 0.002777; //
        HourAngle += 0.0004629;

    }
}
