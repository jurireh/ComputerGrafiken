package cgg.a07;
import cgtools.*;

public class Backmaterial implements Material {
    protected Sampler color;

    public Backmaterial(Sampler color){
        this.color =color;
    }

    @Override
    public Color albedo(Ray r, Hit h) {
        return null;
    }

    @Override
    public Color emmission(Ray r, Hit h) {
        return color.getColor(h.u(), h.v());
    }

    @Override
    public Ray reflectedRay(Ray r, Hit h) {
        return null;
    }
}
