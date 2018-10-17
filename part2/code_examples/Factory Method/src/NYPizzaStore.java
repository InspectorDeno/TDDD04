

public class NYPizzaStore implements PizzaFranchise {

	@Override
	public Pizza selectPizza(String type) {
		Pizza pizza=null;
		if (type.equals(CHEESE)) {
			pizza = new NYCheesePizza();
		} else if (type.equals(PEPPERONI)) {
			pizza = new NYPepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new NYClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new NYVeggiePizza();
		}
		return pizza;
	}

}
