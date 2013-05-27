package math;

public class Vector2D {
	
	double x;
	double y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public void addToX(double increment) {
		this.x += increment;
	}
	
	public void addToY(double increment) {
		this.y += increment;
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
}
