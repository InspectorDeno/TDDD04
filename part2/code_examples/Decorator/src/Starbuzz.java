

import java.text.MessageFormat;

public class Starbuzz {
	public static void main(String[] args) {
		System.out.println("Hello customer, welcome!");
		Beverage b = new Coffee();
		b = new SweetenedBeverage(new SweetenedBeverage(b));
		System.out.println(MessageFormat.format("That''s {0} for the {1}", b.cost(), b.description()));
		
	}
}
