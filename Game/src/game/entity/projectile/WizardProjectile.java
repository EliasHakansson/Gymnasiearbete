package game.entity.projectile;

import game.entity.Spawner.ParticleSpawner;
import game.entity.mob.Shooter;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.Level;
import game.level.tile.Tile;

public class WizardProjectile extends Projectile {
	
	public static final int FIRE_RATE = 10; //Higher is slower
	

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 150;
		speed = 4;
		damage = 20;
		sprite = Sprite.projectile_pirate;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	

	public void tick(){
		if(level.tileCollision((int)(x +nx), (int)(y +ny),8, 4, 4) && Tile.wall){ 
			wallCollision = true;
			mobCollision = false;
    	 	level.add(new ParticleSpawner((int)x,(int)y, 45,20, level));
			remove();	
		}
		move();
		for (int i = 0; i < Level.mobs.size(); i++) {
	         if (x < Level.mobs.get(i).getX() +10
	            && x > Level.mobs.get(i).getX() -10// creates a 32x32 boundary, change it if your mobs are not 32x32
	            && y <  Level.mobs.get(i).getY() +10
	            && y >  Level.mobs.get(i).getY() -10
	            ){
	        	 	wallCollision = false;
	 				mobCollision = true;
	 				level.add(new ParticleSpawner((int)x,(int)y, 20,10, level));	
	 				remove();
	        	 	
	        	 	//Level.entities.get(i).health -= 1; only if your entities have health
	            
	         }
	      }
	}
	
	protected void move(){
			x += nx;
			y += ny;
		if (distance() > range ){
			remove();
		}
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x) +(yOrigin - y)*(yOrigin - y)));
		return dist;
	}

	public void render(Screen screen){
		screen.renderProjectile((int)x - 8, (int)y -8, this);
	}
}
