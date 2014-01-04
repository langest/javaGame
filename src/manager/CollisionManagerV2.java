package manager;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import component.Component;
import component.ComponentType;
import component.collision.CollisionComponentRect;
import component.render.RenderableComponent;
import constants.Constants;
import entity.Entity;


public class CollisionManagerV2 {

	public CollisionManagerV2() {

	}

	public void checkCollisions(Entity e1, Entity e2) {
		
		/*pseduocode
		var length:Number = box2.x - box1.x;
	var half_width_box1:Number = box1.width*0.5;
	var half_width_box2:Number = box2.width*0.5;

	var gap_between_boxes:Number = length - half_width_box1 - half_width_box2;
	if(gap_between_boxes > 0) trace("It's a big gap between boxes")
	else if(gap_between_boxes == 0) trace("Boxes are touching each other")
	else if(gap_between_boxes < 0) trace("Boxes are penetrating each other")*/

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

		float horGapBetweenBoxes = length - halfWidthBox1 - halfWidthBox2;

		/*if (horGapBetweenBoxes > 0) {
			if (fromRight) System.out.println("it's a gap and we are to the right");
			else System.out.println("it's a gap and we are to the left");
		} else {
			if (fromRight) System.out.println("collision from right");
			else System.out.println("collision from left");
		}*/

		boolean fromAbove;
		float height;

		if (e2.getPosition().y > e1.getPosition().y) {
			fromAbove = false;
			height = e2.getPosition().y - e1.getPosition().y;
		} else {
			fromAbove = true;
			height = e1.getPosition().y - e2.getPosition().y;
		}

		float halfHeightBox1 = e1.getHeight()/2;
		float halfHeightBox2 = e2.getHeight()/2;

		float verGapBetweenBoxes = height - halfHeightBox1 - halfHeightBox2;

		/*if (verGapBetweenBoxes > 0) {
			if (fromAbove) System.out.println("it's a gap and we are above");
			else System.out.println("it's a gap and we are to the under");
		} else {
			if (fromAbove) System.out.println("collision from above");
			else System.out.println("collision from under");
		}*/
		
		/*System.out.println("hor gap: " + horGapBetweenBoxes + ", ver gap: " + verGapBetweenBoxes);
		if (horGapBetweenBoxes < verGapBetweenBoxes) {
			if (fromRight) System.out.println("We hit mostly from the right");
			else System.out.println("We hit mostly from the left");
		} else {
			if (fromAbove) System.out.println("We hit mostly from above");
			else System.out.println("We hit mostly from underneath");
		}*/
		
		if (verGapBetweenBoxes > 0 || horGapBetweenBoxes > 0) {
			return;
		}
		
		if (horGapBetweenBoxes > verGapBetweenBoxes) {
			if (fromRight) {
				e1.collide(e2, Constants.HIT_FROM_RIGHT);
			}
			else {
				e1.collide(e2, Constants.HIT_FROM_LEFT);
			}
		} else {
			if (fromAbove) {
				e1.collide(e2, Constants.HIT_FROM_ABOVE);
			}
			else {
				e1.collide(e2, Constants.HIT_FROM_UNDER);
			}
		}
		

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
