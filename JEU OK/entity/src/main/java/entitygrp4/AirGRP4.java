package entitygrp4;

import java.io.IOException;

import javax.imageio.ImageIO;

public class AirGRP4 extends EntityGRP4{
	
	/**
	 * Constructor of the Void class initializes the parameters of the Void.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y

	 */
	public AirGRP4(int X, int Y) {
		this.canBeDestroyed = true;
		this.canBePushed = true;
		try {
			spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/air.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		this.posX = X;
		this.posY = Y;
	}
}
