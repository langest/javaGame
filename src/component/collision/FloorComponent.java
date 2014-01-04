package component.collision;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import component.ComponentException;
import component.ComponentType;
import component.PhysicsComponent;
import constants.Constants;
import entity.Entity;

public class FloorComponent extends CollisionActionComponent {

	public FloorComponent(Entity owner) {
		super(ComponentType.COLLISION_ACTION, owner);
	}

	@Override
	public void collide(Entity e, int dir) {
		PhysicsComponent pc = ( (PhysicsComponent) e.getComponentByType(ComponentType.PHYSICS));
		
		//Bouncy
		/*if (dir == Constants.HIT_FROM_LEFT || dir == Constants.HIT_FROM_RIGHT) pc.getVelocity().x = -pc.getVelocity().x;
		else pc.getVelocity().y = -pc.getVelocity().y;*/
		
		/*if (dir == Constants.HIT_FROM_LEFT) {
			pc.getVelocity().x = 0;
			e.getPosition().x = owner.getPosition().x-e.getWidth();
		} else if (dir == Constants.HIT_FROM_RIGHT) {
			pc.getVelocity().x = 0;
			e.getPosition().x = owner.getPosition().x+owner.getWidth();
		} else if (dir == Constants.HIT_FROM_UNDER) {
			pc.getVelocity().y = 0;
			e.getPosition().y = owner.getPosition().y+owner.getHeight();
		} else*/
		if (dir == Constants.HIT_FROM_ABOVE) {
			pc.getVelocity().y = 0;
			e.getPosition().y = owner.getPosition().y-e.getHeight();
			pc.setGroundBound(true);
		}
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		
	}

	@Override
	public void init() throws ComponentException {

	}


}
