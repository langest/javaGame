package math;

public class Vector2D {

	public double x;
	public double y;

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

	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public void addVector(Vector2D vec) {
		this.x += vec.x;
		this.y += vec.y;
	}

	public void subFromX(double decrement) {
		this.x -= decrement;
	}

	public void subFromY(double decrement) {
		this.y -= decrement;
	}

	public void sub(double x, double y) {
		this.x -= x;
		this.y -= y;
	}

	public void subVector(Vector2D vec) {
		this.x -= vec.x;
		this.y -= vec.y;
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

}
