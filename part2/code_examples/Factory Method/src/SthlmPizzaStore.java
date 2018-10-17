

public class SthlmPizzaStore implements PizzaFranchise {


	@Override
	public Pizza selectPizza(String type) {
		Pizza pizza=null;
		if (type.equals(CHEESE)) {
			pizza = new SthlmCheesePizza();
		} else if (type.equals(PEPPERONI)) {
			pizza = new SthlmPepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new SthlmClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new SthlmVeggiePizza();
		}
		return pizza;
	}

	
}
