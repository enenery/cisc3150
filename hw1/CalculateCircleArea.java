import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cisc3150
 * hw1-q2
 * direction: In a loop, read radiuses from a user. Calculate the area of a circle using
 * the formula PI*r^2. Use the pow function, and the PI constant in the Math
 * class. Pick your data types wisely. Exit when the user presses ^d. Show
 * your output.
 * @author erii sugimoto
 * @since 9/1/2017
 */
public class CalculateCircleArea{

    public static double calculateCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String args[])  throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("q2-output.txt");
        System.out.print("Enter some value for radius (press ctrl + d to finish): ");
        while(scanner.hasNext()){
            double radius = scanner.nextDouble();
            double area = calculateCircleArea(radius);
            System.out.println(area);
            fileWriter.write("Radius: " + radius + " -> Area: "
                    + Double.toString(area) + System.lineSeparator());
            System.out.print("Enter some value for radius (press ctrl + d to finish): ");
        }
        fileWriter.close();
    }
}
