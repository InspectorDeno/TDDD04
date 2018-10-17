public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new Flyer(this);
	}

	@Override
	protected String describe() {
		return "Mallard Duck";
	}
}
