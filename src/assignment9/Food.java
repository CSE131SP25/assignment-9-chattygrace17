package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		relocate();
	}

	/**
	 * Randomly places the food within the unit square
	 */
	public void relocate() {
		Random rand = new Random();
		x = rand.nextDouble(); // Range: 0.0 to 1.0
		y = rand.nextDouble();
	}

	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(ColorUtils.getRed());
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
