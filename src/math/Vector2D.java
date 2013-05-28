package math;

public class Vector2D {

	public float x;
	public float y;

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}

	public void addToX(float increment) {
		this.x += increment;
	}

	public void addToY(float increment) {
		this.y += increment;
	}

	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public void addVector(Vector2D vec) {
		this.x += vec.x;
		this.y += vec.y;
	}

	public void subFromX(float decrement) {
		this.x -= decrement;
	}

	public void subFromY(float decrement) {
		this.y -= decrement;
	}

	public void sub(float x, float y) {
		this.x -= x;
		this.y -= y;
	}

	public void subVector(Vector2D vec) {
		this.x -= vec.x;
		this.y -= vec.y;
	}

	public float getMagnitude() {
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	/**
	 * Multiplies x- and y-component of this vector by s.
	 * @param s The scaling factor.
	 */
	public void scaleBy(float s) {
		x = x*s;
		y = y*s;
	}
	
	@Override
	public String toString(){
		return "x = " + x + ", y = " + y;
	}

}
