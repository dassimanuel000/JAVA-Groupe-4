package entitygrp4;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DirtGRP4 extends EntityGRP4{
	
	/**
	 * Constructor of the DirtGRP4 class initializes the parameters of the DirtGRP4.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	public DirtGRP4(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/dirt.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
