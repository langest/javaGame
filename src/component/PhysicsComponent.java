package component;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public class PhysicsComponent extends Component{

	private float weight;
	private Vector2D velocity;

	public PhysicsComponent(Entity owner) {
		super(Component.TYPE_PHYSICS, owner);

	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	/**
	 * Calculates the new velocity in a direction given the old velocity and the acceleration.
	 * 
	 * Velocity = v
	 * Acceleration = a
	 * Friction = f
	 * 
	 * v(0) = v
	 * v(1) = v(0) / f + a =
	 *      = v / f + a.
	 * v(2) = v(1) / f + a =
	 *      = (v / f + a) / f + a =
	 *      = v / f^2 + a / f + a.
	 * v(3) = v / f^3 + a / f^2 + a / f + a.
	 * 
	 * Using geometric sum:
	 * v(delta) = v / f^(delta) + a * (((1 / f^(delta)) - 1) / ((1 / f) - 1)), where f != 1.
	 * v(delta) = v / f^(delta) + a * delta, where f == 1.
	 * 
	 * @param velocity
	 * @param acceleration
	 * @param friction
	 * @param delta
	 * @return
	 */
	protected float newVelocity(float velocity, float acceleration, float friction, int delta) {
		float newVelocity = (float) (velocity / Math.pow(friction, delta));
		if (friction == 1) {
			return newVelocity + acceleration * delta;
		} else {
			return (float) (newVelocity + acceleration * ((1 / Math.pow(friction, delta)) - 1) / ((1 / friction) - 1));
		}
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		// Do nothing.

	}

	@Override
	public void init() throws ComponentException {
		// Do nothing.
	}

}
