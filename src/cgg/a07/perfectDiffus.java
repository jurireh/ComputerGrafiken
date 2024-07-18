package cgg.a07;
import cgtools.*;

public class perfectDiffus implements Material {
    protected Sampler albedo;
    
    public perfectDiffus(Sampler albedo ){
        this.albedo = albedo;
    }
    @Override
    public Color emmission(Ray r, Hit h) {
        return new Color(0,0,0);
    }

    @Override
    public Color albedo(Ray r, Hit h) {
      return albedo.getColor(h.u(), h.v());
    }

    @Override
    public Ray reflectedRay(Ray r, Hit h) {
        double x = 1;
        double y = 1;
        double z = 1;
        Direction di = new Direction(x,y,z);
       while( Vector.length(di)> 1 ){
           x = Random.random() * 2 -1;
           y = Random.random() * 2 -1;
           z = Random.random() * 2 -1;
           di = new Direction(x,y,z);
       }
       Direction a = Vector.normalize(Vector.add(di, h.n()));
       return new Ray(h.x(), a, 0.0001, Double.POSITIVE_INFINITY);
    }
}
