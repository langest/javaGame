package component;

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
			owner.getPosition().addToY(5*delta);
		}
		if (input.isKeyDown(Input.KEY_W)) {
			owner.getPosition().subFromY(5*delta);
		}
		if (input.isKeyDown(Input.KEY_D)) {
			owner.getPosition().addToX(5*delta);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			owner.getPosition().subFromX(5*delta);
		}
	}

	@Override
	public void init() throws ComponentException {

	}
}
