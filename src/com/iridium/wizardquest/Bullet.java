package com.iridium.wizardquest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject
{
	private Handler handler;
	
	
	public Bullet(int x, int y, ID id, Handler handler,int mx,int my) {
		super(x, y, id, handler); 
		this.handler=handler;
		velX=(mx-x)/10;
		velY=(my-y)/10;
		
		
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId() == ID.Block)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.removeObject(this);
				}
			}
			if(temp.getId() == ID.Tree)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.removeObject(this);
				}
			}
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
		
		
	}	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,8,8);
	}

}
