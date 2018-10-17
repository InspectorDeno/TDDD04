

public class SweetenedBeverage extends AbstractCondiment {

	public SweetenedBeverage(Beverage b) {
		beverage = b;
	}
	
	@Override
	public float cost() {
		return 5+beverage.cost();
	}

	@Override
	public String description() {
		return beverage.description()+" with sugar";
	}

}
