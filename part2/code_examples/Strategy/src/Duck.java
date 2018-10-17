public class Duck {

	public Flyable flyBehavior;

	public void swim() {
		System.out.println(describe() + " is swimming!");
	}

	public void quack() {
		System.out.println(describe() + " is quacking");
	}

	protected String describe() {

		return "duck";
	}

	public void fly() {
		flyBehavior.fly();
	}

}
