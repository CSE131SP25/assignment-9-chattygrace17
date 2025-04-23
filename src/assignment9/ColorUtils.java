package assignment9;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {
	
	public static Color solidColor() {
		Random r = new Random();
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}
	
	private static Color transparent(Color c) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		return new Color(r, g, b, 64);
	}
	
	public static Color transparentColor() {
		return transparent(solidColor());
	}

	// ✅ Added helpers for specific colors
	public static Color getGreen() {
		return new Color(0, 200, 0);
	}

	public static Color getRed() {
		return new Color(200, 0, 0);
	}

	public static Color getBlue() {
		return new Color(0, 0, 200);
	}
}
