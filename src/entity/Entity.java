package entity;

import java.util.HashMap;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import math.Vector2D;
import component.Component;
import component.ComponentException;
import component.render.RenderComponent;
import component.RenderableComponent;
import manager.EntityManager;

public class Entity{
	private String ID;

	private Vector2D position;

	private EntityManager entityManager;
	private HashMap<Integer, Component> components;


	public Entity (String ID, EntityManager em) {
		this.ID = ID;
		this.entityManager = em;
		components = new HashMap<Integer, Component>();
		position = new Vector2D();
	}

	public void addComponent (Integer componentType, Component component) {
		component.setOwner(this);
		components.put(componentType, component);
	}

	public Component getComponentByType(Integer componentType) {
		return components.get(componentType);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public int getWidth() {
		RenderComponent rend = (RenderComponent) getComponentByType(Component.TYPE_RENDER);
		if (rend != null)
			return rend.getWidth();
		else
			return 0;
	}

	public int getHeight() {
		RenderComponent rend =  (RenderComponent) getComponentByType(Component.TYPE_RENDER);
		if (rend != null)
			return rend.getHeight();
		else
			return 0;
	}


	public void update(GameContainer gc, BasicGame bg, int delta) {
		for (Component comp : components.values()) {
			comp.update(gc, bg, delta);
		}
	}

	public void render(GameContainer gc, BasicGame bg, Graphics gr) {
		for(Component c : components.values()) {
			if(c.getComponentType() == Component.TYPE_RENDER) {
				((RenderableComponent) c).render(gc, bg, gr);
			}
		}
	}

	public void initComponents() {
		for (Component c : components.values()) {
			try {
				c.init();
			} catch (ComponentException e) {
				System.err.println("initComponents() failed in\n entity: " + ID + "\n component: " + c.getClass().getName() + ".");
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public String getId() {
		return ID;
	}


}
