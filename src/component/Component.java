package component;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public abstract class Component {
	
	public static final int COMPONENT_RENDER  = 0;

	protected Entity owner;
	protected int componentType;
	
	public void setOwner (Entity owner) {
		this.owner = owner;
	}
	
	public int getComponentType() {
		return this.componentType;
	}
	
	public abstract void update(GameContainer gc, BasicGame bg, int delta);
	
	public abstract void init() throws ComponentException;
}
