package component;

import math.Vector2D;
import component.ComponentException;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public class GravitationComponent extends Component{

	public static final float gravConst = 1;

	public GravitationComponent(Entity owner) {
		super(Component.TYPE_GRAVITATION, owner);
	}
	
	/**
	 * Calculates the physical attraction between 2 entities.
	 * 
	 * @param mass1
	 * @param mass2
	 * @param pos1
	 * @param pos2
	 * @return a vector2D of the components of the acceleration.
	 */
	private Vector2D calcAccComp(float mass1, float mass2, Vector2D pos1, Vector2D pos2) {

		System.out.println("mass1: " + mass1 + ", mass2: " + mass2 + " pos1: x=" +pos1.x+" y=" +pos1.y+", pos2: x=" +pos2.x+" y=" +pos2.y);
		
		float t = gravConst * mass1 * mass2;
		float r = (float) Math.sqrt(Math.pow((pos1.x - pos2.x), 2) + Math.pow((pos1.y - pos2.y), 2));
		float d = (float) (t / Math.pow(r, 2));
		
		// Calculate direction
		float x, y;
		
		x = pos1.x - pos2.x;
		y = pos1.y - pos2.y;
		
		x = x/(abs(x)+abs(y));
		y = y/(abs(x)+abs(y));
		
		Vector2D direction = new Vector2D(x,y);
		direction.scaleBy(d);
		
		//System.out.println("Beräknare, x: " + x + ", y: " + y );
		//System.out.println("d: " + d);
		
		return direction;
	}
	
	private float abs(float f) {
		return (float) Math.abs(f);
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
			if (targetPC != null && e != owner) {
				targetPos = e.getPosition();

				acceleration = calcAccComp(ownerPC.getWeight(), targetPC.getWeight(), ownerPos, targetPos);
				
				targetPC.accelerate(acceleration);
				
			}
		}

	}

	@Override
	public void init() throws ComponentException {
		if (owner.getComponentByType(Component.TYPE_PHYSICS) == null) {
			throw new ComponentException("Failed to initialize GravityComponent because of missing dependencies.");
		}
	}

}
