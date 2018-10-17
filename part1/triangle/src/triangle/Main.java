package triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws InvalidTriangleException {
		System.out.print("Enter the triangle side lengths: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final Triangle triangle = new Triangle();
		try {
			final String readLine = br.readLine();
			System.out.println(readLine);
			final String[] split = readLine.split("\\s+");
			int[] intSides = new int[split.length];
			int i = 0;
			
			for (String string : split) {
				intSides[i++] = Integer.parseInt(string);
			}
			
			triangle.setSides(intSides);
			System.out.println(triangle.getType());
		} catch (InvalidTriangleException e) {
			System.err.println("invalid triangle");
		} catch (IOException e) {
			System.err.println("could not read from stdin");
		}
		catch (NumberFormatException n) {
			System.err.println("invalid input");
		}
	}

}
