package entitygrp4;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DoorGRP4 extends EntityGRP4{
	/**
	 * Constructor of the DiamondGRP4 class initializes the parameters of the Diamond.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	
	public DoorGRP4(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = false;
		try {
			this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/exit.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
}
