package com.iridium.wizardquest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter implements Runnable
{
	private Game game;
	private HUD hud;
	private Textures tex;
	public Handler handler;
	
	
	public Menu(Game game,HUD hud,Handler handler)
	{
		tex = Game.getInstance();
		this.game=game;
		this.hud=hud;
		this.handler=handler;
	  
	}
	public void run()
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		int mx=e.getX();
		int my=e.getY();
		
		
		
		if(game.gameState== Game.STATE.menu)
		{
		//play
		if(mouseOver(mx,my,380,100, 266, 56))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState= Game.STATE.game;
					
		}
		
		//continue
		if(mouseOver(mx,my,380,200, 266, 56))
		{
			AudioPlayer.getSound("menuSound").play();
		//	game.gameState= Game.STATE.game;
							
		}
		
		//options
		if(mouseOver(mx,my,380,300, 266, 56))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState= Game.STATE.help;
			
			
		}
		
		//quit
		if(mouseOver(mx,my,380,400, 266, 56))
		{
			AudioPlayer.getSound("menuSound").play();
			System.exit(0);
			
		}
	
		}

		else if(game.gameState== Game.STATE.end)
		{
		//try again
		if(mouseOver(mx,my,400,454,200,50))
		{
			handler.clearLevel();
			handler.loadLevel(tex.level);
			AudioPlayer.getSound("menuSound").play();
			game.gameState=Game.STATE.game;
			game.reset();
			
		}
		}

	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void render(Graphics g)
	{
	    
		if(game.gameState == Game.STATE.menu)
		{
			
		
		g.drawImage(tex.intro, 0, 0, null);
	//	g.drawImage(tex.title_image,250,40, null);
		
		
		g.drawImage(tex.newGameBtn, 380,100, null);
		g.drawImage(tex.contBtn,380, 200, null);
		g.drawImage(tex.optionBtn, 380,300, null);	
		g.drawImage(tex.exitBtn, 380,400, null);
		
		
		}
		
		
		else if(game.gameState == Game.STATE.end)
		{
			g.drawImage(tex.end, 0, 0, null);
			g.setColor(Color.RED);
			g.setFont(new Font("Algerian",Font.BOLD,40));
			g.drawString("GAME OVER",385,75);
			g.setFont(new Font("TimesNewRoman",Font.ITALIC,20));
			g.drawString("YOU LOST !!!",440,175);
			g.drawString("Points : "+hud.getPoints(),465,220);
			
			g.drawRect(400,454,200,50);
			g.drawString("Try Again",450, 485);

		}
		
		
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
