/**
cisc3150 - HW9
Direction: Write a program that has 4 separate threads. The threads will have the 
following arrays:

Thread1: A E I M Q U Y
Thread2: B F J N R V Z
Thread3: C G K O S W
ThreadD: D H L P T X

Your goal is to synchronize the threads in such a way that they print out 
all the letters of the alphabet in order.

@author Erii Sugimoto
@since 12/2/2017

wait(): tells the calling thread to give up the monitor and go to sleep
		until some other thread enters the same monitor and calls
		notify() or notifyAll()

notify(): wakes up a thread that called wait() on the same object

notifyAll(): wakes up all the threads that called wait() on the same 
			 object. One of the threads will be granted access.
*/
class Printer {
	int n = 1;
	
	synchronized void print(char c, int num){
		while(n%4 != num)
			try{
				wait();
			}catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.print(c);
		n++;
		notifyAll();
	}	
}

class Thread1 implements Runnable{
	Thread t;
	Printer p;
	char[] a = new char[]{'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
	
	Thread1(Printer p){
		this.p = p;
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		
		for(int i = 0; i < a.length; i++){				
			p.print(a[i], 1);
		}		
	}
}

class Thread2 implements Runnable{
	Thread t;
	Printer p;
	char[] a = new char[]{'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
	
	Thread2(Printer p){
		t = new Thread(this);
		this.p = p;
		t.start();
	}
	
	public void run(){
		
		for(int i = 0; i < a.length; i++){
			p.print(a[i], 2);
		}
			
	}
}

class Thread3 implements Runnable{
	Thread t;
	Printer p;
	char[] a = new char[]{'C', 'G', 'K', 'O', 'S', 'W'};
	
	Thread3(Printer p){
		t = new Thread(this);
		this.p = p;
		t.start();
	}
	
	public void run(){
		
		for(int i = 0; i < a.length; i++){
			p.print(a[i], 3);
		}					
	}
}

class Thread4 implements Runnable{
	Thread t;
	Printer p;
	char[] a = new char[]{'D', 'H', 'L', 'P', 'T', 'X'};
	
	Thread4(Printer p){
		t = new Thread(this);
		this.p = p;
		t.start();
	}
	
	public void run(){
			
		for(int i = 0; i < a.length; i++){
			p.print(a[i], 0);			
		}
	}
}

public class MultiThreading {
	public static void main(String args[]){
		Printer p = new Printer();
		new Thread1(p);
		new Thread2(p);
		new Thread3(p);
		new Thread4(p);

	}
}