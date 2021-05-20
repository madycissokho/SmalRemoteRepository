package finalVariable;

public class Demo {
	final int num = 10;// final variable// we can't change this value
	
	public void changeNumber() {
		num = 20;//this will throw an error
		System.out.println("The value of num is " + num);
	}

}
