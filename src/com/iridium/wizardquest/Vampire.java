package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Vampire extends GameObject
{
	private Handler handler;
	private Random r=new Random();
	private int choose=0;
	private int hp=100;
	
	private Animation animUp;
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	
	int scopeX = 500;
	int scopeY = 500;
	
	private Textures tex;
	public Vampire(int x, int y, ID id, Handler handler) {
		
		super(x, y, id, handler);
		this.handler=handler;
		tex = Game.getInstance();
		
      	animRight=new Animation(5,tex.vampire[3],tex.vampire[4],tex.vampire[5]);
      	animLeft=new Animation(5,tex.vampire[0],tex.vampire[1],tex.vampire[2]);
      	animDown=new Animation(5,tex.vampire[9],tex.vampire[10],tex.vampire[11]);
      	animUp=new Animation(5,tex.vampire[6],tex.vampire[7],tex.vampire[8]);
      	
  //    	System.out.print(scopeX+""+scopeY);

	}

	
	public void tick() 
	{
		
		x+=velX;
		y+=velY;
		
		velX = 0;
		velY = 0;
		
		if(x<0||x>Game.WIDTH-30)velX*=-1;
		if(y<0||y>Game.HEIGHT-30)velY*=-1;
		
		choose=r.nextInt(1000);
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			
			/*
			 * collision bounds with bullet to 
			 * reduce health index of vampire till death
			 */
			if(temp.getId() == ID.Bullet)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
				hp-=20;
				handler.removeObject(temp);
			    }
				
			}
			/*
			 * collision bounds with player to prompt enemy to go 
			 * and attack player
			 */
			if(temp.getId() == ID.Player)
			{
				if(getBoundsBig().intersects(temp.getBounds()))
				{
					
					float diffX=x-temp.getX()-16;
					float diffY=y-temp.getY()-16;
					float distance=(float)Math.sqrt(Math.pow((x-temp.getX()),2)+Math.pow((y-temp.getY()), 2));
					
	     			velX=((-1/distance)*diffX);
		    		velY=((-1/distance)*diffY);
					
					setBoundsBig(1000,1000);
					System.out.print(scopeX+"   "+scopeY);
				
				}
					
			}
			else if(choose == 0)
			{
		   // 	 velX=(r.nextInt(5 - -5)+ -5);
		   // 	  	velY=(r.nextInt(5 - -5)+ -5);
			}
		}
		if(hp<=0)
		{
			handler.removeObject(this);
		}
		
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

	
	public void render(Graphics g) 
	{
		
		if(velX == 0 && velY == 0)
		{
			g.drawImage(tex.vampire[4], x, y, null);
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
		/*
		
		if(seen)
		{
		g.setColor(Color.blue);
		g.drawRect(x-650, y-500, scopeX, scopeY);
		}
		else
			g.setColor(Color.blue);
		g.drawRect(x-300, y-200, scopeX, scopeY);
		*/
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,32,64);
	}
	public Rectangle getBoundsBig()
	{
		return new Rectangle(x-650,y-500,scopeX,scopeY);
	}
	public void setBoundsBig(int varX,int varY)
	{
		scopeX = varX;
		scopeY = varY;
	}
	
	
	

}
