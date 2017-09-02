import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * cisc3150
 * hw1-q3
 * direction: Write a program that randomly generates an integer between 1 & 12, and
 * displays the English name of that month. Run the program & show the
 * output.
 * @author erii sugimoto
 * @since 09/01/2017
 */

public class GetMonth {

    public static String getMonth(int num){
        String month = "";

        switch (num){
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                System.out.print("Input Error: input must be within 1 and 12");
                break;
        }
        return month;
    }

    public static void main(String args[]) throws IOException{
        FileWriter fileWriter = new FileWriter("q3-output.txt");
        for(int i = 0; i < 30; i++){
            Random random = new Random();
            int randomNum = random.nextInt(12) + 1;
            System.out.println(Integer.toString(randomNum) + " -> " + getMonth(randomNum));
            fileWriter.write(Integer.toString(randomNum) + " -> " + getMonth(randomNum) + System.lineSeparator());
        }
        fileWriter.close();
    }

}
