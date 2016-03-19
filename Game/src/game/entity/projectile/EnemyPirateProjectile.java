package game.entity.projectile;

import game.entity.Spawner.ParticleSpawner;
import game.graphics.Screen;
import game.graphics.Sprite;

public class EnemyPirateProjectile extends Projectile {
	
	public static final int FIRE_RATE = 20; //Higher is slower

	public EnemyPirateProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 150;
		speed = 2;
		damage = 20;
		sprite = Sprite.projectile_arrow;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void tick(){
		if(level.tileCollision((int)(x +nx), (int)(y +ny),8, 6, 6)){ 
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