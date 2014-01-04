package component.render;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface RenderableComponent {
        void render(GameContainer gc, BasicGame bg, Graphics gr);
}
