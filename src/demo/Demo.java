package demo;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import component.Component;
import component.render.ImageRenderComponent;

import camera.*;
import entity.Entity;
import math.Vector2D;
import manager.EntityManager;

public class Demo extends BasicGame {

	EntityManager entityManager;
	Entity dot;

	Camera camera;

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Demo());

		app.setDisplayMode(1020, 540, false);
		app.start();
	}
	
	public Demo() {
		super("Demo");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		entityManager = new EntityManager();
		camera = new Camera(gc);

		dot = new Entity("dot", entityManager);

		dot.addComponent(Component.TYPE_RENDER, new ImageRenderComponent(new Image("/img/img.jpg")));

		dot.initComponents();

		dot.setPosition(new Vector2D(461, 300));

		entityManager.add(dot);

		gc.setTargetFrameRate(60);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		entityManager.update(gc, null, delta);

		camera.update(dot, gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		camera.render(gr);

		entityManager.render(gc, null, gr);

		camera.renderDone(gr);
	}

}
