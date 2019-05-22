package com.iridium.wizardquest;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image)
	{
		this.image=image;
	}
	public BufferedImage  grabImage(int col,int row,int width,int height)
	{
		return image.getSubimage((col*32)-32, (row*32)-32, width, height);
	}
	public BufferedImage  grabImage(int col,int row,int width,int height,boolean nothing,boolean non)
	{
		return image.getSubimage((col*32)-32, (row*64)-64, width, height);
	}
	public BufferedImage  grabImage(int col,int row,int width,int height,boolean nothing)
	{
		return image.getSubimage((col*200)-200, (row*50)-50, width, height);
	}
	
}
