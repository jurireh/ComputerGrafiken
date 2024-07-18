package cgg.a07;
import cgtools.*;

import cgtools.Sampler;

public class Constant implements Sampler {
    protected Color color;

    public Constant(Color color){
        this.color = color;
    }

    public Color getColor(double u, double v){
        return color;
    }
}
