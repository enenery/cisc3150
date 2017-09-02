import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * cisc3150
 * hw1-q4
 * direction: Feed a file that contains numbers into your program using command line
 * redirection. Have your program read & print the file on the screen.
 * @author erii sugimoto
 * @since 09/01/2017
 */
public class ReadAFile {

    public static void main(String args[]) throws FileNotFoundException{
        if(args.length != 1){
            System.out.println("ReadAFile.java requires exactly one argument, a file name.");
            return;
        }
        //Scanner scanner = new Scanner(System.in);
        Path input = Paths.get(args[0]);
        FileReader fileReader = new FileReader(input.toString());
        Scanner scanner = new Scanner(fileReader);

            while(scanner.hasNext())
                System.out.print((scanner.next()) + " ");
    }
}
