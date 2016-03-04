package game.entity.mob;

import game.GameMain;
import game.entity.projectile.Projectile;
import game.entity.projectile.WizardProjectile;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.Keyboard;
import game.input.Mouse;

public class Player extends Mob{

	private Keyboard input;
	private Sprite sprite ;
	private int animation = 0;
	private boolean walking = false;
	
	private int fireRate = 0;
	
	public Player(Keyboard input){
		this.input = input;	 
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_up;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	
	public void tick(){
		if (fireRate > 0) {
			fireRate--;
		}
		int xa=0, ya=0;
		if(animation < 7500) 
			animation++; 
		 else animation = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}else {
			walking = false;
		}
		clear();
		updateShooting();
	}
	
	private void clear() {
		for(int i = 0; i < level.getProjectiles().size(); i++){
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()){
				level.getProjectiles().remove(i);
			}
		}
		
	}

	private void updateShooting() {	
		if(Mouse.getButton()==1 && fireRate <= 0){
			double dx = Mouse.getX()- GameMain.getWindowWidth()/2;
			double dy = Mouse.getY()- GameMain.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			
			shoot( x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}	
	}

	public void render(Screen screen){
		int flip = 0;	
		if(Pdir == 0){
			sprite = Sprite.player_up;
			if (walking ){
				if(animation % 20 > 10){
					sprite = Sprite.player_up_1;
				}
				else {
					sprite = Sprite.player_up_2;		
				}
			}
		}
		if(Pdir == 1){
			sprite = Sprite.player_side;	
			if (walking ){
				if(animation % 20 > 10){
					sprite = Sprite.player_side_1;
				}
				else {
					sprite = Sprite.player_side_2;		
				}
			}		
		}
		if(Pdir == 2){
			sprite = Sprite.player_down;
			if(walking){		
				if(animation % 20 > 10){
					sprite = Sprite.player_down_1;
				}
				else {
					sprite = Sprite.player_down_2;		
				}
			}
		}
		if(Pdir == 3){
			sprite = Sprite.player_side;
			if(walking){
				
				if(animation % 20 > 10){
					sprite = Sprite.player_side_1;
				}
				else {
					sprite = Sprite.player_side_2;		
				}
			
			}flip = 1;		
		}
		screen.renderPlayer(x-(16/2),y-(16/2),sprite, flip);	
	}
}








