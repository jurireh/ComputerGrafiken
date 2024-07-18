
package cgg.a07;

import java.util.concurrent.ExecutionException;

import cgg.*;

public class Main {
     public static void main(String[] args) {
      final long timeStart = System.currentTimeMillis();
   
     Image image = new Image(480, 270);
      //1920, 1080
      //480 270
     // 1280, 720
     // Write the image to disk.
     try {
     image.paralizeSampler(new Raytracer(480, 270));
     }
     catch (InterruptedException e){
      System.out.println("Fehler");
     }
     catch(ExecutionException e){
      System.out.println("Fehler");
     }
    
     // Write the image to disk.
     final String filename = "doc/cgg-competition-ss-22-927377.png";
     image.write(filename);
    System.out.println("Wrote image: " + filename);
    final long timeEnd = System.currentTimeMillis();
    System.out.println("Laufzeit : " +(timeEnd - timeStart));
   }
}
