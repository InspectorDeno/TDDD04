
final class NoFlySir implements Flyable {
	/**
	 * 
	 */
	private final Duck duck;

	/**
	 * @param duck
	 */
	NoFlySir(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void fly() {
		System.out.println(duck.describe() + " says: sorry, no can do");
	}
}