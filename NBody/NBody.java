import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class NBody {

	public static double readRadius(String fileLoc) {
		BigDecimal radius;
		try {
			Scanner reader = new Scanner(new FileReader(fileLoc));
			reader.nextLine();
			radius = new BigDecimal(reader.nextLine());
			return radius.doubleValue();
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
		}
		return 0;
	}

	public static void readPlanets(String fileLoc) {
		try {
			Scanner reader = new Scanner(new FileReader(fileLoc));

			int n = reader.nextInt(); reader.nextLine();
			Planet[] planets = new Planet[n];

			for (int i = 0; i < n; i++) {
				double xP, yP, xV, yV, mass;
				String image;

				xP = reader.nextDouble();
				yP = reader.nextDouble();
				xV = reader.nextDouble();
				yV = reader.
			} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
		}
	}

	public static void main(String[] args) {

		System.out.println(readRadius("data/planets.txt"));
		readPlanets("data/planets.txt");
	}

}
