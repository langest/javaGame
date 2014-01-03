package component.collision;

import component.Component;
import component.ComponentType;
import entity.Entity;

public abstract class CollisionActionComponent extends Component {

	public CollisionActionComponent(ComponentType type, Entity owner) {
		super(type, owner);
	}
	
	public abstract void collide(Entity e, int dir);
}
