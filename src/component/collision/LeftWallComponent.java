package component.collision;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import component.ComponentException;
import component.ComponentType;
import component.PhysicsComponent;
import constants.Constants;
import entity.Entity;

public class LeftWallComponent extends CollisionActionComponent {

	public LeftWallComponent(Entity owner) {
		super(ComponentType.COLLISION_ACTION, owner);
	}

	@Override
	public void collide(Entity e, int dir) {
		PhysicsComponent pc = ( (PhysicsComponent) e.getComponentByType(ComponentType.PHYSICS));
		
		if (dir == Constants.HIT_FROM_LEFT) {
			pc.getVelocity().x = 0;
			e.getPosition().x = owner.getPosition().x-e.getWidth();
		}
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		
	}

	@Override
	public void init() throws ComponentException {

	}


}
