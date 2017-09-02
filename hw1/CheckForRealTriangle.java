import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cisc3150
 * hw1-q5
 * Write a program that reads three 2D points A, B, and C from the user.
 * Next, calculate the length of each side of the triangle using the
 * distance formula: sqrt((x2-x1)^2+(y2-y1)^2). Finally, determine if it's a
 * real triangle. For a triangle to be real, the sum of any two sides needs
 * to be greater than the third. Make sure your output has some real and at
 * least one fake triangle.
 * @author erii sugimoto
 * @since 9/1/2017
 */
public class CheckForRealTriangle {

    public static void main(String args[]) throws IOException {
        double x1, y1, x2, y2, x3, y3;
        double dist1, dist2, dist3;
        boolean real = false;

        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("q5-output.txt");
        System.out.print("Enter the x value for the first point (press ctrl + d to finish): ");
        while (scanner.hasNext()) {
            x1 = scanner.nextDouble();
            System.out.print("Enter the y value for the first point: ");
            y1 = scanner.nextDouble();
            System.out.print("Enter the x value for the second point: ");
            x2 = scanner.nextDouble();
            System.out.print("Enter the y value for the second point: ");
            y2 = scanner.nextDouble();
            System.out.print("Enter the x value for the third point: ");
            x3 = scanner.nextDouble();
            System.out.print("Enter the y value for the third point: ");
            y3 = scanner.nextDouble();

            dist1 = Math.abs(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
            dist2 = Math.abs(Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)));
            dist3 = Math.abs(Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2)));

            fileWriter.write("Points: (" + x1 + ", " + y1 + "), " + "(" + x2 + ", " + y2 + "), "
                    + "(" + x3 + ", " + y3 + ")" + System.lineSeparator());

            if (dist1 < (dist2 + dist3)) {
                if (dist2 < (dist3 + dist1)) {
                    if (dist3 < (dist1 + dist2)) {
                        System.out.println("You have a real triangle.");
                        fileWriter.write(" -> You have a real triangle." + System.lineSeparator());
                        real = true;
                    }
                }
            }

            if (!real) {
                System.out.println("You don't have a real triangle.");
                fileWriter.write("-> You don't have a real triangle." + System.lineSeparator());
            }

            real = false;
            System.out.print("\nEnter the x value for the first point (press ctrl + d to finish): ");
        }

        fileWriter.close();
    }
}
