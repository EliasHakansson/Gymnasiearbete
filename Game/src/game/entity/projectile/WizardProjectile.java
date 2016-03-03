package game.entity.projectile;

import game.graphics.Screen;
import game.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		rateOfFire = 15;
		sprite = Sprite.projectile_wizard;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		
	}

	public void tick(){
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen){
		screen.renderProjectile((int)x, (int)y, this);
	}
}
