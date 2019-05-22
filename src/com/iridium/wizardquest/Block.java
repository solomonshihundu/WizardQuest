package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject
{
	
	private Textures tex;
	int type = 0;
	
	public Block(int x, int y, ID id,Handler handler,int type) {
		
		super(x, y, id,handler);
		tex = Game.getInstance();
		this.type = type;
	}
	public void tick() {
		
		
	}

	
	public void render(Graphics g)
	{	
		g.drawImage(tex.log, x, y, null);
	
	}

	
	public Rectangle getBounds() 
	{
		if(type == 11)
		{
		return new Rectangle(x,y,32,96);
		}
		else if(type == 10)
		{
			return new Rectangle(x,y,64,32);
		}
		else 
			return new Rectangle(x,y,32,32);
	}
	

}
