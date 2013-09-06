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
		Vector2D aSAT = a.getSATRect(angleFromAToB);
		Vector2D bSAT = b.getSATRect(angleFromAToB);

		float minSATOverlapX = Float.MAX_VALUE;
		float minSATOverlapY = Float.MAX_VALUE;

		//Compare y-vectors (for now only rect)
		if (angleFromAToB < 0) { //a is above b
			//System.out.print("OVER ");

			if (aSAT.y > bSAT.y && aSAT.y < bSAT.y + b.getHeight()) {
				minSATOverlapY = bSAT.y - aSAT.y;
			}

		}
		else { //a is under b
			//System.out.print("UNDER ");

			if (aSAT.y < bSAT.y && aSAT.y > bSAT.y - b.getHeight()) {
				minSATOverlapY = bSAT.y - aSAT.y;
			}
		}

		//Compare x-vectors (for now only rect)
		if (angleFromAToB < Math.PI/2 && angleFromAToB > -Math.PI/2) { //a is to the right
			//System.out.println("and on the RIGHT.");

			if (aSAT.x < bSAT.x && aSAT.x > bSAT.x - b.getWidth()) {
				minSATOverlapX = bSAT.x - aSAT.x;
			}

		} else { //a is to the left
			//System.out.println("and on the LEFT.");

			if (aSAT.x > bSAT.x && aSAT.x < bSAT.x + b.getWidth()) {
				minSATOverlapX = bSAT.x - aSAT.x;
			}

		}

		if (minSATOverlapY != Float.MAX_VALUE && minSATOverlapX != Float.MAX_VALUE) {
			// We have collision!! WOOO
			
			if (Math.abs(minSATOverlapX) > Math.abs(minSATOverlapY)) { //We got a collision in the x-axis
				if (minSATOverlapX < 0) {
					System.out.println("Collision from left");
				} else {
					System.out.println("Collision from right");
				}
			} else { //We got a collision in the y-axis
				if (minSATOverlapY < 0) {
					System.out.println("Collision from top");
				} else {
					System.out.println("Collision from under");
				}
			}
		}

		System.out.println("X: " + minSATOverlapX + "\nY: " + minSATOverlapY);
		
		return 0;

	}

	public void update(ArrayList<Entity> entityList) { //TODO
		CollisionComponentRect c1;
		CollisionComponentRect c2;

		for (Entity e1 : entityList) {
			c1 = (CollisionComponentRect) e1.getComponentByType(ComponentType.COLLISION);

			for (Entity e2 : entityList) {

				c2 = (CollisionComponentRect) e2.getComponentByType(ComponentType.COLLISION);

				if (c1 != null &&  c2 != null && !e1.toString().equals("Player") && e2.toString().equals("Player") ) {
					/* debugging */
					//System.out.println("Collision between " + e1 + " and " + e2 + " results in angle: "	+ e1.getPosition().getAngleToPos(e2.getPosition()));

					checkCollision(c1, c2, e1.getPosition().getAngleToPos(e2.getPosition()));

				}

			}

		}

	}

}
