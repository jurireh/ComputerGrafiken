package cgg.a07;

import java.util.ArrayList;

import cgtools.Matrix;

public class Group implements Shape{
    protected ArrayList<Shape> list;
    protected Transform t;

    public Group(){
        list = new ArrayList<Shape>();
        this.t = new Transform(Matrix.identity);
    }

    public Group(Transform t){
        list = new ArrayList<Shape>();
        this.t = t;
    }

    public void add(Shape shape){
        list.add(shape);
    }

    public Hit intersect(Ray r){
        r = t.transform(r);
        Hit hit = null;
        Hit temp = null;
        double ti = Double.POSITIVE_INFINITY;
        for(Shape s: list){
            temp = s.intersect(r);
            if(temp != null){
                if(temp.t()<= ti){
                  hit= temp;
                  ti = temp.t();
                 }
            }   
        }
    
        if(hit != null){
         return t.transform(hit); 
        }
         return null;
    }
}
