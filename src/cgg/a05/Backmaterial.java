package cgg.a05;
import cgtools.*;

public class Backmaterial implements Material {
    protected Color color;

    public Backmaterial(Color color){
        this.color =color;
    }

    @Override
    public Color albedo(Ray r, Hit h) {
        return null;
    }

    @Override
    public Color emmission(Ray r, Hit h) {
        return color;
    }

    @Override
    public Ray reflectedRay(Ray r, Hit h) {
        return null;
    }
}
