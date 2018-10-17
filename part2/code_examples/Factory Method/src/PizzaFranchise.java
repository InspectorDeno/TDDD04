
public interface PizzaFranchise {

	public static final String CHEESE = "cheese";
	static final String PEPPERONI = "pepperoni";

	abstract Pizza selectPizza(String type);

}