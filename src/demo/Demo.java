package demo;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import component.ComponentType;
import component.ControllerComponent;
import component.PhysicsComponent;
import component.collision.CollisionComponentRect;
import component.render.ImageRenderComponent;

import camera.*;
import entity.Entity;
import math.Vector2D;
import manager.EntityManager;

public class Demo extends BasicGame {

	private EntityManager entityManager;
	private Entity dot, dot2;

	private Camera camera;

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


		
		dot2 = new Entity("NPC", entityManager);
		dot2.setPosition(new Vector2D(300, 150));
		dot2.addComponent(ComponentType.RENDER, new ImageRenderComponent(new Image("/img/img.jpg"), dot2));
		dot2.addComponent(ComponentType.PHYSICS, new PhysicsComponent(dot2, 10f));
		//dot2.addComponent(ComponentType.GRAVITATION, new GravitationComponent(dot2));
		dot2.addComponent(ComponentType.COLLISION, new CollisionComponentRect(dot2));
		dot2.initComponents();
		entityManager.add(dot2);
		
		
		dot = new Entity("Player", entityManager);
		dot.setPosition(new Vector2D(300, 150));
		dot.addComponent(ComponentType.RENDER, new ImageRenderComponent(new Image("/img/oldMan.png"), dot));
		dot.addComponent(ComponentType.CONTROLLER, new ControllerComponent(dot));
		//dot.addComponent(ComponentType.GRAVITATION, new GravitationComponent(dot));
		dot.addComponent(ComponentType.PHYSICS, new PhysicsComponent(dot, 10f));
		dot.addComponent(ComponentType.COLLISION, new CollisionComponentRect(dot));
		dot.initComponents();
		entityManager.add(dot);
		System.out.println(dot.getHeight());
		System.out.println(dot.getWidth());
		System.out.println(dot2.getHeight());
		System.out.println(dot2.getWidth());
		

		gc.setTargetFrameRate(60);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
				if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {
					System.exit(0);
				}
				
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
