package org.example;

public class Circle {
	public int x;
	public int y;
	public int r;

	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public boolean similarTo(Circle oOther, int iThreshold) {
		return Math.abs(oOther.x - x) <= iThreshold && Math.abs(oOther.y - y) <= iThreshold
				&& Math.abs(oOther.r - r) <= iThreshold;
	}
};