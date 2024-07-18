package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public class Background implements Shape {
    protected double radius;
    protected Material material;
    public Background(Material material){
        radius = Double.POSITIVE_INFINITY;
        this.material = material;
    }

    public Hit intersect(Ray r){
        Point treffer = r.pointAt(Double.POSITIVE_INFINITY);
            Hit hit = new Hit(Double.POSITIVE_INFINITY, treffer, negate(r.d()), material);
        return hit;
    }
}
