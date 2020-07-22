package contractgrp4;

import java.awt.Image;

import entitygrp4.EntityGRP4;

/**
 * The Interface IControllerGRP4.
 *
 * @author Groupe 4
 */
public interface IControllerGRP4 {

	/**
	 * ControlGRP4
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	
	public void orderPerform(ControllerOrderGRP4 controllerOrder);
	
	//public void swap(Entity[][] tabEntity, Image[][] tabImage, int i);
	
	/**
	 * Initiate the movement and create the exit door
	 * 
	 * @param KeyCode
	 * 			The code of the Keypressed
	 */
	
	public void movement(int KeyCode);
	
	/**
	 * 
	 * @return
	 * 		The current model
	 */
	public IModelGRP4 getModelGRP4();
}
