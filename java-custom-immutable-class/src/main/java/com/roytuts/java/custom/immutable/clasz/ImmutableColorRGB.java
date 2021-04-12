package com.roytuts.java.custom.immutable.clasz;

public final class ImmutableColorRGB {

	private final int red;
	private final int green;
	private final int blue;
	private final String name;

	public ImmutableColorRGB(int red, int green, int blue, String name) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}

	public int getRGB() {
		return ((red << 16) | (green << 8) | blue);
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		ImmutableColorRGB color = new ImmutableColorRGB(0, 0, 0, "Black");

		System.out.println("Black color ref: " + color);

		color = new ImmutableColorRGB(220, 20, 60, "Crimson");

		System.out.println("Crimson color ref: " + color);

		int myColorValue = color.getRGB(); // Statement 1
		String myColorName = color.getName(); // Statement 2

		System.out.println("myColorValue: " + myColorValue + ", myColorName: " + myColorName);
	}

}
