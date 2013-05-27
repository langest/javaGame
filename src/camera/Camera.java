package camera;

import entity.Entity;
import math.Vector2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Camera {
	protected Vector2D position;
	protected Vector2D centerPoint;
	protected final float CAMERA_SCROLL_ACCELERATION = .33f;

	public Camera(GameContainer gc) {
		position = new Vector2D();
		centerPoint = new Vector2D(gc.getWidth()/2, gc.getHeight()/2);
		this.position.x = 0;
		this.position.y = 0;
	}

	public Vector2D getPosition() {
		return position;
	}

	/**
	 * Pans the camera towards the center of an entity.
	 */
	public void update(Entity centerEntity, GameContainer gc, int delta) {
		float monkeyX = centerEntity.getPosition().x - (gc.getWidth() - centerEntity.getWidth())/ (2);

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
		/*gr.translate(centerPoint.x, centerPoint.y);
		gr.scale(scale.x, scale.y);
		gr.rotate(0, 0, rotation);
		gr.translate(-centerPoint.x, -centerPoint.y);
		gr.translate(-position.x, -position.y);
		*/
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
