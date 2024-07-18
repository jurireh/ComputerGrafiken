package cgg.a04;

import java.util.ArrayList;

public class Group implements Shape{
    protected ArrayList<Shape> list;

    public Group(){
        list = new ArrayList<Shape>();
    }

    public void add(Shape shape){
        list.add(shape);
    }

    public Hit intersect(Ray r){
        Hit hit = null;
        Hit temp = null;
        double t = Double.POSITIVE_INFINITY;
        for(Shape s: list){
            temp = s.intersect(r);
            if(temp != null){
                if(temp.t()<= t){
                  hit= temp;
                  t = temp.t();
                 }
            }   
        }
        if(hit != null){
         return hit;
        }
         return null;
    }
}
