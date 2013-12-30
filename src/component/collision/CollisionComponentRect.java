package component.collision;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import component.Component;
import component.ComponentException;
import component.ComponentType;
import entity.Entity;

public class CollisionComponentRect extends Component{

	private float width,
				  height;

	public CollisionComponentRect(Entity owner) {
		super(ComponentType.COLLISION, owner);

		this.width = owner.getWidth();
		this.height = owner.getHeight();
	}

	/** TODO check documentation so that it is correct
	 * Returns the separating axises for this collision component.
	 * The "o" in the following illustration is the vector for the rect entitys
	 * x-component SAT if the entity is down to the right and the "0"
	 * is the corresponding y-component SAT.
	 * So the returned vector is actually pointing at the corner of the rectangle,
	 * but shouldn't be used that way.
	 * 
	 * 	+---------------o-----------> x-axis
	 * 	|				|
	 * 	|		
	 * 	|				|
	 * 	|
	 * 	|				|
	 * 	|
	 * 	0- - - - - - - -[------]
	 * 	|				[------]  <-rect entity
	 * 	|
	 * 	|
	 * 	|
	 * 	V y-axis
	 * 
	 * Throws exception if (angle < -Math.PI || Math.PI < angle)
	 * 
	 * 
	 * Angle is the direction to the center of the other collision components owner.
	 * As the unit circle. As radians.
	 */
	public Vector2D getSATRect(float angle) {
		if (angle < (float) -Math.PI || (float) Math.PI < angle) throw new IllegalArgumentException("angle must be in [-Pi,Pi]");
		
		angle = (float) (angle % (Math.PI * 2)); //The angle we want to calculate SAT for
		Vector2D ownerPos = owner.getPosition();

		if (angle < -Math.PI/2) {
			return new Vector2D(ownerPos.x - width/2, ownerPos.y - height/2);
		}
		
		if (angle < 0) {
			return new Vector2D(ownerPos.x + width/2, ownerPos.y - height/2);
		}
		
		if (angle < Math.PI/2) {
			return new Vector2D(ownerPos.x - width/2, ownerPos.y + height/2);
		}
		/*if(angle < Math.PI)*/
			return new Vector2D(ownerPos.x + width/2, ownerPos.y + height/2);

	}
	
	public float getHeight() {
		return this.height;
	}
	public float getWidth() {
		return this.width;
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {

	}

	@Override
	public void init() throws ComponentException {

	}

}
