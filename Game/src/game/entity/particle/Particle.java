package game.entity.particle;

import game.entity.Entity;
import game.graphics.Screen;
import game.graphics.Sprite;

public class Particle extends Entity{
	
	private Sprite sprite;
	
	private int life;
	private int time = 0;
	
	protected double xa, ya, za, xx, yy, zz;
	
	
	
	public Particle(int x, int y, int life){
		System.out.println("Particlelife: "+life);
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life= life + (random.nextInt(20)-10);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian() +2.5;
		if(this.xa < 0){
			xa = 0.1;		
		}
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat()+2.0;
		
	}
	
	public void tick(){
		time++;
		if (time >= 8000) time=0;
		if(time > life){
			remove();
		}
		za -= 0.1;
		
		if (zz < 0){
			zz = 0;
			za *= -0.6;
			xa *= 0.1;
			ya *= 0.2;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render(Screen screen){
		screen.renderSprite((int)xx -5,(int)yy - (int)zz, sprite, true);
				
	}
}
