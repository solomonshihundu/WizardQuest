package com.iridium.wizardquest;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class AudioPlayer 
{
	public static Map<String,Sound> soundMap=new HashMap<String,Sound>();
	public static Map<String,Music> musicMap=new HashMap<String,Music>();
	
	public static void load()
	{
		try {
			soundMap.put("menuSound",new Sound("res/buttonsound.ogg"));
			soundMap.put("9mmGun",new Sound("res/fireball.ogg"));
			musicMap.put("music",new Music("res/The Orphanage.ogg"));
			
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static Sound getSound(String key)
	{
		return soundMap.get(key);
	}
	public static Music getMusic(String key)
	{
		return musicMap.get(key);
	}

}
