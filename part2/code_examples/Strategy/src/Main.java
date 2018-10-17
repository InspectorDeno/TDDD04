public class Main {

	public static void main(String[] args) {
		System.out.println("Hello sim-u-duck!");
		Duck[] ducks = {new MallardDuck(), new RedDuck(), new RubberDuck()};
		for (Duck duck : ducks) {
			duck.swim();
			duck.quack();
			duck.fly();
			duck.flyBehavior = new Flyable() {
				
				@Override
				public void fly() {
					System.out.println("Sorry, too tired");
				}
			};
		}
		for (Duck duck : ducks) {
			duck.fly();
		}
		
	}

}
