package advanced.wiring;

public class HelloProd implements SayHello {
	private String profileName = "Production";

	@Override
	public void sayHello() {
		System.out.println("Hello, " + profileName);
	}

}
