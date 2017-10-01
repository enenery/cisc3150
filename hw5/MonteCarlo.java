import java.util.Random;

/**
 * cisc3150
 * hw5
 * direction: Let's say that you draw a square around the top right
     quadrant of a circle. If the circle has a radius r, then the square that
     covers the top right quadrant of the circle will cover an area r^2.

     The area of a circle is Pi*r^2. Given that we're dealing with only the top
     right quadrant, the area will be (Pi*r^2)/4. The ratio of the area of
     the top right quadrant of the circle to the square that covers it would
     be...?

     Generate 4 billion random dots that fall within that square. Figure out
     how many of them fall inside the circle, and how many fall outside of it.
     If you divide the number of dots that fall within the circle by the total
     number of dots (the ones that fell anywhere in the entire square), you
     should get roughly the same ratio as the one you computed above. From
     there, you should be able to calculate the value of PI.

 * @author erii sugimoto
 * @since  10/01/2017.
 */

class MonteCarloThread implements Runnable{
    Thread t;
    long inCircleCount = 0L;
    static double radius;

    public MonteCarloThread(double radius){
            this.radius = radius;
            t = new Thread(this);
            t.start();
        }

    @Override
    public void run() {
        Random random = new Random();
        double x = 0;
        double y = 0;
        for(long i = 0; i < 800000000L; i++){
            x = random.nextDouble()*radius;
            y = random.nextDouble()*radius;
            if(isInCircle(radius, x, y))
                inCircleCount++;
        }
    }

    public boolean isInCircle(double radius, double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= radius;
    }
}

public class MonteCarlo {

    public static void main(String args[]){
        double r = Double.parseDouble(args[0]);
        long totalNumDots = 4000000000L;

        MonteCarloThread t1 = new MonteCarloThread(r);
        MonteCarloThread t2 = new MonteCarloThread(r);
        MonteCarloThread t3 = new MonteCarloThread(r);
        MonteCarloThread t4 = new MonteCarloThread(r);
        MonteCarloThread t5 = new MonteCarloThread(r);

        try {
            t1.t.join();
            t2.t.join();
            t3.t.join();
            t4.t.join();
            t5.t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long totalInCircleDots = t1.inCircleCount + t2.inCircleCount
                                + t3.inCircleCount + t4.inCircleCount
                                + t5.inCircleCount;

        System.out.println("radius: " + r);
        System.out.println("area of a quadrant circle: (pi*r^2)/4");
        System.out.println("area of a square that covers the circle: r^2");
        double areaRatio = (Math.PI*Math.pow(r, 2)/4)/Math.pow(r, 2);
        System.out.println("areaRatio: " + areaRatio);
        System.out.println("total # of dots in quartered circle: " + totalInCircleDots);
        System.out.println("total # of dots in square: " + totalNumDots);
        double ratio = totalInCircleDots/(double)totalNumDots;
        System.out.println("ratio: " + ratio);
        double piValue = ratio*4;
        System.out.println("piValue (ratio*4): " + piValue);

    }
}
