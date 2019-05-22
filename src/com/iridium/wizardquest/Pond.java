package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Pond extends GameObject
{
	private Textures tex;
	
	public Pond(int x, int y, ID id, Handler handler) {
		
		super(x, y, id, handler);
		tex = Game.getInstance();

	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(tex.well, x, y, null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x+20,y,60,80);
	}
	

}
