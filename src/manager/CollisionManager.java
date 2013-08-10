package manager;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import component.ComponentType;
import component.collision.CollisionComponent;
import component.collision.CollisionComponentRect;
import entity.Entity;

import math.Vector2D;

public class CollisionManager {

	/*
	 * returns a float that is the collision is in, else 0.
	 */
	public float checkCollision(CollisionComponentRect a, CollisionComponentRect b, float angleFromAToB) {
		
		//Compare y-vectors (for now only rect)
		if (angleFromAToB < 0) { //a is above b
			System.out.print("OVER ");
		}
		else { //a is under b
			System.out.print("UNDER ");
		}
		
		//Compare x-vectors (for now only rect)
		if (angleFromAToB < Math.PI/2 && angleFromAToB > -Math.PI/2) { //a is to the right
			System.out.println("and on the RIGHT.");
		} else { //a is to the left
			System.out.println("and on the LEFT.");
		}
		
		return 0;

	}

	public void update(ArrayList<Entity> entityList) { //TODO
		CollisionComponentRect c1;
		CollisionComponentRect c2;
		for (Entity e1 : entityList) {
			c1 = (CollisionComponentRect) e1.getComponentByType(ComponentType.COLLISION);
			for (Entity e2 : entityList) {
				c2 = (CollisionComponentRect) e2.getComponentByType(ComponentType.COLLISION);
				if (!e1.toString().equals("Player") && e2.toString().equals("Player")) {
					System.out.println("Collision between " + e1 + " and " + e2 + " results in angle: "	+ e1.getPosition().getAngleToPos(e2.getPosition()));
					checkCollision(c1, c2, e1.getPosition().getAngleToPos(e2.getPosition()));
				}
			}
		}
	}
}
