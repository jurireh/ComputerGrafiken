package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

import java.util.ArrayList;

public class BildKugel implements Sampler {
    protected Camera camera;
    protected Kugel k1;
    protected Kugel k3;
    protected Kugel k2;
    protected Point x0;
    protected ArrayList<Kugel> list;

    public BildKugel(){
         x0 = new Point(0,0,0);
         list = new ArrayList<Kugel>();
         camera = new Camera(Math.PI/2, 480, 270);
         k1 = new  Kugel(new Point(-5, 0, -30), 5, new Color(0, 1, 0));
         k2 = new  Kugel(new Point(10, 0, -30), 10, new Color(0, 1, 1));
         k3 = new  Kugel(new Point(5, 0, -30), 6, new Color(1, 0, 0));
         list.add(k1);
         list.add(k2);
         list.add(k3);

    }

    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1, 1, 0.5));
        Color ambient = multiply(0.1, color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)), color);
        return add(ambient, diffuse);
    }
    
    public Color getColor(double x, double y){
        Ray d = camera.generateRay(x,y);
            for( Kugel k: list){
                Hit hit = k.intersect(d);
                if(hit != null){
                return shade(hit.n(), hit.c());
            }
        }
        return new Color (0,0,0);
    }
}
