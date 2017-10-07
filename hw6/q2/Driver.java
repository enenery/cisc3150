public class Driver
{
  public static void main(String args[])
  { 
	//a
    Dog d = new Dog();
	System.out.println("a: " + d.call(3));
	
	//b
	Object c = new Cat();
	System.out.println("b: " + c);
	
	//c
	//Object v = new Pet();
	//System.out.println("c: " + v.call()); -> compile time error (Object class has no call())
	
	//d
	Pet p = new Pet();
	System.out.println("d: " + p);
	
	//e
	Pet q = new Dog();
	System.out.println("e: " + q.call());
	
	//f
	Cat t = new Cat();
	System.out.println("f: " + t.toString("Come here, kitty"));
	
	//g
	//Cat u = new Cat();
	//System.out.println("g: " + u.call(3)); -> compile time error (Cat class has no call(int))
	
	//h
	Dog e = new Dog();
	System.out.println("h: " + e.feet());
	
	//i
	//Pet r = new Dog();
	//System.out.println("i: " + r.call(3)); -> compile time error (Pet class has no call(int))
  }
}