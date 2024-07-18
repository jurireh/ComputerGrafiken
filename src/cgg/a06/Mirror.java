package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public class Mirror implements Material {
    protected Color albedo;
    protected double streuungsfaktor;
    public Mirror(Color albedo, double streuungsfaktor){
    this.albedo = albedo;
    this.streuungsfaktor = streuungsfaktor;       
    }

    @Override
    public Color emmission(Ray r, Hit h) {
        return new Color(0,0,0);
    }

    @Override
    public Color albedo(Ray r, Hit h) {
       return albedo;
    }

    @Override
    public Ray reflectedRay(Ray r, Hit h) {
        Direction ra =subtract(r.d(),multiply((2 *(dotProduct(r.d(), h.n()))),h.n()));
        double x = 1;
        double y = 1;
        double z = 1;
        Direction di = new Direction(x,y,z);
        boolean whiles = false;
        Direction rs = ra;
       while( whiles == false){
           x = Random.random() * 2 -1 ;
           y = Random.random()* 2 -1 ;
           z = Random.random()* 2 -1 ;
           di = new Direction(x,y,z);
           rs = add(multiply(streuungsfaktor, di),ra);
            if(Vector.length(di)> 1 ){
                if(dotProduct(rs, h.n()) >= 0){
                whiles = true;
                }
           }
           

       }
        return new Ray(h.x(),rs,0.0001, Double.POSITIVE_INFINITY);
    }
    
}
