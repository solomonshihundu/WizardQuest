package com.iridium.wizardquest;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = 4071614220394955473L;
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	private HUD hud;
	private Camera camera;
	private OptionMenu options;
	public int ammo=100;
	public static boolean paused=false;
	private Menu menu;
	private static Textures tex;
	public enum STATE
	{
		menu,game,end,help,shop
	};
	public STATE gameState=STATE.menu;
	
	public Game()
	{
		AudioPlayer.load();		
		handler=new Handler();
		hud=new HUD();
		tex = new Textures();
		camera=new Camera(0,0);
		this.addKeyListener(new KeyInput(handler,this));	
	    
		
		options= new OptionMenu(this);
		menu=new Menu(this,hud,handler);
		
		this.addMouseListener(menu);	
		this.addMouseListener(new MouseInput(handler,camera,this));
		this.addMouseListener(options);
		
			
		
		
	    handler.loadLevel(tex.level);
	    handler.loadCharacters(tex.level);
	    handler.loadTress(tex.level);
	
		AudioPlayer.getMusic("music").loop(1f,0.2f);
		new Window(1000,563,"Wizard Quest",this);
		start();
		
		
		
	}
	
	public synchronized void start()
	{
		
		thread=new Thread(this);
		thread.start();
	
		running=true;
		
		if(thread.isAlive())
		{
			System.out.println("This thread is in use");
		}
		else{
			System.out.println("Thread is disjointed");
		}
		
	}
	public synchronized void stop()
	{
		
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		running=false;
		
	}
	public void run()
	{
		this.requestFocus();

		long initialTime = System.nanoTime();
		final double timeU = 1000000000 / 60;
		final double timeF = 1000000000 / 60;
		double deltaU = 0, deltaF = 0;
		long timer = System.currentTimeMillis();
		
		    while (running) {
		
		        long currentTime = System.nanoTime();
		        deltaU += (currentTime - initialTime) / timeU;
		        deltaF += (currentTime - initialTime) / timeF;
		        initialTime = currentTime;
		
		        if (deltaU >= 1) {
		            tick();
		            
		            deltaU--;
		        }
		
		        if (deltaF >= 1) {
		            render();
		            
		            deltaF--;
		        }
		
		        if (System.currentTimeMillis() - timer > 1000) {
		            timer += 1000;
		        }
		    }
		    
		    stop();
		
	}
	public void tick()
	{
		
		if(gameState == STATE.game)
		{
			if(!paused)
			{
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId() == ID.Player)
			{
				camera.tick(handler.object.get(i));
			}
		}
		handler.tick();
		}
		}
		if(HUD.HEALTH<=0)
		{
			gameState = STATE.end;
		}
		
		
	}
	public void render()
	{
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		Graphics2D g2d=(Graphics2D)g; 

		if(gameState == STATE.game)
		{
			
		g2d.translate(-camera.getX(), -camera.getY());
		
		for(int xx=0;xx<30*70;xx+=32)
		{
			for(int yy=0;yy<30*70;yy+=32)
			{
				g.drawImage(tex.floor,xx,yy,null);
			}
		}
	
		handler.render(g);
		
		
		g2d.translate(camera.getX(), camera.getY());
		
		hud.render(g);
		
		if(paused)
		 {
			g.setColor(Color.green);
			g.setFont(new Font("Algerian",Font.BOLD,30));
			g.drawString("Game Paused",420,260);
			
			g.setFont(new Font("Algerian",Font.BOLD,20));
			g.drawRect(835, 489,150, 30);
			g.drawString("Enter Shop", 850, 512);
		 }
		
		}
		else if(gameState == STATE.menu || gameState == STATE.end)
		{	
			menu.render(g);
		}
	   else if(gameState == STATE.help)
	    {
		 options.render(g);
	    }
		g.dispose();
		bs.show();
		
	}
	
	public static float clamp(float var,float min,float max)
	{
		if(var<=min)
		{
			return min;
		}
		else if(var>=max)
		{
			return max;
		}
		else
		{
			return var;
		}
	}
	public static Textures getInstance()
	{
		return tex;
	}
	public void reset()
	{
		hud.setPoints(0);
		hud.setLevel(1);
		HUD.HEALTH=100;
		HUD.AMMO=100;
	
	}	public static void main(String args[])
	{
		new Game();
	}
}
