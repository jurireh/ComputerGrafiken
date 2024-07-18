package cgg.a07;

import cgtools.*;
import static cgtools.Vector.*;

public class Background implements Shape {
    protected double radius;
    protected Material material;
    public Background(Material material){
        radius = Double.POSITIVE_INFINITY;
        this.material = material;
    }

    public Hit intersect(Ray ray){
        double inclination = Math.acos(ray.d().y());
        double azimuth = Math.PI + Math.atan2(ray.d().x(), ray.d().z());
        double u = azimuth / (2 * Math.PI);
        double v = inclination / Math.PI;
        return new Hit(Double.POSITIVE_INFINITY, ray.pointAt(Double.POSITIVE_INFINITY), negate(ray.d()),u,v, material);
    }
}
