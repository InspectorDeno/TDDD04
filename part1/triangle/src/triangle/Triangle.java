package triangle;


public class Triangle {

	public enum TriangleType {
		Isosceles, Equilateral, Scalene, NaT;

		public String toString() {
			return name();
		};
	}

	private int[] sides;
	
	public TriangleType getType() throws InvalidTriangleException
	{
		TriangleType result = TriangleType.NaT;

		if (sides.length != 3) {
			throw new InvalidTriangleException();
		}
		
		if (sides[0] > sides[1])
			swap(sides, 0, 1);

		if (sides[0] > sides[2])
			swap(sides, 0, 2);

		if (sides[1] > sides[2])
			swap(sides, 1, 2);
		
		if (sides[0] <= 0 || sides[2] - sides[0] >= sides[1]) {
			throw new InvalidTriangleException();
		}

		if (sides[0] == sides[2]) {
			result = TriangleType.Equilateral;
		} else if (sides[0] == sides[1] || sides[1] == sides[2]) {
			result = TriangleType.Isosceles;
		} else {
			result = TriangleType.Scalene;
		}

		return result;
	}

	private static void swap(int s[], int i, int j) {
		int tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}

	public int[] getSides() {
		return sides;
	}

	public void setSides(int[] sides) {
		this.sides = sides;
	}

}
