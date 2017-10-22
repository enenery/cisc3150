import java.io.*;
/**

Question 2 
If I remember correctly, ObjectOutputStream is supposed to ignore 
transient and static vatiables. We verified that the transient values 
weren't written out to the file in our demonstration, but I couldn't 
get the static variable to behave properly. Figure out what the correct 
behavior is supposed to be for static vatiables, and then write a 
demonstration program that shows that behavior.
*/
public class q2Output implements Serializable{
	static int year;
	int month;
	transient int day;
	public q2Output(){}
	
	public static void main(String args[]) throws Exception{
		q2Output myQ2 = new q2Output();
		myQ2.year = 2017;
		myQ2.month	= 10;
		myQ2.day = 22;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("q2-output.txt"));
		oos.writeObject(myQ2);
		oos.close();
	}
}