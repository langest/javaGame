package camera;

import entity.Entity;
import math.Vector2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Camera {
	protected Vector2D position;
	protected Vector2D scale;
	protected Vector2D centerPoint;

	public Camera(GameContainer gc) {
		position = new Vector2D();
		scale = new Vector2D(1, 1);
		centerPoint = new Vector2D(gc.getWidth()/2, gc.getHeight()/2);
		this.position.x = 0;
		this.position.y = 0;
	}

	public Vector2D getPosition() {
		return position;
	}

	public Vector2D getScale() {
		return scale;
	}

	/**
	 * Sets the camera to be centered on the position of an entity (such as the
	 * player Entity). Sets a minimum X position if the resulting X position
	 * from centering is less than 0.
	 *
	 * @param monkey
	 *            The entity to center the camera to.
	 * @param gc
	 *            GameContainer
	 */
	public void update(Entity monkey, GameContainer gc, int delta) {
		Input input = gc.getInput();
		float increment = 0.05f;
		if (input.isKeyDown(Input.KEY_1)) {
			scale.x = scale.x + increment;
			scale.y = scale.y + increment;
		} else if (input.isKeyDown(Input.KEY_2)) {
			scale.x = scale.x - increment;
			scale.y = scale.y - increment;
		} if (input.isKeyDown(Input.KEY_Q)){
			rotation += increment*50;
		} else if (input.isKeyDown(Input.KEY_E)) {
			rotation -= increment*50;
		}
		float monkeyX = monkey.getPosition().x - (gc.getWidth() - monkey.getWidth())/ (2);

		float newCameraX = position.x + delta * (monkeyX - position.x) / (gc.getWidth() * CAMERA_SCROLL_ACCELERATION);
		if (newCameraX < 0) {
			position.x = 0;
		} else if (newCameraX > 3600 - gc.getWidth()) {
			position.x = 3600 - gc.getWidth();
		} else {
			position.x = newCameraX;
		}


		//position.y = (gc.getHeight() - gc.getHeight() / scale.y) / 2;

	}

	/**
	 * This method should be called in the main render method before rendering
	 * anything else. All coordinates used in subsequent rendering methods will
	 * be rendered relative to the coordinates entered as arguments in
	 * Graphics.translate().
	 *
	 * @param gr
	 */
	public void render(Graphics gr) {
		gr.translate(centerPoint.x, centerPoint.y);
		gr.scale(scale.x, scale.y);
		gr.rotate(0, 0, rotation);
		gr.translate(-centerPoint.x, -centerPoint.y);
		gr.translate(-position.x, -position.y);


	}

	/**
	 * This method should be called in the main render method after all other
	 * rendering is done.
	 *
	 * @param gr
	 */
	public void renderDone(Graphics gr) {
		gr.resetTransform();
	}
}
