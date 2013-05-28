package component.render;

import component.ComponentException;

import math.Vector2D;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import entity.Entity;

public class ImageRenderComponent extends RenderComponent {    
	
	Image image;
	
	public ImageRenderComponent(Image image, Entity owner) {
		super(owner);
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	@Override
	public void render(GameContainer gc, BasicGame bg, Graphics gr) {
		Vector2D pos = owner.getPosition();
		image.draw(pos.x-image.getWidth()/2, pos.y-image.getHeight()/2);
	}

	@Override
	public void update(GameContainer gc, BasicGame bg, int delta) {
		//DO SOMETHING
	}

	@Override
	public void init() throws ComponentException {
		// DO NOTHING          
	}

}
