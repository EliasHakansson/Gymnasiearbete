package game.entity.mob;

import game.entity.Entity;
import game.entity.projectile.EnemyPirateProjectile;
import game.entity.projectile.Projectile;
import game.entity.projectile.WizardProjectile;
import game.graphics.Screen;

public abstract class Mob extends Entity {
	

	protected boolean moving = false;
	protected boolean walking = false;
	
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	protected Direction dir;
	
	public void move(double xa, double ya){	
		if (xa != 0 && ya != 0){
			move(xa, 0);
			move(0,ya);
			return;
		}
		
		if (xa>0) dir = Direction.RIGHT;
		if (xa<0) dir = Direction.LEFT;
		if (ya>0) dir = Direction.DOWN;
		if (ya<0) dir = Direction.UP;	
		
		if (!collision(xa, ya)){
			y+=ya;
			x+=xa;
		}
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen);
	
	protected void shoot(int x, int y, double dir){
		Projectile p = new WizardProjectile(x, y, dir);
		level.add(p);
	}
	
	public void pirateShoot(int x, int y, double dir){
		Projectile ep = new EnemyPirateProjectile(x, y, dir);
		level.add(ep);
	}
	
	private boolean collision(double xa, double ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			double xt =((x + xa) - c % 2 * 10) / 16;
			double yt =((y + ya) - c /2 * 10 ) / 16;
			int ix=(int)Math.ceil(xt);
			int iy=(int) Math.ceil(yt);
			if(c % 2 == 0) ix =(int) Math.floor(xt);
			if(c / 2 == 0) iy =(int) Math.floor(yt);
			if (level.getTile(ix, iy).solid()){
				solid = true;
			}
		}
		return solid;
	}
}