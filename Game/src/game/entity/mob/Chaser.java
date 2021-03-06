package game.entity.mob;

import java.util.List;

import game.graphics.AnimatedSprite;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;

public class Chaser extends Mob{

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int xa = 0;
	private int ya = 0;
	
	public Chaser(int x, int y){
		this.x = x *16;
		this.y = y *16;
		sprite = Sprite.dummy;
	}
	
	private void move() {
		xa = 0;
		ya = 0;
		
		List<Player> players = level.getPlayers(this, 50);
		if (players.size() >0){
			Player player = players.get(0);
			if(x < player.getX()) xa++;
			if(x > player.getX()) xa--;
			if(y < player.getY()) ya++;
			if(y > player.getY()) ya--;
		}
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}else {
			walking = false;
		}
	}
	
	public void tick() {
		move();
		if (walking){
			animSprite.tick();
		}else {
			animSprite.setFrame(0);
		}
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
			System.out.println(ya);
		}else if(ya > 0) {
			animSprite = down;
			dir = Direction.DOWN;	
		}
		if(xa < 0) {
			animSprite = left;
			dir = Direction.LEFT;
		}else if(xa > 0){
			animSprite = right;
			dir = Direction.RIGHT;	
		}
		
	}

	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob(x-8, y-8, sprite, 0);
	
	}

}
