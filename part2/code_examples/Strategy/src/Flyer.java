
final class Flyer implements Flyable {
	/**
	 * 
	 */
	private final Duck duck;

	/**
	 * @param duck
	 */
	Flyer(Duck duck) {
		this.duck = duck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Flyable#fly()
	 */
	@Override
	public void fly() {
		System.out.println(duck.describe() + " is flying");
	}
}