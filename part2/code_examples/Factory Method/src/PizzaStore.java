

public class PizzaStore {


	public static void main(String[] args) {
		Pizza pizza = orderPizza("veggie");
		System.out.println("Woohoo, I got a "+pizza.describe());
	}

	public static Pizza orderPizza(String type) {
		PizzaFranchise pizzaStore = new NYPizzaStore();
		Pizza pizza = pizzaStore.selectPizza(type);
        pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}



	
	
}
