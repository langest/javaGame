package component;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public class AttractionComponent extends Component{
	
	public static final float gravConst = 2;

	public AttractionComponent(Entity owner) {
		super(Component.TYPE_ATTRACTION, owner);
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		PhysicsComponent ownerPC = (PhysicsComponent) owner.getComponentByType(Component.TYPE_PHYSICS);
		PhysicsComponent targetPC = null;
		Vector2D targetPos = null;
		Vector2D ownerPos = owner.getPosition();
		Vector2D acceleration = null;
		
		for (Entity e : owner.getEntityManager().getEntityList()) {
			targetPC = (PhysicsComponent) e.getComponentByType(Component.TYPE_PHYSICS);
			if (targetPC != null) {
				targetPos = e.getPosition();
				
				acceleration = calcAttrAcc(ownerPC.getWeight(), targetPC.getWeight(), ownerPos, targetPos);
				// TODO Attract stuff
			}
		}
		
	}

	/**
	 * Calculates the physical attraction between 2 entities.
	 * 
	 * @param mass1
	 * @param mass2
	 * @param pos1
	 * @param pos2
	 * @return a vector2D of the acceleration of how the second entity accelerates towards the first.
	 */
	private Vector2D calcAttrAcc(float mass1, float mass2, Vector2D pos1, Vector2D pos2) {
		
		float t = gravConst * mass1 * mass2;
		
		float x = (float) (t / Math.pow(pos1.x - pos2.x,2));
		float y = (float) (t / Math.pow(pos1.x - pos2.x,2));
		
		return new Vector2D(x, y);
		}
	
	@Override
	public void init() throws ComponentException {
		// TODO Check for owner physics
		
	}

}
