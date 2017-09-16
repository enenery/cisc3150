import java.util.Arrays;

/**
 * cisc3150
 * hw3
 * direction: Create your own version of the String class. Call it MyString. This class
 * should be immutable. Make sure to encapsulate your data properly. Provide
 * an implementation for the following methods:

     public MyString(char[] chars);
     public char charAt(int index);
     public int length();
     public MyString substring(int begin, int end);
     public MyString toLowerCase();
     public MyString toUpperCase();
     public boolean equals(MyString s);
     public MyString getMyString();
     public String toString();
     public static MyString valueOf(int i);

 * Do not use any function from the String class. The only time you're
 * allowed to use the String class is in the toString() method. Even then,
 * you may only use the String's constructor, but not the methods.
 * Make sure to provide a driver class, too, and show the output.
 * @author erii sugimoto
 * @since  9/15/2017.
 */

public class MyString {
    final char[] value;

    public MyString (char[] chars){
        value = chars;
    }

    public char charAt(int index){
        return value[index];
    }

    public int length(){
        return value.length;
    }

    public MyString substring(int begin, int end){
        char[] temp;
        temp = Arrays.copyOfRange(value, begin, end);
        return new MyString(temp);
    }

    public MyString toLowerCase() {
        char[] temp = new char[value.length];

        for(int i = 0; i < value.length; i++)
            temp[i] = Character.toLowerCase(value[i]);

        return new MyString(temp);
    }

    public MyString toUpperCase() {
        char[] temp = new char[value.length];

        for(int i = 0; i < value.length; i++)
            temp[i] = Character.toUpperCase(value[i]);

        return new MyString(temp);
    }

    public boolean equals(MyString s){
        if(value.length != s.value.length)
            return false;
        else{
            for(int i = 0; i < s.value.length; i++){
                if(value[i] != s.value[i])
                    return false;
            }
            return true;
        }
    }

    public MyString getMyString() {
        return new MyString(value);
    }

    public String toString(){
        return new String(value);
    }

    public static MyString valueOf(int i){
        int numOfDigit = 0;
        int num = i;
        while(num > 0) {
            num/=10;
            numOfDigit++;
        }

        char[] temp = new char[numOfDigit];
        num = i;
        for(int j = 0; j < temp.length; j++){
            numOfDigit--;
            temp[j] = (char) (((num/ (int) Math.pow(10, numOfDigit)) + 48));
            num = num - (int) Math.pow(10, numOfDigit) * (temp[j] - 48);
        }

        return new MyString(temp);
    }
}

class Test {
    public static void main(String args[]){
        char[] data1 = {'M', 'y', 'S', 't', 'R', 'i', 'N', 'g'};
        char[] data2 = {'m', 'y', 's', 'p', 'r', 'i', 'n', 'g'};
        char[] data3 = {'M', 'y', 'S', 't', 'R', 'i', 'N', 'g'};

        MyString string1 = new MyString(data1);
        MyString string2 = new MyString(data2);
        MyString string3 = new MyString(data3);

        System.out.println("string1 = " + string1 + System.lineSeparator());
        System.out.println("string2 = " + string2 + System.lineSeparator());
        System.out.println("string3 = " + string3 + System.lineSeparator());

        System.out.println("string1.charAt(6) -> " + string1.charAt(6) + System.lineSeparator());
        System.out.println("string1.length() -> " + string1.length() + System.lineSeparator());
        System.out.println("string1.substring(2, 5) -> " + string1.substring(2, 5) + System.lineSeparator());
        System.out.println("string1.toLowerCase() -> " + string1.toLowerCase() + System.lineSeparator());
        System.out.println("string1.toUpperCase() -> " + string1.toUpperCase() + System.lineSeparator());
        System.out.println("string1.equals(string2) -> " + string1.equals(string2) + System.lineSeparator());
        System.out.println("string1.equals(string3) -> " + string1.equals(string3) + System.lineSeparator());
        System.out.println("string1.getMyString() -> " + string1.getMyString() + System.lineSeparator());
        System.out.println("string1.toString() -> " + string1.toString() + System.lineSeparator());
        System.out.println("MyString.valueOf(9162017) -> " + MyString.valueOf(9162017));
    }
}