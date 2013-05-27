package component.render;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import component.Component;
import component.RenderableComponent;

public abstract class RenderComponent extends Component implements RenderableComponent {

    public RenderComponent() {
		super(Component.TYPE_RENDER);
	}

	public abstract int getWidth();
   
    public abstract int getHeight();
	
	public abstract void render(GameContainer gc, BasicGame sb, Graphics gr);
}
