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

import javax.swing.JFrame;

import game.entity.mob.Player;
import game.graphics.Screen;
import game.input.Keyboard;
import game.level.Level;
import game.level.RandomLevel;

public class GameMain extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;

	public static final int width = 300;					
	public static final int height = width/16*9;
	public static final int scale =5;					
	public static final String name = "Game";
	private Keyboard key;
	private JFrame frame;
	private Level level;
	private Player player;
	public boolean running = false;
	public int tickCount = 0;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);		
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();			 
	
	public GameMain(){
		Dimension canvasSize = (new Dimension(width*scale,height*scale));
		setPreferredSize(canvasSize);
	
		screen = new Screen(width, height);
		frame = new JFrame(name);
		key = new Keyboard();
		level = new RandomLevel(64,64);
		player = new Player(key);
		
		addKeyListener(key);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());					
		frame.add(this, BorderLayout.CENTER);					
		frame.pack();											
		frame.setResizable(false);								
		frame.setLocationRelativeTo(null);						
		frame.setVisible(true);									
	}
	
	private Thread thread;
	
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
		double nsPerTick = 1000000000/60;					
		
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
		
		g.setColor(Color.WHITE);						
		g.setFont(new Font("Verdana",0,50));
		g.fillRect(0, 0, getWidth(), getHeight());						
		g.drawImage(image, 0 ,0, getWidth(), getHeight(), null);
		//g.drawString("X:"+player.x +",Y:" + player.y,350,300);
		g.dispose();											
		bs.show();												
	}
	public static void main(String[]args) {
		new GameMain().start();	
	}	
}