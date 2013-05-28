package component;

import component.PhysicsComponent;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entity.Entity;

public class ControllerComponent extends Component{

	Input input;
	
	public ControllerComponent(Entity owner) {
		super(Component.TYPE_CONTROLLER, owner);
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		input = gc.getInput();
		if (input.isKeyDown(Input.KEY_S)) {
			((PhysicsComponent) owner.getComponentByType(Component.TYPE_PHYSICS)).accelerate(new Vector2D(0, .1f * delta));
		}
		if (input.isKeyDown(Input.KEY_W)) {
			((PhysicsComponent) owner.getComponentByType(Component.TYPE_PHYSICS)).accelerate(new Vector2D(0, -.1f * delta));
		}
		if (input.isKeyDown(Input.KEY_D)) {
			owner.getPosition().addToX(delta);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			owner.getPosition().subFromX(delta);
		}
	}

	@Override
	public void init() throws ComponentException {
		if (owner.getComponentByType(Component.TYPE_PHYSICS) == null) {
			throw new ComponentException("Failed to initialize GravityComponent because of missing dependencies.");
		}
	}
}
