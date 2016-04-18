package game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.entity.mob.Star;

public class SpawnLevel extends Level{
	
	int randomSpawn;
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
		for (int i = 0; i < 1; i++ ) {	
			add(new Star(50,20));	
		}
		/*for (int i = 0; i <10; i++){
			add (new Shooter(random.nextInt(16) +41 ,random.nextInt(10)+17));
		}*/	
	}
	protected void generateLevel(){	
		for (int y = 0; y < 100; y++){
			for (int x = 0; x < 200; x++){
				getTile(x,y);
			}
			tile_size = 16;
		}
	}
}
