package game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.entity.mob.Chaser;
import game.entity.mob.Dummy;


public class SpawnLevel extends Level{
	
	
	public SpawnLevel(String path){
		super(path);
		
	}
	
	protected void loadLevel(String path){	
		try{
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];		
			image.getRGB(0, 0,w,h,tiles,0,w);		
		}catch (IOException e){
			e.printStackTrace();
			System.out.println("Could not load Level file!");
		}
		Random random = new Random();
		for (int i = 0; i < 1; i++ ) {	
			add(new Chaser(15 ,8));	
		}
		for (int i = 0; i <5; i++){
			add(new Dummy(random.nextInt(15)+10 ,random.nextInt(5)+10));
		}
		
	}
	protected void generateLevel(){
		for (int y = 0; y < 64; y++){
			for (int x = 0; x < 64; x++){
				getTile(x,y);
			}
			tile_size = 16;
		}
	}
}
