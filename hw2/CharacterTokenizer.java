import java.util.Scanner;

/**
 * cisc3150
 * hw2-q6
 * direction: Your job is to tokenize individual characters.
 * @author erii sugimoto
 * @since  9/9/2017.
 */
public class CharacterTokenizer {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        in.useDelimiter("");

        while(in.hasNext()){
            System.out.println(in.next());
        }
    }
}
