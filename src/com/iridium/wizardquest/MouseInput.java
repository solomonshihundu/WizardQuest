package com.iridium.wizardquest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter 
{
	private Handler handler;
	private Camera camera;
	private Game game;
	
	
	public MouseInput(Handler handler,Camera camera,Game game)
	{
		
		this.handler=handler;
		this.camera=camera;
		this.game=game;
		
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx=(int)(e.getX()+camera.getX());
		int my=(int)(e.getY()+camera.getY());
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId() == ID.Player && HUD.AMMO>0)
			{
				if(game.gameState == Game.STATE.game && !Game.paused)
				{
					
				AudioPlayer.getSound("9mmGun").play(1f,0.2f);
				handler.addObject(new Bullet(temp.getX()+24,temp.getY()+18,ID.Bullet,handler,mx,my));
				HUD.AMMO--;
					
				}
			}
		}
	}

}
