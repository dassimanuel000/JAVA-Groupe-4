package controllergrp4;

import java.awt.Image;

import contractgrp4.IModelGRP4;
import contractgrp4.IViewGRP4;
import entitygrp4.AirGRP4;
import entitygrp4.BoulderGRP4;
import entitygrp4.DiamondGRP4;
import entitygrp4.EntityGRP4;
import entitygrp4.CharacterGRP4;

	/**
	 * 
	 * @author Groupe 4
	 *
	 */

public class BoulderThreadGRP4 extends Thread {
	/** The View */
	IViewGRP4 view;
	/** The Model */
	IModelGRP4 model;

	/** Contains the position X and Y of the Boulder */
	int[][] tabBoulder = new int[2][210];
	/** The Entity Array */
	EntityGRP4[][] tabEntity;
	/** The Sprite Array */
	Image[][] tabMap;

	/** The Boulder */
	BoulderGRP4 boulder;
	/** The Diamond */
	DiamondGRP4 diamond;

	/**
	 * Instantiates a new BoulderThread
	 * 
	 * @param name  The name of the Thread
	 * @param view  The View
	 * @param model The Model
	 */
	public BoulderThreadGRP4(String name, IViewGRP4 view, IModelGRP4 model) {
		super(name);
		this.view = view;
		this.model = model;
	}

	/**
	 * Automatically executed at the beginning of the Thread, Execute the function
	 * fall() every 100 Ms
	 */
	public void run() {
		while (true)
			try {
				this.fall();
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * Swap is used to make boulders falls
	 * 
	 * @param i The boulder's X position before the swap
	 * @param j The boulder's Y position before the swap
	 */
	public void swap(int i, int j) {
		EntityGRP4 entity;
		entity = tabEntity[j][i];
		tabEntity[j][i] = tabEntity[j + 1][i];
		tabEntity[j + 1][i] = entity;
		Image image;
		image = tabMap[j][i];
		tabMap[j][i] = tabMap[j + 1][i];
		tabMap[j + 1][i] = image;
		model.update();
	}

	/**
	 * Load the position X and Y of all the boulders in the TabEntity
	 * 
	 * @return An array with all the boulders' X and Y position
	 */
	public int[][] definition() {
		this.tabEntity = model.getTabEntity();
		this.tabMap = model.getMap();
		int k = 0;
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 40; j++) {
				if (tabEntity[i][j] instanceof BoulderGRP4 || tabEntity[i][j] instanceof DiamondGRP4) {
					tabBoulder[0][k] = j;
					tabBoulder[1][k] = i;
					k++;
					tabEntity[i][j].setFalling(false);
					tabEntity[i][j].setCanBePushed(false);
				}
			}
		}
		return tabBoulder;
	}

	/**
	 * Check if the Boulders/Dimaonds can fall, if the player is under the boulder
	 * or diamond, if the boulder can be pushed and reload the Level if the player
	 * dies.
	 */
	public void fall() {
		tabBoulder = definition();
		int j = 0;
		for (j = 0; j < 210; j++) {
			if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof AirGRP4
					|| tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof CharacterGRP4) {
				if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]] instanceof AirGRP4) {
					swap(tabBoulder[0][j], tabBoulder[1][j]);
					tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]].setFalling(true);
					if (tabEntity[tabBoulder[1][j] + 1][tabBoulder[0][j]].getFalling()
							&& tabEntity[tabBoulder[1][j] + 2][tabBoulder[0][j]] instanceof CharacterGRP4) {
						view.printMessage("              Game Over\n                Try Again");
						model.loadMap(model.getLevelGRP4());
					}
				}
			}
			if (tabBoulder[0][j] != 0 && tabEntity[tabBoulder[1][j]][tabBoulder[0][j]] instanceof BoulderGRP4) {
				if (tabEntity[tabBoulder[1][j]][tabBoulder[0][j] - 1] instanceof AirGRP4
						|| tabEntity[tabBoulder[1][j]][tabBoulder[0][j] + 1] instanceof AirGRP4) {
					tabEntity[tabBoulder[1][j]][tabBoulder[0][j]].setCanBePushed(true);
				}
			}
		}
	}
}
