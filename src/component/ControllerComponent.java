package component;

import java.util.Random;

import manager.EntityManager;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entity.Entity;

public class ControllerComponent extends Component{

	Input input;
	EntityManager entityManager;
	
	public ControllerComponent(Entity owner) {
		super(Component.TYPE_CONTROLLER);
		setOwner(owner);
		entityManager = owner.getEntityManager();
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		input = gc.getInput();
		if (input.isKeyDown(Input.KEY_S)) {
			owner.getPosition().addToY(5);
		}
		if (input.isKeyDown(Input.KEY_W)) {
			owner.getPosition().subFromY(5);
		}
		if (input.isKeyDown(Input.KEY_D)) {
			owner.getPosition().addToX(5);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			owner.getPosition().subFromX(5);
		}
	}

	@Override
	public void init() throws ComponentException {

	}
}
