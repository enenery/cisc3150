import java.util.Scanner;

/**
 * cisc3150
 * hw2-q1
 * direction: Write a program that asks the user how tall of a pyramid do they want to
 * display on the screen, and then displays the pyramid that counts up on the
 * left, and counts down on the right.
 * Note: Use System.out.printf
 * @author erii sugimoto
 * @since 9/9/2017.
 */
public class PyramidPrintf {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of a pyramid in integer: ");
        int height = scanner.nextInt();
        printPyramid(height);
    }

    public static void printPyramid(int height) {
        String output;
        int numSpace;

        for(int row = 0; row < height; row++) {
            output = getOutput(row+1);
            numSpace = ((2*height-1) - output.length())/2;
            if(numSpace > 0)
                System.out.printf("%" + numSpace + "c" + "%s" + "%" + numSpace + "c\n", ' ', output, ' ');
            else
                System.out.print(output);
        }
    }

    /**
     * returns the string of number for display
     * @param level - level of a pyramid
     * @return a string of number to be printed on the screen
     */
    public static String getOutput(int level){
        String output = "";
        if(level == 1)
            return Integer.toString(1);
        else{
            int count = 1;
            int num = 1;
            boolean left = true;

            while(count < 2*level) {

                output += num;

                if (num == level)
                    left = false;

                if (left)
                    num++;
                else
                    num--;

                count++;
            }
        }

        return output;
    }
}
