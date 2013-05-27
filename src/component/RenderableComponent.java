package component;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface RenderableComponent {
        void render(GameContainer gc, BasicGame sb, Graphics gr);
}
