package component;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;

import entity.Entity;

public abstract class Component {

	protected Entity owner;
	protected ComponentType componentType = ComponentType.INVALID;

	/**
	 * Creates a component of type type.
	 * 
	 * Type makes sure that each entity only contains one of
	 * each type of component.
	 * 
	 * @param type The type ID of this component. e.g. TYPE_RENDER
	 * for a render component and TYPE_PHYSICS for a physics component.
	 */
	public Component(ComponentType type, Entity owner) {
		this.componentType = type;
		setOwner(owner);
	}
	
	public void setOwner (Entity owner) {
		this.owner = owner;
	}

	public ComponentType getComponentType() {
		return this.componentType;
	}

	public abstract void update(GameContainer gc, BasicGame bg, int delta);

	public abstract void init() throws ComponentException;
}
