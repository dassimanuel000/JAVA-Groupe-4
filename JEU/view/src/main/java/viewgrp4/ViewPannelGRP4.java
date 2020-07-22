package viewgrp4;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * The Class ViewPanelGRP4.
 *
 * @author Groupe 4
 */
class ViewPanelGRP4 extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrameGRP4 viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanelGRP4(final ViewFrameGRP4 viewFrame) {
		this.setViewFrameGRP4(viewFrame);
		viewFrame.getModelGRP4().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrameGRP4 getViewFrameGRP4() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
		
	private void setViewFrameGRP4(final ViewFrameGRP4 viewFrame) {
		this.viewFrame = viewFrame;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics graphics) {
		int Y = 20;
		if(this.getViewFrameGRP4().getModelGRP4().getTabLine(0,0) == null) {
			viewFrame.setTitle("MENU");
			try {
			      Image img = ImageIO.read(getClass().getResource("/images/menu.png"));
			      graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}else {
			viewFrame.setTitle("Level " + this.getViewFrameGRP4().getModelGRP4().getLevelGRP4() + "                     Number of diamond(s) : "+this.getViewFrameGRP4().getModelGRP4().getCharacterGRP4().getNbDiamond());
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			for(int i = 0; i < 22; i++) {
				for(int j = 0; j < 40; j++) {
					graphics.drawImage(this.getViewFrameGRP4().getModelGRP4().getMap(i, j), (j*16), Y, this);
				}
				Y += 16;
			}
		}
	}
}
