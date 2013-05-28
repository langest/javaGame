package component;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public abstract class Component {

	public static final int TYPE_INVALID		= 0,
							TYPE_RENDER			= 1,
							TYPE_CONTROLLER		= 2,
							TYPE_PHYSICS		= 3,
							TYPE_GRAVITATION	= 4;
	
	protected Entity owner;
	protected int componentType = TYPE_INVALID;

	/**
	 * Creates a component of type type.
	 * 
	 * Type makes sure that each entity only contains one of
	 * each type of component.
	 * 
	 * @param type The type ID of this component. e.g. TYPE_RENDER
	 * for a render component and TYPE_PHYSICS for a physics component.
	 */
	public Component(int type, Entity owner) {
		this.componentType = type;
		setOwner(owner);
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
