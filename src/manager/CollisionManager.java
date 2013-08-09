package manager;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import component.collision.CollisionComponent;
import entity.Entity;

import math.Vector2D;

public class CollisionManager {
	
	public static Vector2D getCollision(CollisionComponent a, Vector2D aPos, CollisionComponent b, Vector2D bPos) {
		
		Vector2D vec = new Vector2D(aPos);
		vec.sub(bPos);
		
		float alpha = (float) Math.acos(vec.x);
		
		return null;
	}
	
	public void update(GameContainer gc, BasicGame bg, int delta) {
		for (Entity e : entityList) {
			e.update(gc, bg, delta);
		}
	}
}
