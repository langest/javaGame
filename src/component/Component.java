package component;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public abstract class Component {

	public static final int TYPE_INVALID    = 0,
							TYPE_RENDER     = 1,
							TYPE_CONTROLLER = 2;

	protected Entity owner;
	protected int componentType = TYPE_INVALID;

	public Component(int type) {
		this.componentType = type;
	}
	
	public void setOwner (Entity owner) {
		this.owner = owner;
	}

	public int getComponentType() {
		return this.componentType;
	}

	public abstract void update(GameContainer gc, BasicGame bg, int delta);

	public abstract void init() throws ComponentException;
}
