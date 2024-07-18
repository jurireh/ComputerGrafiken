/** @author henrik.tramberend@beuth-hochschule.de */
package cgg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cgg.a07.OnePixel;
import cgtools.*;

public class Image {
  protected int width;
  protected int height;
  protected double[] array;

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    this.array = new double[width*height* 3];
  }

  public void setPixel(int x, int y, Color color) {
    array[(y*width+x)*3] = Math.pow(color.r(),(1/2.2));
    array[(y*width+x)*3 + 1] =Math.pow(color.g(),(1/2.2));
    array[(y*width+x)*3 + 2] = Math.pow(color.b(),(1/2.2));
  }

  public void write(String filename) {
    ImageWriter.write(filename, array, width, height);
  }

  public void sample(Sampler s) {
    int n = 10;
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        double r = 0;
        double g = 0;
        double b = 0;
        for(int xi = 0;xi <n; xi++){
          for(int yi = 0;yi<n;yi++){
            double rx = Random.random();
            double ry = Random.random();
            double xs = x +(xi+rx)/n;
            double ys = y+(yi+ry)/n;
            Color color = s.getColor(xs, ys);
            r += color.r();
            g += color.g();
            b +=color.b();
          }
        }
        setPixel(x, y,new Color(r/(n*n),g/(n*n),b/(n*n)));
      }
    }
  }

  public void paralizeSampler(Sampler s) throws InterruptedException, ExecutionException{
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService pool = Executors.newFixedThreadPool(cores);
    List<Future<Color>> pixels = new ArrayList<>();
    for(int x = 0;x !=width;x++){
      for(int y = 0;y != height; y++){
        pixels.add(pool.submit(new OnePixel(s,x,y)));
      }
    }
   
    for(int x = 0;x != width;x++){
      for(int y = 0;y != height; y++){
      // Future<Color> color = pixels.remove(0);
       Color color = pixels.get(x * height +y).get();
       setPixel(x,y,color);
      }
    }
    pool.shutdown();
    }

}
