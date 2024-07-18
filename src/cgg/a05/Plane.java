package cgg.a05;

import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    protected Point p;
    protected Direction n;
    protected Material material;
    protected double radius;

    public Plane(Point p, Direction n, Material material){
        this.p= p;
        this.n = n;
        this.material = material;
        radius = Double.POSITIVE_INFINITY;
    }

    public Plane(Point p, Direction n,Material material, double radius){
        this.p= p;
        this.n = n;
        this.material = material;
        this.radius = radius;
    }

    public Hit intersect(Ray r){
        double a =  dotProduct( subtract(p, r.x0()),normalize(n));
        double b = dotProduct(r.d(),normalize(n));
        double t = a/b;

        if(length(subtract(r.pointAt(t), p)) < radius && r.isValid(t)){
            return new Hit(t, r.pointAt(t), n, material);
        }
        return null;
    }
}
