package game.entity.projectile;

import java.util.Random;

import game.entity.Spawner.ParticleSpawner;
import game.entity.mob.Player;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.Level;
import game.level.tile.Tile;

public class EnemyPirateProjectile extends Projectile {
	
	public static final int FIRE_RATE = 20; //Higher is slower
	Random random = new Random();
	
	public EnemyPirateProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = random.nextInt(140) +20;
		speed = 1.5;
		damage = 20;
		sprite = Sprite.projectile_arrow;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void tick(){
		if(level.tileCollision((int)(x +nx), (int)(y +ny),8, 6, 6) &&  Tile.wall){ 
			remove();
			wallCollision = true;
			mobCollision = false;
			level.add(new ParticleSpawner((int)x,(int)y, 45,20, level));
		}
		move();
		for (int i = 0; i < Level.players.size(); i++) {
	         if (x < Level.players.get(i).getX() +10
	            && x > Level.players.get(i).getX() -10
	            && y <  Level.players.get(i).getY() +10
	            && y >  Level.players.get(i).getY() -10
	            ) 
	         	{
	        	 	
	        	 	remove();
	        	 	wallCollision = false;
	        	 	mobCollision = true;
	        	 	level.add(new ParticleSpawner((int)x,(int)y, 15,10, level));
	        	 	Player.health -= 10;
	            
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
