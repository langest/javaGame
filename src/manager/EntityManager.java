package manager;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import entity.Entity;

public class EntityManager {

	private ArrayList<Entity> entityList;
	private CollisionManagerV2 collisionManager;

	public EntityManager() {
		this.entityList = new ArrayList<Entity>();
		this.collisionManager = new CollisionManagerV2();
	}

	public void add(Entity e) {
		entityList.add(e);
	}

	public ArrayList<Entity> getEntityList() {
		return this.entityList;
	}

	public void update(GameContainer gc, BasicGame bg, int delta) {
		for (Entity e : entityList) {
			e.update(gc, bg, delta);
		}
		collisionManager.update(entityList);
	}

	public void render(GameContainer gc, BasicGame bg, Graphics gr) {
		for (Entity e : entityList) {
			e.render(gc, bg, gr);
		}
	}
}
