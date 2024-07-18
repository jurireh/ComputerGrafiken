package cgg.a07;

import java.util.concurrent.Callable;

import cgtools.*;

public record OnePixel(Sampler s, int x, int y) implements Callable<Color> {
    public Color call(){
        int n = 10;
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
        return new Color(r/(n*n),g/(n*n),b/(n*n));
      }
}
