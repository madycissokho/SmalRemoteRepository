package finalMethod;

public class B extends A{
	public void example() {//compilation error because this method is a final
		                  //method. cannot overridden
		System.out.println("B Class Method");
	}

}
