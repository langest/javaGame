package math;

public class CollissionDetection {
	public static final int TYPE_CIRCLE = 0,
			TYPE_RECT   = 1;

	public CollissionDetection(int type) {
		switch (type) {
		case TYPE_CIRCLE:
			System.out.println("circle");
		case TYPE_RECT:
			System.out.println("rect");
		default:
			System.out.println("invalid type");
		}
	}
}