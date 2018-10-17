public class RedDuck extends Duck {

	public RedDuck() {
		flyBehavior = new NoFlySir(this);
	}

	@Override
	protected String describe() {
		return "Red Duck";
	}
}
