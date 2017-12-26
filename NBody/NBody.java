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

	public static Planet[] readPlanets(String fileLoc) {
		try {
			Scanner reader = new Scanner(new FileReader(fileLoc));

			int n = reader.nextInt(); 
			reader.nextLine();
			reader.nextLine();

			Planet[] planets = new Planet[n];

			for (int i = 0; i < n; i++) {
				double xP, yP, xV, yV, mass;
				String image;

				xP = reader.nextDouble();
				yP = reader.nextDouble();
				xV = reader.nextDouble();
				yV = reader.nextDouble();
				mass = reader.nextDouble();
				image = reader.nextLine().trim();
				planets[i] = new Planet(xP, yP, xV, yV, mass, image);
			}
			return planets;
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
		}
		Planet[] fail = new Planet[1];
		return fail;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		double T, dt, radius;
		String filename;
		Planet[] planets;

		T = Double.parseDouble(args[0]);
		dt = Double.parseDouble(args[1]);
		filename = args[2].trim();
		radius = readRadius(filename);
		planets = readPlanets(filename);
	}
}
