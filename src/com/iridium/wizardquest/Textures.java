package com.iridium.wizardquest;

import java.awt.image.BufferedImage;

public class Textures 
{
	
	public BufferedImage tree = null;
	public BufferedImage log = null;
	public BufferedImage terrain = null;
	public BufferedImage floor = null;
	public BufferedImage intro = null;
	public BufferedImage end = null;
	public BufferedImage level = null;
	public BufferedImage crystal = null;
	public BufferedImage pillar = null;
	public BufferedImage well = null;
	public BufferedImage potion = null;
	public BufferedImage wizardSpriteImage = null;
	public BufferedImage vampireSpriteImage = null;
	public BufferedImage newGameBtn = null;
	public BufferedImage contBtn = null;
	public BufferedImage optionBtn = null;
	public BufferedImage exitBtn = null;
	
	public BufferedImage [] wizard = new BufferedImage[12];
	public BufferedImage [] vampire = new BufferedImage[12];
	
	private SpriteSheet terrainSprite;
	private SpriteSheet wizardSprite;
	private SpriteSheet vampireSprite;
	
	public Textures()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		wizardSpriteImage = loader.loadImage("/wizard_sprite.gif");
		vampireSpriteImage = loader.loadImage("/vampire_sprite.png");
		terrain  = loader.loadImage("/GameObjects.png");
		intro = loader.loadImage("/Intro.jpg");
		end = loader.loadImage("/end.png");
		level = loader.loadImage("/wizard_level.png");
		floor = loader.loadImage("/floor.png");
		newGameBtn = loader.loadImage("/newGameBtn.png");
		contBtn = loader.loadImage("/contBtn.png");
		optionBtn = loader.loadImage("/optionsBtn.png");
		exitBtn = loader.loadImage("/exitBtn.png");
		
		terrainSprite = new SpriteSheet(terrain);
		wizardSprite = new SpriteSheet(wizardSpriteImage);
		vampireSprite = new SpriteSheet(vampireSpriteImage);
				
		
		
		getTextures();
	}
	
	public void getTextures()
	{
		tree = terrainSprite.grabImage(1, 1, 64, 64);
		log = terrainSprite.grabImage(2, 3, 64, 32);
		crystal = terrainSprite.grabImage(3, 1, 32, 64);
		pillar = terrainSprite.grabImage(4, 1, 32, 64);
		well = terrainSprite.grabImage(5, 1, 64, 89);
		potion = terrainSprite.grabImage(1, 3, 32, 32);
		
		//wizard
		//facing left
		wizard[0] =wizardSprite.grabImage(1, 4, 16, 32);
		wizard[1] =wizardSprite.grabImage(2, 4, 16, 32);
		wizard[2] =wizardSprite.grabImage(3, 4, 16, 32);
		//facing right
		wizard[3] =wizardSprite.grabImage(1, 3, 16, 32);
		wizard[4] =wizardSprite.grabImage(2, 3, 16, 32);
		wizard[5] =wizardSprite.grabImage(3, 3, 16, 32);
		//facing up
		wizard[6] =wizardSprite.grabImage(1, 2, 16, 32);
		wizard[7] =wizardSprite.grabImage(2, 2, 16, 32);
		wizard[8] =wizardSprite.grabImage(3, 2, 16, 32);
		//facing down
		wizard[9] =wizardSprite.grabImage(1, 1, 16, 32);
		wizard[10] =wizardSprite.grabImage(2, 1, 16, 32);
		wizard[11] =wizardSprite.grabImage(3, 1, 16, 32);
		
		//vampire left
		vampire[0] = vampireSprite.grabImage(1, 3, 40, 64);
		vampire[1] = vampireSprite.grabImage(3, 3, 40, 64);
		vampire[2] = vampireSprite.grabImage(5, 3, 40, 64);
		
		//vampire right
	    vampire[3] = vampireSprite.grabImage(1, 5, 40, 64);
				vampire[4] = vampireSprite.grabImage(3, 5, 40, 64);
				vampire[5] = vampireSprite.grabImage(5, 5, 40, 64);
				
				//vampire up 
				vampire[6] = vampireSprite.grabImage(1, 7, 40, 64);
				vampire[7] = vampireSprite.grabImage(3, 7, 40, 64);
				vampire[8] = vampireSprite.grabImage(5, 7, 40, 64);
				//vampire down
				vampire[9] = vampireSprite.grabImage(1, 1, 40, 64);
				vampire[10] = vampireSprite.grabImage(3, 1, 40, 64);
				vampire[11] = vampireSprite.grabImage(5, 1, 40, 64);
	}
		
	
	
}
