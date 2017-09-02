import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cisc3150
 * hw1-q6
 * direction: Write a program that prompts the user to enter the center coordinates and
 * radiuses of two circles. Determine whether the circles are separate from
 * each other, touching each other, overlapping each other, or completely
 * within one another. Test each case and show the output.
 * disclaimer: I got help figuring out the calculation from the website
 * http://www.bbc.co.uk/education/guides/z9pssbk/revision
 * @author erii sugimoto
 * @since 9/1/2017.
 */
public class TwoCircles {

    public static boolean touch(double dist, double radius1, double radius2){
        if(dist == (radius1 + radius2) || dist == Math.abs(radius1 - radius2))
            return true;
        else
            return false;
    }

    public static boolean overlap(double dist, double radius1, double radius2){
        if(dist < (radius1 + radius2) && dist > Math.abs(radius1 - radius2))
            return true;
        else
            return false;
    }

    public static boolean inside(double dist, double radius1, double radius2){
        if(radius1 < radius2 && dist < radius1)
            return true;

        if(radius2 < radius1 && dist < radius2)
            return true;

        return false;
    }

    public static void main(String args[]) throws IOException {
        double x1, y1, x2, y2;
        double radius1, radius2;
        double dist;
        int separate = 0;

        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("q6-output.txt");
        System.out.print("Enter the x value for the center of the first circle (Press ctrl + d to finish): ");
        while (scanner.hasNext()) {
            x1 = scanner.nextDouble();
            System.out.print("Enter the y value for the center of the first circle: ");
            y1 = scanner.nextDouble();
            System.out.print("Enter the x value for the center of the second circle: ");
            x2 = scanner.nextDouble();
            System.out.print("Enter the y value for the center of the second circle: ");
            y2 = scanner.nextDouble();

            System.out.print("Enter the radius for the first circle: ");
            radius1 = scanner.nextDouble();
            System.out.print("Enter the radius for the second circle: ");
            radius2 = scanner.nextDouble();

            dist = Math.abs(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));

            fileWriter.write("Centers of two circles: (" + x1 + ", " + y1 + "), "
            + "(" + x2 + ", " + y2 + ")"  + System.lineSeparator() + "radius1: " + radius1 + ", radius2: " + radius2
            + System.lineSeparator());

            if(touch(dist, radius1, radius2)) {
                System.out.println("Do your two circles touch? --- YES.");
                separate++;
                fileWriter.write("[touch? --- YES.] " + System.lineSeparator());
            }
            else {
                System.out.println("Do your two circles touch? --- NO.");
                fileWriter.write("[touch? --- NO.] " + System.lineSeparator());
            }

            if(overlap(dist, radius1, radius2)) {
                System.out.println("Do your two circles overlap? --- YES.");
                separate++;
                fileWriter.write("[overlap? --- YES.] " + System.lineSeparator());
            }
            else {
                System.out.println("Do your two circles overlap? --- NO.");
                fileWriter.write("[overlap? --- NO.] " + System.lineSeparator());
            }

            if(inside(dist, radius1, radius2)) {
                System.out.println("Does one of your circles fit completely inside the other one? --- YES.");
                separate++;
                fileWriter.write("[inside? --- YES.]" + System.lineSeparator());
            }
            else {
                System.out.println("Does one of your circles fit completely inside the other one? --- NO.");
                fileWriter.write("[inside? --- NO.]" + System.lineSeparator());
            }

            if(separate == 0) {
                System.out.println("Your circles are separate from each other.");
                fileWriter.write(" ~ circles are separate from each other. ~" + System.lineSeparator());
            }

            fileWriter.write(System.lineSeparator());
            separate = 0;
            System.out.print("\nEnter the x value for the center of the first circle (Press ctrl + d to finish): ");
        }

        fileWriter.close();
    }
}
