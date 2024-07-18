package cgg.a04;

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
        Shape background = new Background(new Color(0,0,1));
        Shape globe1 = new Kugel(new Point(-1.0, -0.25, -2.5),0.7, new Color(1,1,0));
        Shape globe2 = new Kugel(point(0.0, -0.25, -2.5), 0.5, new Color(1,0,0));
        Shape globe3 = new Kugel(point(1.0, -0.25, -2.5), 0.7, green);
        Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), gray,100);
        group.add(background);
        group.add(globe1);
        group.add(globe2);
        group.add(globe3);
        group.add(ground);
        //Bild2
        Shape back = new  Background(new Color(0,0,0.5));
        Shape gessicht = new Kugel(new Point(0,0,-3),0.7, new Color(1,1,0));
        Shape auge1 = new Kugel(new Point(-0.25,0.17,-2),0.1, new Color(1,1,1));
        Shape auge2 = new Kugel(new Point(0.25,0.17,-2),0.1, new Color(1,1,1));
        Shape pupille = new Kugel(new Point(-0.25,0.17,-1.9),0.05, new Color(0,0,1));
        Shape pupille2 = new Kugel(new Point(0.25,0.17,-1.9),0.05, new Color(0,0,1));
        Shape mund = new Kugel(new Point(0,-0.2,-1.9),0.2, new Color(1,0,0));
        Shape mund2 = new Kugel(new Point(0,-0.07,-1.8),0.2, new Color(1,1,0));
        Shape ohr1 = new Kugel(new Point(0.6,0,-3.1),0.4, new Color(1,1,0));
        Shape ohr2 = new Kugel(new Point(-0.6,0,-3.1),0.4, new Color(1,1,0));
        Shape haar1 = new Kugel(new Point(0.1,0.4,-1.7),0.15, new Color(0.7,0.3,0));
        Shape haar2 = new Kugel(new Point(-0.12,0.37,-1.7),0.15, new Color(0.7,0.3,0));
        group2.add(gessicht);
        group2.add(auge1);
        group2.add(auge2);
        group2.add(pupille);
        group2.add(pupille2);
        group2.add(mund);
        group2.add(mund2);
        group2.add(ohr1);
        group2.add(ohr2);
        group2.add(haar1);
        group2.add(haar2);
        group2.add(back);
    }

    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1, 1, 0.5));
        Color ambient = multiply(0.1, color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)), color);
        return add(ambient, diffuse);
    }
    
    public Color getColor(double x, double y){
        Ray d = camera.generateRay(x,y);
        Hit hit = group2.intersect(d);
        if(hit != null){
         return shade(hit.n(), hit.c());
        }
        return black; 
    }
}
