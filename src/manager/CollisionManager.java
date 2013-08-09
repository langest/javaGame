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

	
	public float getCollisionAngle(CollisionComponentRect a, Vector2D aPos, CollisionComponentRect b, Vector2D bPos) {
			return 0;

	}

	public void update(ArrayList<Entity> entityList) { //TODO
		CollisionComponentRect c1;
		CollisionComponentRect c2;
		for (Entity e1 : entityList) {
			c1 = (CollisionComponentRect) e1.getComponentByType(ComponentType.COLLISION);
			for (Entity e2 : entityList) {
				c2 = (CollisionComponentRect) e2.getComponentByType(ComponentType.COLLISION);
				if (!e1.toString().equals("Player") && e2.toString().equals("Player")) System.out.println("Collision between " + e1 + " and " + e2 + " results in angle: "
				+ e1.getPosition().getAngleToPos(e2.getPosition()));
			}
		}
	}
}
