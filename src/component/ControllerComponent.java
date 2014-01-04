package component;

import component.PhysicsComponent;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entity.Entity;

public class ControllerComponent extends Component{

	private Input input;
	
	public ControllerComponent(Entity owner) {
		super(ComponentType.CONTROLLER, owner);
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		input = gc.getInput();
		if (input.isKeyDown(Input.KEY_S)) {
			((PhysicsComponent) owner.getComponentByType(ComponentType.PHYSICS)).accelerate(new Vector2D(0, .0002f * delta));
		}
		if (input.isKeyDown(Input.KEY_W)) {
			((PhysicsComponent) owner.getComponentByType(ComponentType.PHYSICS)).accelerate(new Vector2D(0, -.0002f* delta));
		}
		if (input.isKeyDown(Input.KEY_D)) {
			((PhysicsComponent) owner.getComponentByType(ComponentType.PHYSICS)).accelerate(new Vector2D(.0002f * delta, 0));
		}
		if (input.isKeyDown(Input.KEY_A)) {
			((PhysicsComponent) owner.getComponentByType(ComponentType.PHYSICS)).accelerate(new Vector2D(-.0002f * delta, 0));
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			jump(((PhysicsComponent) owner.getComponentByType(componentType.PHYSICS)), delta);
		}
	}
	
	private void jump(PhysicsComponent pc, int delta) {
		if (pc.isGroundBound()) {
			pc.accelerate(new Vector2D(0, -.06f));
			pc.setGroundBound(false);
		}
		
	}

	@Override
	public void init() throws ComponentException {
		if (owner.getComponentByType(ComponentType.PHYSICS) == null) {
			throw new ComponentException("Failed to initialize GravityComponent because of missing dependencies.");
		}
	}
}
