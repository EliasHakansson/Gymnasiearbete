package game.entity.projectile;

import game.GameMain;
import game.entity.Spawner.ParticleSpawner;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.Level;
import game.level.tile.Tile;
import game.util.AudioHandler;

public class WizardProjectile extends Projectile {
	
	public static final int FIRE_RATE = 10; //Higher is slower
	public AudioHandler debris = new AudioHandler("audio/debris.wav");
	public AudioHandler bloodhit = new AudioHandler("audio/bloodhit.wav");
	public AudioHandler scream = new AudioHandler("audio/wilhelmscream.wav");
	
	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 90;
		speed = 5;
		damage = 20;
		sprite = Sprite.projectile_pirate;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void tick(){
		if(level.tileCollision((int)(x +nx), (int)(y +ny),8, 4, 4) && Tile.wall){ 	//Kollar kollision med v�gg
			wallCollision = true;
			debris.play();
			mobCollision = false;
    	 	level.add(new ParticleSpawner((int)x,(int)y, 45,20, level));
			remove();	
		}
		move();
		for (int i = 0; i < Level.mobs.size(); i++) {								//Kollar kollision med fiender
	         if (x < Level.mobs.get(i).getX() +10
	            && x > Level.mobs.get(i).getX() -10
	            && y <  Level.mobs.get(i).getY() +10
	            && y >  Level.mobs.get(i).getY() -10
	            ){
	        	 	wallCollision = false;
	 				mobCollision = true;
	 				playerCollision = false;
	 				level.add(new ParticleSpawner((int)x,(int)y, 60,50, level));
	 				Level.mobs.remove(i);
	 				bloodhit.play();
	 				GameMain.hitScore += 10 * GameMain.difficulty;		//10 po�ng/kill vid difficulty 1, H�gre po�ng ju h�gre difficulty. 20 po�ng vid difficulty 2 osv.
	 				GameMain.mobKillCount++;
	 				remove();
	 				
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
