/**
 * cisc3150
 * hw2-q3
 * direction: Write a program to check whether a string is a palindrome (a string that's
 * the same forward and backwards, for eg, madamimadam)
 * @author erii sugimoto
 * @since  9/9/2017
 */
public class Palindrome {

    public static void main(String args[]){
        System.out.println(palindrome("madamimadam"));
    }

    public static boolean palindrome(String word){
        for(int i = 0; i < word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i))
                return false;
        }
        return true;
    }
}
