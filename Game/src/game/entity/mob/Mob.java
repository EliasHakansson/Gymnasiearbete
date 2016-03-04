package game.entity.mob;

import java.util.ArrayList;
import java.util.List;

import game.entity.Entity;
import game.entity.projectile.Projectile;
import game.entity.projectile.WizardProjectile;
import game.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int Pdir = 0;
	protected boolean moving = false;
	protected boolean walking = false;
	
	public void move(int xa, int ya){	
		System.out.println("size: " + level.getProjectiles().size());
		if (xa != 0 && ya != 0){
			move(xa, 0);
			move(0,ya);
			return;
		}
		
		if (xa>0) Pdir = 1;
		if (xa<0) Pdir = 3;
		if (ya>0) Pdir = 2;
		if (ya<0) Pdir = 0;	
		
		if (!collision(xa, ya)){
			y+=ya;
			x+=xa;
		}	
	}
	
	public void tick(){
	}
	
	protected void shoot(int x, int y, double dir){
		Projectile p = new WizardProjectile(x, y, dir);
		level.addProjectile(p);
	}
	
	private boolean collision(int xa, int ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			int xt =((x + xa) + c % 2 * 10 - 6) / 16;
			int yt =((y + ya) + c / 2 * 10 - 4) / 16;
			if (level.getTile(xt, yt).solid()){
				solid = true;
			}
		}
		return solid;
	}
	public void render(){	
	}
}


