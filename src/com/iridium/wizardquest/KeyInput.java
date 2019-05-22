package com.iridium.wizardquest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter
{
	private Handler handler;
	private Game game;
	
	public KeyInput(Handler handler,Game game)
	{
		this.handler=handler;
		this.game=game;
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Player)
			{
				if(key==KeyEvent.VK_W){handler.setUp(true);}
				if(key==KeyEvent.VK_S){handler.setDown(true);}
				if(key==KeyEvent.VK_A){handler.setLeft(true);}
				if(key==KeyEvent.VK_D){handler.setRight(true);}
			}
		}
		if(key==KeyEvent.VK_SPACE)
		{	

			AudioPlayer.getSound("menuSound").play();
			if(game.gameState == Game.STATE.game)
			{
			if(Game.paused)
			{
				Game.paused=false;
			}
			else Game.paused=true;
		    }
		
		}
		if(key == KeyEvent.VK_ESCAPE)
		{
			game.gameState= Game.STATE.menu;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Player)
			{
				if(key==KeyEvent.VK_W){handler.setUp(false);}
				if(key==KeyEvent.VK_S){handler.setDown(false);}
				if(key==KeyEvent.VK_A){handler.setLeft(false);}
				if(key==KeyEvent.VK_D){handler.setRight(false);}
			}
		}
		
	}

}
