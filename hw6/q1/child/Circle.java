package child;
import parent.Shape;

public class Circle extends Shape{
	public Circle(){
		
	}
	
	public Circle(double a){
		area = a;
	}
	
	public static void main(String args[]){
		Circle c = new Circle(3.0);
		printHasShape(); //print hasShape in Shape
		setFalseHasShape(); //set hasShape in Shape to false
		printHasShape(); //print hasShape in Shape
	}
	
	public void printArea(){
		System.out.println("area is " + area);
	}

	public static void setFalseHasShape(){
		System.out.println("set hasShape to false");
		hasShape = false;
	}
	public static void printHasShape(){
		System.out.println("hasShape " + hasShape);
	}
}