/**

Question 2 
If I remember correctly, ObjectOutputStream is supposed to ignore 
transient and static vatiables. We verified that the transient values 
weren't written out to the file in our demonstration, but I couldn't 
get the static variable to behave properly. Figure out what the correct 
behavior is supposed to be for static vatiables, and then write a 
demonstration program that shows that behavior.

output of this file is in q2-output-final.txt
*/

import java.io.*;

public class q2Input implements Serializable{
	
	public static void main(String args[]) throws Exception{
		q2Output tmpQ2 = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("q2-output.txt"));
		tmpQ2 = (q2Output)ois.readObject();
		ois.close();
		System.out.println(tmpQ2.year);
		System.out.println(tmpQ2.month);
		System.out.println(tmpQ2.day);
	}
}		