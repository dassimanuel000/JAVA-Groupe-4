package entitygrp4;

import java.io.IOException;

import javax.imageio.ImageIO;

public class WallGRP4 extends EntityGRP4{
	/**
	 * Constructor of the Wall class initializes the parameters of the Level's Wall.
	 * 
	 *  @param X 
	 *  	Used to initializes the position X
	 *  @param Y
	 *  	Used to initializes the position Y
	 */
		public WallGRP4(int X, int Y) {
		this.canBeDestroyed = false;
		this.canBePushed = false;
		try {
			spritePath = ImageIO.read(getClass().getResource("/SpriteEntity/wall.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		this.posX = X;
		this.posY = Y;
	}
		
}
