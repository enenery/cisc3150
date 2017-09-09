import java.util.Scanner;

/**
 * cisc3150
 * hw2-q5
 * direction: Change Scanner's delimiter, and tokenize comma separated values entered by
 * the keyboard.
 * @author erii sugimoto
 * @since  9/9/2017.
 */
public class CommaSeparated {

    public static void main(String args[]){
        System.out.print("Comma Separated Tokenizer: ");
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        while(scanner.hasNext())
            System.out.println(scanner.next());
        scanner.close();
    }
}
