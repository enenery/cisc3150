/**
 * cisc3150
 * hw2-q4
 * direction: Figure out why the following two pieces of code produce different outputs.
 * MAKE SURE YOU CITE YOUR SOURCE FOR THE ANSWER TO THIS QUESTION.
 * @author erii sugimoto
 * @since  9/9/2017.
 */
public class TwoOutcomes {

    /**
     * ANSWER:
     * The reason why case 1 seems to shift x by 1 instead of i is because the value in x never changes. I found this myself by printing out the x.
     * The reason why case 1 seems to start its shifting from all over again when i = 32 is
     * because integer is a size of 32 bit so dividing an integer by 2 for greater or
     * equal to 32 times doesn't make sense so java instead directs to dividable numbers such
     * as 32 -> 0, 33 -> 1, 34 -> 2, etc. I found this from here: http://javarevisited.blogspot.com/2013/03/bitwise-and-bitshift-operators-in-java-and-or-xor-left-right-shift-example-tutorial.html
     * In it, it says "If number of shift positions exceeds with number of bits in a variable, then remainder operator is used to calculate effective bit movement.
     * For example int variables contains 32 bit, and if you shift bits to 33 times, then its equivalent of shifting bits 33%32 or just 1 time. e.g. 8 >> 33 is equal to 8 >> 1 and this is true for all bit shift operators.
     * @param args
     */
    public static void main(String args[]){
        int x = 4282;

        //this is to show that shifting an integer by 32 is equivalent to shifting by 0.
        int numTest = 3;
        System.out.printf("%s\t\t%32s","test",Integer.toBinaryString(numTest>>>32));
        System.out.print(" - " + Integer.toBinaryString(numTest) + "\n" + System.lineSeparator());

        //case 1
        for(int i=0;i<35;i++){
            System.out.printf("%d\t\t%32s",i,Integer.toBinaryString(x>>>i));
            //the following print out shows that x value remains as the original, which is 4282
            System.out.print(" - " + Integer.toBinaryString(x) + "\n" + System.lineSeparator());
        }

        System.out.println("");

        //case 2
        for(int i=0;i<35;i++){
            System.out.printf("%d\t\t%32s",i,Integer.toBinaryString(x));
            System.out.print(" - " + Integer.toBinaryString(x) + "\n" + System.lineSeparator());
            x = x >>> i;

        }
    }
}
