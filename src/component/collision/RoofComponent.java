package component.collision;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import component.ComponentException;
import component.ComponentType;
import component.PhysicsComponent;
import constants.Constants;
import entity.Entity;

public class RoofComponent extends CollisionActionComponent {

	public RoofComponent(Entity owner) {
		super(ComponentType.COLLISION_ACTION, owner);
	}

	@Override
	public void collide(Entity e, int dir) {
		PhysicsComponent pc = ( (PhysicsComponent) e.getComponentByType(ComponentType.PHYSICS));
		
		if (dir == Constants.HIT_FROM_RIGHT) {
			pc.getVelocity().y = 0;
			e.getPosition().y = owner.getPosition().y+e.getHeight();
		}
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		
	}

	@Override
	public void init() throws ComponentException {

	}


}
