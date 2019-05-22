package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Log extends GameObject
{
	
	private Textures tex;
	
	public Log(int x, int y, ID id,Handler handler) {
		
		super(x, y, id,handler);
		tex = Game.getInstance();
		
	}
	public void tick() {
		
		
	}

	
	public void render(Graphics g)
	{	
		g.drawImage(tex.log, x, y, null);
	
	}

	
	public Rectangle getBounds() 
	{
			return new Rectangle(x,y,64,32);
	}
	

}
