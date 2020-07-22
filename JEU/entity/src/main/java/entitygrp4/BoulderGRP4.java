package entitygrp4;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BoulderGRP4 extends EntityGRP4{
	
//	public int getBoulderX() {
	//	return posX;
//	}
	
	//public int getBoulderY() {
	//	return posY;
	//}
	
	/**
	 * Constructor of the Boulder class initializes the parameters of the Boulder.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y
	 */
	public BoulderGRP4(int X, int Y) {
		this.canBeDestroyed = false;
		this.canBePushed = false;
		try {
		this.spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/rock.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		this.posX = X;
		this.posY = Y;
	}
}
