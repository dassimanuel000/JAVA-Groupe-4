package controllergrp4;

import java.awt.Image;
import java.util.ArrayList;

import contractgrp4.ControllerOrderGRP4;
import contractgrp4.IControllerGRP4;
import contractgrp4.IModelGRP4;
import contractgrp4.IViewGRP4;
import entitygrp4.AirGRP4;
import entitygrp4.DiamondGRP4;
import entitygrp4.DoorGRP4;
import entitygrp4.EntityGRP4;

/**
 * The Class ControllerGRP4.
 * @author GRP4
 */
public final class ControllerGRP4 implements IControllerGRP4 {

	/** The view. */
	private IViewGRP4 view;

	/** The model. */
	private IModelGRP4 model;
/**
 * instantiate the new array list with all the threads
 */
	ArrayList<Thread> threadList = new ArrayList<Thread>();

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public ControllerGRP4(final IViewGRP4 view, final IModelGRP4 model) {
		this.setViewGRP4(view);
		this.setModelGRP4(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Press '\n 1 for level ONE', '\n 2 for level TWO', '\n 3 for level ThREE', '\n 4 for level FOUR' or '\n 5 for level FIVE' \nthe different levels");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setViewGRP4(final IViewGRP4 pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModelGRP4(final IModelGRP4 model) {
		this.model = model;
	}

	public IModelGRP4 getModelGRP4() {
		return this.model;
	}
/**
 * Check if the thread is already launched. If not launched, it launch it.
 */
	private void threadCreation() {
		if (threadList.isEmpty()) {
			BoulderThreadGRP4 thread = new BoulderThreadGRP4("thread", view, model);
			threadList.add(thread);
			threadList.get(0).start();
		}
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrderGRP4 controllerOrder) {
		switch (controllerOrder) {
		case map1:
			this.model.loadMap(1);
			threadCreation();
			break;
		case map2:
			this.model.loadMap(2);
			threadCreation();
			break;
		case map3:
			this.model.loadMap(3);
			threadCreation();
			break;
		case map4:
			this.model.loadMap(4);
			threadCreation();
			break;
		case map5:
			this.model.loadMap(5);
			threadCreation();
			break;
		default:
			break;
		}
	}

	public void movement(int KeyCode) {
		swap(model.getTabEntity(), model.getMap(), KeyCode);
		if (model.getCharacterGRP4().getNbDiamond() == 10) {
			DoorGRP4 door = new DoorGRP4(model.getDoorY(), model.getDoorX());
			model.setTabEntity(model.getDoorY(), model.getDoorX(), door);
			model.setMap(model.getDoorY(), model.getDoorX(), door.getSpritePath());
		}
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		return entity.getcanbedestroyed
 */
	private Boolean check(EntityGRP4 entity) {
		return entity.getCanBeDestroyed();
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		Check if there is a Diamond
 */
	private Boolean checkDiamond(EntityGRP4 entity) {
		if (entity instanceof DiamondGRP4) {
			return true;
		} else {
			return false;
		}
	}
/**
 * 
 * @param entity
 * 		The entity
 * @return
 * 		Check if the entity can be pushed
 */
	private Boolean checkPushed(EntityGRP4 entity) {

		return entity.getCanBePushed();
	}
/**
 * Intervert the player's position with the position of the entity where he wants to go to generate movement.
 * @param tabEntity
 * 		An array of entity
 * @param tabImage
 * 		An array of sprite
 * @param i
 * 		Get the keycode of the key
 */
	public void swap(EntityGRP4[][] tabEntity, Image[][] tabImage, int i) {
		EntityGRP4 entity;
		Image image;
		int y = model.getPosX();
		int x = model.getPosY();
		switch (i) {
		case 38:
			if (check(tabEntity[y - 1][x])) {
				entity = tabEntity[y][x];
				image = tabImage[y][x];
				if (tabEntity[y - 1][x] instanceof DiamondGRP4) {
					model.getCharacterGRP4().setNbDiamond(model.getCharacterGRP4().getNbDiamond() + 1);
				}
				AirGRP4 air = new AirGRP4(x, y);
				tabEntity[y][x] = air;
				tabEntity[y - 1][x] = entity;
				tabImage[y][x] = air.getSpritePath();
				tabImage[y - 1][x] = image;
				model.setPosX(-1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevelGRP4();
				if (level == 5) {
					view.printMessage("Go buy the DLC <3");
					view.close();
				} else {
					view.printMessage("You won the level " + level);
					model.loadMap(model.getLevelGRP4() + 1);
				}
			}
			break;
		case 40:
			if (check(tabEntity[y + 1][x])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y + 1][x])) {
					model.getCharacterGRP4().setNbDiamond(model.getCharacterGRP4().getNbDiamond() + 1);
				}
				AirGRP4 air = new AirGRP4(x, y);
				tabEntity[y][x] = air;
				tabEntity[y + 1][x] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y + 1][x] = image;
				model.setPosX(1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevelGRP4();
				if (level == 5) {
					view.printMessage("Go buy the DLC <3");
					view.close();
				} else {
					view.printMessage("You won the level " + level);
					model.loadMap(model.getLevelGRP4() + 1);
				}
			}
			break;
		case 39:
			if (check(tabEntity[y][x + 1])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y][x + 1])) {
					model.getCharacterGRP4().setNbDiamond(model.getCharacterGRP4().getNbDiamond() + 1);
				}
				AirGRP4 air = new AirGRP4(x, y);
				tabEntity[y][x] = air;
				tabEntity[y][x + 1] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y][x + 1] = image;
				model.setPosY(1);
			}
			if (checkPushed(tabEntity[y][x + 1])) {
				entity = tabEntity[y][x + 2];
				tabEntity[y][x + 2] = tabEntity[y][x + 1];
				tabEntity[y][x + 1] = tabEntity[y][x];
				tabEntity[y][x] = entity;
				image = tabImage[y][x + 2];
				tabImage[y][x + 2] = tabImage[y][x + 1];
				tabImage[y][x + 1] = tabImage[y][x];
				tabImage[y][x] = image;
				model.setPosY(1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevelGRP4();
				if (level == 5) {
					view.printMessage("Go buy the DLC <3");
					view.close();
				} else {
					view.printMessage("You won the level " + level);
					model.loadMap(model.getLevelGRP4() + 1);
				}
			}
			break;
		case 37:
			if (check(tabEntity[y][x - 1])) {
				entity = tabEntity[y][x];
				if (checkDiamond(tabEntity[y][x - 1])) {
					model.getCharacterGRP4().setNbDiamond(model.getCharacterGRP4().getNbDiamond() + 1);
				}
				AirGRP4 air = new AirGRP4(x, y);
				tabEntity[y][x] = air;
				tabEntity[y][x - 1] = entity;
				image = tabImage[y][x];
				tabImage[y][x] = air.getSpritePath();
				tabImage[y][x - 1] = image;
				model.setPosY(-1);
			}
			if (checkPushed(tabEntity[y][x - 1])) {
				entity = tabEntity[y][x - 2];
				tabEntity[y][x - 2] = tabEntity[y][x - 1];
				tabEntity[y][x - 1] = tabEntity[y][x];
				tabEntity[y][x] = entity;
				image = tabImage[y][x - 2];
				tabImage[y][x - 2] = tabImage[y][x - 1];
				tabImage[y][x - 1] = tabImage[y][x];
				tabImage[y][x] = image;
				model.setPosY(-1);
			}
			if (y == model.getDoorY() && x == model.getDoorX()) {
				int level = model.getLevelGRP4();
				if (level == 5) {
					view.printMessage("Go buy the DLC <3");
					view.close();
				} else {
					view.printMessage("You won the level " + level);
					model.loadMap(model.getLevelGRP4() + 1);
				}
			}
			break;
		default:
			break;
		}
		model.update();
	}
}
