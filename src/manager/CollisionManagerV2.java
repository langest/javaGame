package manager;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import component.ComponentType;
import component.collision.CollisionComponentRect;

import entity.Entity;


public class CollisionManagerV2 {
	
	public CollisionManagerV2() {
		
	}
	
	public void checkCollisions(Entity e1, Entity e2) {
		boolean fromRight;
		float length;
		
		if (e2.getPosition().x > e1.getPosition().x) {
			fromRight = true;
			length = e2.getPosition().x - e1.getPosition().x;
		} else {
			fromRight = false;
			length = e1.getPosition().x - e2.getPosition().x;
		}
		
		float halfWidthBox1 = e1.getWidth()/2;
		float halfWidthBox2 = e2.getWidth()/2;
		
		float gapBetweenBoxes = length - halfWidthBox1 - halfWidthBox2;
		
		if (gapBetweenBoxes > 0) {
			if (fromRight) System.out.println("it's a gap and we are to the right");
			else System.out.println("it's a gap and we are to the left");
		} else {
			if (fromRight) System.out.println("collision from right");
			else System.out.println("collision from left");
		} 
		
		/*
		var length:Number = box2.x - box1.x;
	var half_width_box1:Number = box1.width*0.5;
	var half_width_box2:Number = box2.width*0.5;
	 
	var gap_between_boxes:Number = length - half_width_box1 - half_width_box2;
	if(gap_between_boxes > 0) trace("It's a big gap between boxes")
	else if(gap_between_boxes == 0) trace("Boxes are touching each other")
	else if(gap_between_boxes < 0) trace("Boxes are penetrating each other")*/
		
	}
	
	public void update(ArrayList<Entity> entityList) {
		for (Entity e1 : entityList) {
			for (Entity e2 : entityList) {
				if (!e1.toString().equals("Player") && e2.toString().equals("Player") ) {
					/* debugging */
					//System.out.println("Collision between " + e1 + " and " + e2 + " results in angle: "	+ e1.getPosition().getAngleToPos(e2.getPosition()));
					checkCollisions(e1, e2);

				}

			}

		}
	}

	public void render(GameContainer gc, BasicGame bg, Graphics gr) {

	}

}
