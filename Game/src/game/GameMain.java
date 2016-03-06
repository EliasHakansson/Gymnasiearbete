package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import game.entity.mob.Player;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.Keyboard;
import game.input.Mouse;
import game.level.Level;
import game.level.TileCoordinate;

public class GameMain extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	private static final int width = 300;					
	private static final int height = width/16*9;
	private static final int scale =5;					
	public static final String title = "Game";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;	
	private Level level;
	private Player player;
	public boolean running = false;
	public int tickCount = 0;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);		
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();			 
	
	public GameMain(){
		Dimension size = (new Dimension(width*scale,height*scale));
		setPreferredSize(size);
																		
		screen = new Screen(width, height);								
		frame = new JFrame(title);										
		key = new Keyboard();											
		level = level.spawn;											
		TileCoordinate playerSpawn = new TileCoordinate(15,12);			
		player = new Player(playerSpawn.x(),playerSpawn.y(),key);		
		player.init(level);															
		
		addKeyListener(key);
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
															
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		frame.setLayout(new BorderLayout());							
		frame.add(this, BorderLayout.CENTER);							
		frame.pack();													
		frame.setResizable(false);										
		frame.setLocationRelativeTo(null);								
		frame.setVisible(true);											
	}	
	
																		
	
	public static int getWindowWidth(){
		return width*scale;
	}
	public static int getWindowHeight(){
		return height*scale;
	}
	
	public synchronized void start() {								
		running = true;
		thread = new Thread(this, "display");
		thread.start();
	}
	public synchronized void stop() {							
		running = false;
		try{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){	
		long lastTime = System.nanoTime();					
		final double nsPerTick = 1000000000/60;					
		
		int ticks = 0;										
		int frames = 0;										
		
		long timer = System.currentTimeMillis();
		double delta=0;										
		
		requestFocus();
		while (running){
			long now = System.nanoTime();					
			delta += (now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender=true;
			
			while(delta >= 1){
				ticks++;
				tick();
				delta --;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			if (shouldRender){
				frames++;
				render();
			}		
			if(System.currentTimeMillis()- timer >= 1000){
				timer +=1000;
				System.out.println(frames + " fps, " + ticks + " updates/s");
				frames=0;
				ticks=0;
			}
		}
	}	
	
	public void tick(){	
		tickCount++;
		key.tick();
		player.tick();
		
		for (int i =0; i <pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		level.tick();
	}	
	
	public void render(){												
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {										
			createBufferStrategy(3);							
			return;
		}
		
		screen.clear();		
		int xScroll = player.x-screen.width/2;
		int yScroll = player.y-screen.height/2;
		
		level.render(xScroll,yScroll, screen);
		player.render(screen);		
		
		for (int i = 0; i< pixels.length; i++ ){
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0 ,0, getWidth(), getHeight(), null);						
		g.setColor(Color.WHITE);						
		g.setFont(new Font("Verdana",0,50));
		//g.fillRect(Mouse.getX(), Mouse.getY(), 64, 64);						
		//g.drawString("Button:"+Mouse.getButton(),80,80);
		g.dispose();											
		bs.show();												
	}
	
	public static void main(String[]args) {
		new GameMain().start();	
	}	
}
