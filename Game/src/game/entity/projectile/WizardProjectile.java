package game.entity.projectile;

import game.entity.Spawner.ParticleSpawner;
import game.graphics.Screen;
import game.graphics.Sprite;

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
		if(level.tileCollision((int)(x +nx), (int)(y +ny),8, 4, 4)){ 
			level.add(new ParticleSpawner((int)x,(int)y, 44,20, level));
			remove();
			
		}
		move();
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
