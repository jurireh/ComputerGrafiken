package cgg.a07;

import cgtools.*;
import static cgtools.Vector.*;
import java.util.ArrayList;
import cgg.*;



public class Raytracer implements Sampler {
    protected double width;
    protected double height;
    protected Camera camera;
    protected Group group;
    protected Group mensch;
    protected Group mensch22;

    public Raytracer(double width, double height){
        this.width = width;
        this.height = height;
        group = new Group();
        mensch = new Group(new Transform(Matrix.translation(point(0, 0.4,0))));
        mensch22 = new Group(new Transform(Matrix.translation(point(0, 0.4,0))));

        ArrayList<Matrix> ma = new ArrayList<Matrix>();
        //  ma.add(Matrix.rotation(new Direction(1,0,0),-90));
        //  ma.add(Matrix.invert(Matrix.translation(0,-2,-2)));
         

        camera = new Camera( Math.PI / 3, width,height,ma);
        Shape background = new Background(new Backmaterial(new Texture("file/BlueSky.jpg")));
         Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), new perfectDiffus(new Constant(gray)),Double.POSITIVE_INFINITY);
        // Shape spiegel1 = new Kugel(point(0.6,0,-2.8),0.3,new Glass(1,1.5,white));
        // group.add(spiegel1);
        group.add(background);
        group.add(ground);
        mensch.add(new Kugel(point(0,0,-2.9),0.2,new perfectDiffus(new Texture("file/Gesicht11.jpg"))));
        // mensch.add(new Kugel(point(-0.07,0.02,-2.72),0.04,new perfectDiffus(new Constant(white))));
        // mensch.add(new Kugel(point(0.07,0.02,-2.72),0.04,new perfectDiffus(new Constant(white))));
       // mensch.add(new Kugel(point(0,0.06,-2.9),0.19,new perfectDiffus(new Constant(new  Color(0.18,0.31,0.31)))));
        mensch.add(new Cylinder(point(0,-0.2,-3),0.2,-0.3,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch.add(new Cylinder(point(0.2,-0.2,-3),0.06,-0.2,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch.add(new Cylinder(point(-0.2,-0.2,-3),0.06,-0.2,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch.add(new Cylinder(point(0.1,-0.4,-3),0.06,-0.4,0.1,new perfectDiffus(new Constant(black))));
        mensch.add(new Cylinder(point(-0.1,-0.4,-3),0.06,-0.4,0.1,new perfectDiffus(new Constant(black))));

        mensch22.add(new Kugel(point(0,0,-2.9),0.2,new perfectDiffus(new Texture("file/Gesicht2.jpg"))));
        mensch22.add(new Cylinder(point(0,-0.2,-3),0.2,-0.3,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch22.add(new Cylinder(point(0.2,-0.2,-3),0.06,-0.2,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch22.add(new Cylinder(point(-0.2,-0.2,-3),0.06,-0.2,0.1,new perfectDiffus(new Constant(new Color(0.55,0.14,0.1)))));
        mensch22.add(new Cylinder(point(0.1,-0.4,-3),0.06,-0.4,0.1,new perfectDiffus(new Constant(black))));
        mensch22.add(new Cylinder(point(-0.1,-0.4,-3),0.06,-0.4,0.1,new perfectDiffus(new Constant(black))));
        group.add(mensch);
        Group baum = new Group();
        baum.add(new Cylinder(point(0, 0, -2),0.1,-0.4,0.1,new perfectDiffus(new Constant(new Color(0.35, 0.22, 0.16)))));
        baum.add(new Kugel(point(0, 0.2, -2),0.3, new perfectDiffus(new Texture("file/baum.jpg"))));

        Kugel glass = new Kugel(point(0, 1.5, -5), 1, new Mirror(white, 0));

        Group mensch2 = new Group(new Transform(Matrix.translation(point(-1, -0.1,0.5))));
        Group mensch3 = new Group(new Transform(Matrix.translation(point(1, -0.1,0.5))));
        Group mensch4 = new Group(new Transform(Matrix.translation(point(0.5, -0.1,-1))));
        Group mensch5 = new Group(new Transform(Matrix.translation(point(-0.5, -0.1,-1))));
        Group mensch6 = new Group(new Transform(Matrix.translation(point(-1.7, -0.1,-1.5))));
        Group mensch7 = new Group(new Transform(Matrix.translation(point(1.6, -0.1,-1.3))));

        Group baum1 = new Group(new Transform(Matrix.translation(point(1.6, 0.1,-2.5))));
        Group baum2 = new Group(new Transform(Matrix.translation(point(1, 0.1,-2.5))));
        Group baum3 = new Group(new Transform(Matrix.translation(point(0.5, 0.1,-2.5))));
        Group baum4 = new Group(new Transform(Matrix.translation(point(-0.3, 0.1,-2.5))));
        Group baum5 = new Group(new Transform(Matrix.translation(point(0, 0.1,-2.5))));
        Group baum6 = new Group(new Transform(Matrix.translation(point(-1.2, 0.1,-2.5))));
        
        mensch7.add(mensch);
        mensch6.add(mensch);
        mensch2.add(mensch);
        mensch3.add(mensch22);
        mensch4.add(mensch2);
        mensch5.add(mensch22);
        baum1.add(baum);
        baum2.add(baum);
        baum3.add(baum);
        baum4.add(baum);
        baum5.add(baum);
        baum6.add(baum);
        

        group.add(mensch2);
        group.add(mensch3);
        group.add(mensch4);
        group.add(mensch5);
        group.add(mensch6);
        group.add(mensch7);
        group.add(baum1);
        group.add(baum2);
        group.add(baum3);
        group.add(baum4);
        group.add(baum5);
        group.add(baum6);
        group.add(glass);
       // group.add(new Kugel(point(0,0,-2.9),0.2,new perfectDiffus(new Texture("file/Gesicht1.jpg"))));
         
        
           
    

    }

    public Color radiance(Ray ray, Group scene, int depth){
        if(depth == 0){
            return black;
        }
        Hit hit = scene.intersect(ray);
        Ray b = hit.material().reflectedRay(ray, hit);
        if(b != null){
            return  add(multiply(hit.material().albedo(ray, hit), radiance(b, scene, depth-1)),hit.material().emmission(ray, hit));
           
        }
        else 
        return hit.material().emmission(ray, hit);
    }
    
    public Color getColor(double x, double y){
        Ray d = camera.generateRay(x,y);
        return radiance(d,group,10);
        
    }
}
