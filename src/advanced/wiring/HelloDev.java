package advanced.wiring;

public class HelloDev implements SayHello {
	private String profileName = "Dev";

	@Override
	public void sayHello() {
		System.out.println("Hello, " + profileName);
	}

}
