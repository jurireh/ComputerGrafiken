package cgg.a04;

import cgtools.*;
import static cgtools.Vector.*;

public class Background implements Shape {
    protected double radius;
    protected Color color;
    public Background(Color color){
        radius = Double.POSITIVE_INFINITY;
        this.color = color;
    }

    public Hit intersect(Ray r){
        Point treffer = r.pointAt(Double.POSITIVE_INFINITY);
            Hit hit = new Hit(Double.POSITIVE_INFINITY, treffer, negate(r.d()), color);
        return hit;
    }
}
