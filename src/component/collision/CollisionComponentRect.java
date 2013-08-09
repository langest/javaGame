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
	 * 
	 * Angle is the direction to the center of the other collision components owner.
	 * As the unit circle. As radians.
	 * First in the list is the owners position, second in list is the vertical SAT, third The horizontal.
	 */
	public ArrayList<Vector2D> getSATRect(float angle) {
		angle = (float) (angle % (Math.PI * 2));
		ArrayList<Vector2D> ret = new ArrayList<Vector2D>();
		Vector2D ownerPos = owner.getPosition();
		
		ret.add(owner.getPosition());
		if (angle < Math.PI/2) {
			ret.add(new Vector2D(ownerPos.x, ownerPos.y-height/2));
			ret.add(new Vector2D(width/2, 0));
		}else if(angle < Math.PI) {
			ret.add(new Vector2D(0,-height/2));
			ret.add(new Vector2D(-width/2, 0));
		}else if (angle < Math.PI*2/3) {
			ret.add(new Vector2D(0,height/2));
			ret.add(new Vector2D(-width/2, 0));
		}else {
			ret.add(new Vector2D(0,height/2));
			ret.add(new Vector2D(width/2, 0));
		}
		
		return ret;
	}
	
	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws ComponentException {
		// TODO Auto-generated method stub
		
	}

}
