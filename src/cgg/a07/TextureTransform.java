package cgg.a07;

import cgtools.Color;
import cgtools.Matrix;
import cgtools.Point;
import cgtools.Sampler;

public class TextureTransform implements Sampler{
    Sampler texture;
    Matrix transform;

    public TextureTransform(Sampler texture, Matrix transform){
        this.texture = texture;
        this.transform = transform;
    }

    @Override
    public Color getColor(double u, double v) {
        Point p = Matrix.multiply(transform, new Point(u, v, 0));
        return texture.getColor(p.x(), p.y());
    }


}
