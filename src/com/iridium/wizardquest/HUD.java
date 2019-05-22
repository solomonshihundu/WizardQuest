package com.iridium.wizardquest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD
{
	public static int HEALTH=100;
	public static int AMMO=100;
	public int points=0;
	public static int level=1;
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 20);
		g.setColor(Color.green);
		g.fillRect(15, 15, (int)Game.clamp(HEALTH*2,0,200), 20);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 20);
		
		if(AMMO > 0)
		{
		g.setColor(Color.gray);
		g.fillRect(240, 15, 200, 20);
		g.setColor(Color.yellow);
		g.fillRect(240, 15, (int)Game.clamp(AMMO*2,0,200), 20);
		g.setColor(Color.white);
		g.drawRect(240, 15, 200, 20);
		}
		g.setColor(new Color(205,200,29));
		g.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		g.drawString("Level : "+getLevel(), 15, 55);
		g.drawString("Points : "+getPoints(), 105,55);
		
	}
	public void tick()
	{
		
		
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
	      HUD.level = level;
	}

}
