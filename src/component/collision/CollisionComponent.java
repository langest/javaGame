package component.collision;

import component.Component;
import component.ComponentType;
import entity.Entity;

public abstract class CollisionComponent extends Component{

	public CollisionComponent(Entity owner) {
		super(ComponentType.COLLISION, owner);
	}

}
