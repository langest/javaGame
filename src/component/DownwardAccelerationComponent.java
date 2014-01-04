package component;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public class DownwardAccelerationComponent extends Component {
	final Vector2D acceleration = new Vector2D(0, .005f);

	public DownwardAccelerationComponent(Entity owner) {
		super(ComponentType.DOWNWARD_ACCELERATION, owner);
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		PhysicsComponent pc = (PhysicsComponent) owner.getComponentByType(ComponentType.PHYSICS);
		pc.accelerate(acceleration);
	}

	@Override
	public void init() throws ComponentException {
		if (owner.getComponentByType(ComponentType.PHYSICS) == null) {
			throw new ComponentException("Failed to initialize DownwardAccelerationComponent because of missing dependencies.");
		}
	}

}
