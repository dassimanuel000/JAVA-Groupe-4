package modelgrp4;

import java.awt.Image;
import java.sql.SQLException;
import java.util.Observable;

import contractgrp4.IModelGRP4;
import entitygrp4.AirGRP4;
import entitygrp4.BoulderGRP4;
import entitygrp4.CharacterGRP4;
import entitygrp4.DiamondGRP4;
import entitygrp4.DirtGRP4;
import entitygrp4.DoorGRP4;
import entitygrp4.EntityGRP4;
import entitygrp4.WallGRP4;

/**
 * The Class Model.
 *
 * @author Groupe 4
 */
public final class ModelGRP4 extends Observable implements IModelGRP4 {

	/** The Wall */
	WallGRP4 wall;
	/** The Dirt */
	DirtGRP4 dirt;
	/** The Boulder */
	BoulderGRP4 boulder;
	/** The Diamond */
	DiamondGRP4 diamond;
	/** The Air */
	AirGRP4 air;
	/** The Character */
	CharacterGRP4 character;
	/** The Door */
	DoorGRP4 door;

	/**
	 * Contains the line currently read in the database
	 */
	private String[] TabLine = new String[22];
	/**
	 * Contains each character of the TabLine's line
	 */
	private String[] TabLine2 = new String[40];
	/**
	 * Contains the entire Map
	 */
	private String[][] TabMap = new String[22][40];
	/**
	 * Contains each entity of the Map
	 */
	private EntityGRP4[][] TabEntity = new EntityGRP4[22][40];
	/**
	 * Contains each sprite of the Map
	 */
	private Image[][] Map = new Image[22][40];
	/**
	 * Contains the level
	 */
	int level = 0;
	/**
	 * Contains the X position of the Door
	 */
	int DoorX;
	/**
	 * Contains the Y position of the Door
	 */
	int DoorY;

	/**
	 * Instantiates a new model.
	 */

	public ModelGRP4() {
	}

	public String getTabLine(int i, int j) {
		return TabMap[i][j];
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public void loadMap(int map) {
		setLevelGRP4(map);
		try {
			final DAOMapGRP4 daoLine = new DAOMapGRP4(DBConnectionGRP4.getInstance().getConnection());
			for (int i = 0; i < 22; i++) {
				TabLine[i] = daoLine.find(i + 1, map);
			}
			splitTab(TabLine);
			instanceObject(TabMap);
			System.out.println(TabEntity[19][8]);
			System.out.println(TabEntity[20][8]);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		update();
	}

	public int getLevelGRP4() {
		return level;
	}

	/**
	 * Set the Level
	 * 
	 * @param level
	 * 		The level
	 */
	public void setLevelGRP4(int level) {
		this.level = level;
	}

	public int getPosX() {
		return character.posX;
	}

	public int getPosY() {
		return character.posY;
	}

	public void setPosX(int i) {
		character.posX = character.posX + i;
	}

	public void setPosY(int i) {
		character.posY = character.posY + i;
	}

	public CharacterGRP4 getCharacterGRP4() {
		return character;
	}

	public int getDoorX() {
		return DoorX;
	}

	public int getDoorY() {
		return DoorY;
	}

	/**
	 * instanceObject
	 * 
	 * The function instanceObject instance Object and load the Image in the array
	 * Map[][].
	 * 
	 * @param tabMap The parameter tabMap is used to create Object depending on the
	 *               letter it contains.
	 * 
	 */

	public void instanceObject(String[][] tabMap) {
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 40; j++) {
				switch (tabMap[i][j]) {
				case "M":
					this.wall = new WallGRP4(i, j);
					TabEntity[i][j] = this.wall;
					Map[i][j] = this.wall.getSpritePath();
					break;
				case "T":
					this.dirt = new DirtGRP4(i, j);
					TabEntity[i][j] = this.dirt;
					Map[i][j] = this.dirt.getSpritePath();
					break;
				case "D":
					this.diamond = new DiamondGRP4(i, j);
					TabEntity[i][j] = this.diamond;
					Map[i][j] = this.diamond.getSpritePath();
					break;
				case "C":
					this.boulder = new BoulderGRP4(i, j);
					TabEntity[i][j] = this.boulder;
					Map[i][j] = this.boulder.getSpritePath();
					break;
				case "E":
					this.wall = new WallGRP4(i, j);
					TabEntity[i][j] = this.wall;
					Map[i][j] = this.wall.getSpritePath();
					DoorX = j;
					DoorY = i;
					break;
				case "P":
					this.character = new CharacterGRP4(i, j);
					TabEntity[i][j] = this.character;
					Map[i][j] = this.character.getSpritePath();
					break;
				case "A":
					this.air = new AirGRP4(i, j);
					TabEntity[i][j] = this.air;
					Map[i][j] = this.air.getSpritePath();
					break;
				default:
					System.out.println("Error");
					break;
				}
			}
		}
	}

	public Image getMap(int i, int j) {
		return Map[i][j];
	}

	public void setMap(int i, int j, Image image) {
		Map[i][j] = image;
	}

	public EntityGRP4[][] getTabEntity() {
		return TabEntity;
	}

	public void setTabEntity(int i, int j, EntityGRP4 entity) {
		TabEntity[i][j] = entity;
	}

	public Image[][] getMap() {
		return Map;
	}

	/**
	 * Split the String in the array TabLine
	 * 
	 * @param tab The array TabLine
	 */
	public void splitTab(String[] tab) {
		String a;
		for(int i= 0; i<22; i++) {
			System.out.println(tab[i]);
		}
		for (int i = 0; i < 22; i++) {
			a = tab[i];
			TabLine2 = a.split("");
			for (int j = 0; j < 40; j++) {
				TabMap[i][j] = TabLine2[j];
			}
		}
	}

	public Observable getObservable() {
		return this;
	}
}
