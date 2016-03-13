package game.entity.mob;

import java.util.List;

import game.GameMain;
import game.entity.Entity;
import game.entity.projectile.Projectile;
import game.entity.projectile.WizardProjectile;
import game.graphics.AnimatedSprite;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.input.Keyboard;
import game.input.Mouse;

public class Player extends Mob{

	private Keyboard input;
	private Sprite sprite ;
	private int animation = 0;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int fireRate = 0;
	
	public Player(Keyboard input){
		this.input = input;	
		sprite = Sprite.player_forward;
		animSprite = down;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	
	public void tick(){
		if (walking) animSprite.tick();	
		else animSprite.setFrame(0);
		if (fireRate > 0) fireRate--;
		int xa = 0, ya = 0;
		if (input.up) {
			animSprite = up;
			ya--;	
		} else if(input.down) {
			animSprite = down;
			ya++;	
		}
		if(input.left) {
			animSprite = left;
			xa--;
		}else if(input.right){
			animSprite = right;
			xa++;	
		}
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
		sprite = animSprite.getSprite();	
		screen.renderMob(x-8, y-8, sprite, flip);
	}
}








