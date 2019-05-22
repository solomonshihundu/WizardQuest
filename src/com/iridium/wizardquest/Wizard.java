package com.iridium.wizardquest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject
{
    private Handler handler;
    public Game game;

    
    private Animation animRight;
    private Animation animLeft;
    private Animation animUp;
    private Animation animDown;
    
    private Textures tex;
    
	public Wizard(int x, int y, ID id, Handler handler) 
	{
		
		super(x, y, id,handler);
		this.handler=handler;

		tex = Game.getInstance();
		
		animRight = new Animation(3,tex.wizard[3],tex.wizard[4],tex.wizard[5]);
		animLeft = new Animation(3,tex.wizard[0],tex.wizard[1],tex.wizard[2]);
		animUp = new Animation(3,tex.wizard[6],tex.wizard[7],tex.wizard[8]);
		animDown = new Animation(3,tex.wizard[9],tex.wizard[10],tex.wizard[11]);
	}

	
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		collision();
		
		if(handler.isUp()){velY=-2;}
		else if(!handler.isDown()){velY=0;}
		
		if(handler.isDown()){velY=2;}
		else if(!handler.isUp()){velY=0;}
		
		if(handler.isLeft()){velX=-2;}
		else if(!handler.isRight()){velX=0;}
		
		if(handler.isRight()){velX=2;}
		else if(!handler.isLeft()){velX=0;}
		
		if(velX > 0)
		{
		animRight.runAnimation();
		}
		else if(velX < 0)
		{
		animLeft.runAnimation();
		}
		else if(velY > 0)
		{
		animDown.runAnimation();
		}
		else if(velY < 0)
		{
		animUp.runAnimation();
		}
	}

	
	private void collision()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			
			if(temp.getId() == ID.Block || temp.getId() == ID.Tree || temp.getId() == ID.Pond || temp.getId() == ID.Well)
			{
			   if(getBounds().intersects(temp.getBounds()))
			   {
				  x+=velX*-1;
				  y+=velY*-1;
				 
			   }
			}
			if(temp.getId() == ID.Potion)
			{
			   if(getBounds().intersects(temp.getBounds()))
			   {
				 handler.removeObject(temp);
				 HUD.AMMO+=10;
				
			   }
			}
			if(temp.getId() == ID.Vampire )
			{
			   if(getBounds().intersects(temp.getBounds()))
			   {
				 
				 HUD.HEALTH--;
				
			   }
			}
			if(temp.getId() == ID.Crystal)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.level++;
					
				}
			}
		}
	}

    public void render(Graphics g)
    {
    	if(velX == 0 && velY == 0)
		{
			g.drawImage(tex.wizard[4], x, y, null);
		}
		else if(velX > 0)
		{
			animRight.drawAnimation(g, x, y, 0);
		}
		else if(velX < 0)
		{
			animLeft.drawAnimation(g, x, y, 0);
		}
		else if(velY > 0)
		{
			animDown.drawAnimation(g, x, y, 0);
		}
		else if(velY < 0)
		{
			animUp.drawAnimation(g, x, y, 0);
		}
    	
  //  	g.setColor(Color.yellow);
  //  	g.drawRect(x+2,y+5,12,25);
    		
	}

	public Rectangle getBounds() 
	{
		
		return new Rectangle(x+2,y+5,12,25);
	}
	

}
