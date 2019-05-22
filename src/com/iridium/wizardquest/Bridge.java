package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bridge extends GameObject
{

	private BufferedImage crate;
	private Textures tex;
	
	public Bridge(int x, int y, ID id, Handler handler) {
		
		super(x, y, id, handler);
		tex = Game.getInstance();
	//	crate=tex.ss.grabImage(1,1,32,32);
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(crate, x, y, null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	

}
