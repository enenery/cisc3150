package child;
import parent.Shape;

public class Circle extends Shape{
	public Circle(){}
	
	public static void main(String args[]){
		printHasShape(); //print hasShape in Shape
		setFalseHasShape(); //set hasShape in Shape to false
		printHasShape(); //print hasShape in Shape
	}

	public static void setFalseHasShape(){
		System.out.println("set hasShape to false");
		hasShape = false;
	}
	public static void printHasShape(){
		System.out.println("hasShape " + hasShape);
	}
}