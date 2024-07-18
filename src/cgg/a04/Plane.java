package cgg.a04;

import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    protected Point p;
    protected Direction n;
    protected Color color;
    protected double radius;

    public Plane(Point p, Direction n, Color color){
        this.p= p;
        this.n = n;
        this.color = color;
        radius = Double.POSITIVE_INFINITY;
    }

    public Plane(Point p, Direction n, Color color, double radius){
        this.p= p;
        this.n = n;
        this.color = color;
        this.radius = radius;
    }

    public Hit intersect(Ray r){
        double a =  dotProduct( subtract(p, r.x0()),normalize(n));
        double b = dotProduct(r.d(),normalize(n));
        double t = a/b;

        if(length(subtract(r.pointAt(t), p)) < radius && r.isValid(t)){
            return new Hit(t, r.pointAt(t), n, color);
        }
        return null;
    }
}
