package com.iridium.wizardquest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler
{
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public boolean up=false,down=false,right=false,left=false;
	
	public void tick()
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);
			temp.tick();
		}
		
	}
	public void render(Graphics g)
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);
			temp.render(g);
		}
		
	}
	public void loadLevel(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
        
		for(int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				int red=(pixel>>16)&0xff;
				int green=(pixel>>8)&0xff;
				int blue=(pixel)&0xff;
				
				
				if(red ==150 && green == 50  && blue == 0 )
					addObject(new 	Log(xx*32,yy*32,ID.Block,this));
				
				if(red ==255 && blue==255 && green == 255)
					addObject(new Wizard(xx*32,yy*32,ID.Player,this));
				
				if(red ==0 && green == 0  && blue == 255 )
					addObject(new Pond(xx*32,yy*32,ID.Pond,this));
				
				if(red ==0 && green == 255 && blue == 255)
					addObject(new Potion(xx*32,yy*32,ID.Potion,this));
				
				
				if(red ==255 && green == 255 && blue == 0)
					addObject(new Crystal(xx*32,yy*32,ID.Crystal,this));
				
				if(red ==160 &&  green==160 && blue == 160)
					addObject(new Pillar(xx*32,yy*32,ID.Block,this));
				
				if(red ==0 && green == 0  && blue == 255 )
					addObject(new Well(xx*32,yy*32,ID.Well,this));
				if(red ==255 && green == 0 && blue == 0)
					addObject(new Vampire(xx*32,yy*32,ID.Vampire,this));
				
			
				
				
			}
		}
		
	}
	
	public void loadCharacters(BufferedImage image)
	{
			int w=image.getWidth();
			int h=image.getHeight();
	        
			for(int xx=0;xx<w;xx++)
			{
				for(int yy=0;yy<h;yy++)
				{
					int pixel=image.getRGB(xx, yy);
					int red=(pixel>>16)&0xff;
					int green=(pixel>>8)&0xff;
					int blue=(pixel)&0xff;
					
					
					if(red ==255 && blue==255 && green == 255)
						addObject(new Wizard(xx*32,yy*32,ID.Player,this));
					if(red ==255 && blue==0 && green == 0)
						addObject(new Vampire(xx*32,yy*64,ID.Vampire,this));
					
				}
			}
		
	}
	public void loadTress(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
        
		for(int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				int red=(pixel>>16)&0xff;
				int green=(pixel>>8)&0xff;
				int blue=(pixel)&0xff;
				
				if(red ==0 && green == 255 && blue == 0)
					addObject(new Tree(xx*32-30,yy*32-80,ID.Tree,this));
				
			}
		}
	}
	public void clearLevel()
	{
		object.clear();
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void addObject(GameObject myObject)
	{
		object.add(myObject);
	}
	public void removeObject(GameObject myObject)
	{
		object.remove(myObject);
	}

}
