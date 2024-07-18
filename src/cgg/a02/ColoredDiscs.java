package cgg.a02;

import java.util.ArrayList;

import cgtools.*;

public class ColoredDiscs implements Sampler {

    protected ArrayList<Disc> list;

    public ColoredDiscs(int anzahl){
    list = new ArrayList<Disc>();
   // Vector.hsvToRgb(new Color (Math.random(),1,1))
  // new Color(Math.random(), Math.random(), Math.random())
   
    for(int i = 1;i<= anzahl;i++){
      // list.add(new Disc( 480 * Math.random(), 270 * Math.random(),50 * Math.random(),Vector.hsvToRgb(new Color (18 *Math.random(),Math.random(),Math.pow(Math.random(), 1/2.2)))));
    list.add(new Disc( 480 * Math.random(), 270 * Math.random(),50 * Math.random(),new Color (Math.random(),Math.random(),Math.random())));
    } 
 }

    public  Disc smallest(ArrayList<Disc> list2){
        double smallestradius = 0;
        int index = 0;
        for(int i = 0;i< list2.size(); i++){
            if(list2.get(i).radius()< smallestradius){
                smallestradius = list2.get(i).radius();
                index = i;
            }
        }
        return list2.get(index);
    }



    @Override
    public Color getColor(double x, double y) {
        Color schwarz = new Color(0, 0, 0);
        ArrayList<Disc> list2 = new ArrayList<Disc>();
        boolean kreis = false;
        for(Disc scheibe:list){
            if(scheibe.isPointInDisc(x, y) == true){
                list2.add(scheibe);
                kreis = true;
            }
        }

        if(kreis == true){
        return smallest(list2).color();
        }
        else
            return schwarz;
    }
}
