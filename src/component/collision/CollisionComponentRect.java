package component.collision;

import java.util.ArrayList;

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

	public CollisionComponentRect(Entity owner, float width, float height) {
		super(ComponentType.COLLISION, owner);

		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the separating axises for this collision component.
	 * The "o" in the following illustration is the vector for the rect entitys
	 * x-component SAT if the entity is down to the right and the t
	 * is the corresponding y-component SAT.
	 * 
	 * 	+---------------o-----------> x-axis
	 * 	|				|
	 * 	|		
	 * 	|				|
	 * 	|
	 * 	|				|
	 * 	|
	 * 	y- - - - - - - -[------]
	 * 	|				[------]  <-rect entity
	 * 	|
	 * 	|
	 * 	|
	 * 	V y-axis
	 * 
	 * Throws exception if (angle < -Math.PI || Math.PI < angle)
	 * 
	 * Angle is the direction to the center of the other collision components owner.
	 * As the unit circle. As radians.
	 * First in the list is the owners position, second in list is the vertical SAT, third The horizontal.
	 */
	public ArrayList<Vector2D> getSATRect(float angle) {
		
		if (angle < -Math.PI || Math.PI < angle) throw new IllegalArgumentException("angle must be in [-Pi,Pi]");
		
		angle = (float) (angle % (Math.PI * 2)); //The angle we want to calculate SAT for
		ArrayList<Vector2D> ret = new ArrayList<Vector2D>(); //The array that will containing the SATs for given angle
		Vector2D ownerPos = owner.getPosition();

		if (angle < -Math.PI/2) {
			ret.add(new Vector2D(0,ownerPos.y - height/2));
			ret.add(new Vector2D(ownerPos.x - width/2, 0));
		}
		else if (angle < 0) {
			ret.add(new Vector2D(0,ownerPos.y - height/2));
			ret.add(new Vector2D(ownerPos.x + width/2, 0));
		}
		else if (angle < Math.PI/2) {
			ret.add(new Vector2D(0, ownerPos.y + height/2));
			ret.add(new Vector2D(ownerPos.x - width/2, 0));
		}
		else /*if(angle < Math.PI)*/ {
			ret.add(new Vector2D(0, ownerPos.y + height/2));
			ret.add(new Vector2D(ownerPos.x + width/2, 0));
		}

		return ret;
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {

	}

	@Override
	public void init() throws ComponentException {

	}

}
