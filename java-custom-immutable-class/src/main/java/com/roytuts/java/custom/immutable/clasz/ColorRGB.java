package com.roytuts.java.custom.immutable.clasz;

public class ColorRGB {

	private int red;
	private int green;
	private int blue;
	private String name;

	public ColorRGB(int red, int green, int blue, String name) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}

	public void set(int red, int green, int blue, String name) {
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
		ColorRGB color = new ColorRGB(0, 0, 0, "Black");

		System.out.println("Black color ref: " + color);

		color.set(220, 20, 60, "Crimson"); // Change state of object

		System.out.println("Crimson color ref: " + color);

		int myColorValue = color.getRGB(); // Statement 1
		String myColorName = color.getName(); // Statement 2

		System.out.println("myColorValue: " + myColorValue + ", myColorName: " + myColorName);
	}

}
