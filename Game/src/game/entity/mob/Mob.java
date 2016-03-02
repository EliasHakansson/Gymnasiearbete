package game.entity.mob;

import game.entity.Entity;
import game.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya){	
		if (xa>0) dir = 1;
		if (xa<0) dir = 3;
		if (ya>0) dir = 2;
		if (ya<0) dir = 0;	
		
		if (!collision(0, ya)){
			y+=ya;
		}
		if (!collision(xa, 0)){
			x+=xa;
		}	
	}
	public void tick(){
	}
	protected void shoot(int x, int y, double dir){
		System.out.println("Angle:"+dir);
	}
	
	public void render(){			
	}
	
	private boolean collision(int xa, int ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			int xt =((x+xa)+ c % 2 * 10  -6) / 16;
			int yt =((y+ya)+ c / 2 * 10 -4 ) / 16;
			if (level.getTile(xt, yt).solid()){
			solid = true;
		}
		}
	
		
		return solid;
	}
}


