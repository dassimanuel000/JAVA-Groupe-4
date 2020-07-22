package viewgrp4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contractgrp4.IControllerGRP4;
import contractgrp4.IModelGRP4;
import entitygrp4.EntityGRP4;

/**
 * The Class ViewFrameGRP4.
 *
 * @author Groupe 4
 */
class ViewFrameGRP4 extends JFrame implements KeyListener {

	EntityGRP4 entity;
	/** The model. */
	private IModelGRP4 model;

	/** The controller. */
	private IControllerGRP4 controller;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * 
	 */
	public ViewFrameGRP4(final IModelGRP4 model) {
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IControllerGRP4 getControllerGRP4() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setControllerGRP4(final IControllerGRP4 controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModelGRP4 getModelGRP4() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModelGRP4(final IModelGRP4 model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model the model
	 */
	private void buildViewFrame(final IModelGRP4 model) {
		this.setModelGRP4(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanelGRP4(this));
		this.setSize(41 * 16 + this.getInsets().left + this.getInsets().right,
				(int) (24 * 17.2 + this.getInsets().top + this.getInsets().bottom));
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.getControllerGRP4().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_DOWN:
			this.getControllerGRP4().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_RIGHT:
			this.getControllerGRP4().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_LEFT:
			this.getControllerGRP4().movement(e.getKeyCode());
			break;
		case KeyEvent.VK_A:
			this.getControllerGRP4().orderPerform(ViewGRP4.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_Z:
			this.getControllerGRP4().orderPerform(ViewGRP4.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_E:
			this.getControllerGRP4().orderPerform(ViewGRP4.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_R:
			this.getControllerGRP4().orderPerform(ViewGRP4.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		case KeyEvent.VK_T:
			this.getControllerGRP4().orderPerform(ViewGRP4.keyCodeToControllerOrder(e.getKeyCode()));
			break;
		default:
			break;
		}
	}
}
