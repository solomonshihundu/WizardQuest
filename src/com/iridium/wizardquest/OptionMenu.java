package com.iridium.wizardquest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionMenu extends MouseAdapter 
{
	private Game game;
	private Textures tex;

	public  OptionMenu(Game game)
	{
		this.game=game;
		tex = Game.getInstance();
	
	}
	public void mousePressed(MouseEvent e)
	{
		int mx =e.getX();
		int my =e.getY();
		
		if(game.gameState == Game.STATE.menu)
		{
		if(mouseOver(mx,my,400,324,200,50))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState= Game.STATE.help;	
		}
		}
		else if(game.gameState == Game.STATE.help)
		{
		//back from help
		if(mouseOver(mx,my,825,470,150,40))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState= Game.STATE.menu;
				
		}
		}
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000,563);
	//	g.drawImage(tex.option_image, 0, 0, null);
		g.setColor(Color.cyan);
		g.setFont(new Font("Algerian",Font.BOLD,40));
		g.drawString("HELP",450,75);
		g.setFont(new Font("TimesNewRoman",Font.ITALIC,20));
		g.drawString("-> Use arrow keys to move player",80,120);
		g.setFont(new Font("Algerian",Font.PLAIN,30));
		g.drawRect(825,470,150,40);
		g.drawString("BACK",860, 500);
		
	}
	public void tick()
	{
		
	}
	
	public boolean mouseOver(int mx,int my,int x,int y,int width,int height)
	{
		if(mx>x&&mx<x+width)
		{
			if(my>y&&my<y+height)
			{
				return true;
			}
			else return false;
		}
		else return false;
		
	}

}
