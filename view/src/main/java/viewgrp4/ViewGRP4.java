package viewgrp4;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

//import contractgrp4.ControllerOrderGRP4;
import contractgrp4.ControllerOrderGRP4;
import contractgrp4.IControllerGRP4;
import contractgrp4.IModelGRP4;
import contractgrp4.IViewGRP4;

/**
 * The Class View.
 *
 * @author Groupe 4
 */
public final class ViewGRP4 implements IViewGRP4, Runnable {

	/** The frame. */
	private final ViewFrameGRP4 viewFrame;
	

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public ViewGRP4(final IModelGRP4 model) {
		this.viewFrame = new ViewFrameGRP4(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrderGRP4 keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_A:
				return ControllerOrderGRP4.map1;
			case KeyEvent.VK_Z:
				return ControllerOrderGRP4.map2;
			case KeyEvent.VK_E:
				return ControllerOrderGRP4.map3;
			case KeyEvent.VK_R:
				return ControllerOrderGRP4.map4;
			case KeyEvent.VK_T:
				return ControllerOrderGRP4.map5;
				default:				
				return null;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}


	public void run() {
		this.viewFrame.setVisible(true);
	}
	
	public void close() {
		this.viewFrame.dispose();
		System.exit(0);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IControllerGRP4 controller) {
		this.viewFrame.setControllerGRP4(controller);
	}
}
