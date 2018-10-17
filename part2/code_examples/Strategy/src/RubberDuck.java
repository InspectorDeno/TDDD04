public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new NoFlySir(this);
	}

	@Override
	protected String describe() {
		return "Rubber Duck";
	}

}
