package entity;

import java.util.HashMap;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import math.Vector2D;
import component.Component;
import component.ComponentException;
import component.RenderableComponent;
import manager.EntityManager;

public class Entity{
	private int ID;

	private Vector2D position;

	private EntityManager entityManager;
	private HashMap<Integer, Component> components;


	public Entity (int ID, EntityManager em) {
		this.ID = ID;
		this.entityManager = em;
		components = new HashMap<Integer, Component>();
		position = new Vector2D();
	}

	public void addComponent (Component component, Integer componentType) {
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

	public void update(GameContainer gc, BasicGame bg, int delta) {
		for (Component comp : components.values()) {
			comp.update(gc, bg, delta);
		}
	}

	public void render(GameContainer gc, BasicGame bg, Graphics gr) {
		for(Component c : components.values()) {
			if(c.getComponentType() == Component.COMPONENT_RENDER) {
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

    public Integer getId() {
            return ID;
    }


}