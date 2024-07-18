package cgg.a05;

import cgtools.*;
import static cgtools.Vector.*;


public class Raytracer implements Sampler {
    protected double width;
    protected double height;
    protected Camera camera;
    protected Group group;
    protected Group group2;

    public Raytracer(double width, double height){
        this.width = width;
        this.height = height;
        group = new Group();
        group2 = new Group();
        camera = new Camera( Math.PI / 3, width,height);
        //Bild1
        Shape background = new Background(new Backmaterial(white));
        Shape globe1 = new Kugel(new Point(-1.0, -0.25, -2.5),0.5,new perfectDiffus(red));
        Shape globe2 = new Kugel(point(0.0, 0, -2.5), 0.3, new perfectDiffus(green));
        Shape globe3 = new Kugel(point(1.0, -0.25, -2.5), 0.5, new perfectDiffus(new Color(0,1,1)));
        Shape globe4 = new Kugel(point(-1.0, -0.25, -2), 0.1, new perfectDiffus(new Color(0,1,1)));
        Shape ground = new Plane(point(0.0, -0.5, -0.5), direction(0, 1, 0), new perfectDiffus(gray),Double.POSITIVE_INFINITY);
        group.add(background);
        group.add(globe1);
        group.add(globe2);
        group.add(globe3);
        group.add(ground);
        group.add(globe4);
        //Bild2

    }

    public Color radiance(Ray ray, Group scene, int depth){
        if(depth == 0){
            return black;
        }
        Hit hit = scene.intersect(ray);
        Ray a = hit.material().reflectedRay(ray, hit);
        if(a != null){
            return  add(multiply(hit.material().albedo(ray, hit), radiance(a, scene, depth-1)),hit.material().emmission(ray, hit));
           //return Vector.asColor(a.d());
        }
        else 
        return hit.material().emmission(ray, hit);
    }
    
    public Color getColor(double x, double y){
        Ray d = camera.generateRay(x,y);
        return radiance(d,group,5);
        
    }
}
