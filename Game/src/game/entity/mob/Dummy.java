package game.entity.mob;

import game.graphics.AnimatedSprite;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;

public class Dummy extends Mob{
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int time = 0;
	private int xa = 0;
	private int ya = 0;
	
	public Dummy(int x, int y){
		this.x = x * 16;
		this.y = y * 16;
		sprite = Sprite.dummy;
	}
	
	public void tick() {
		time++;
		if (time % (random.nextInt(50) + 30) == 0){
			xa = random.nextInt(3) -1;
			ya = random.nextInt(3) -1;
			if (random.nextInt(4) == 0){
				xa = 0;
				ya = 0;
			}
		}
		
		if (walking){
			animSprite.tick();
		}else {
			animSprite.setFrame(0);
		}
		
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
			
		} else if(ya > 0) {
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
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}else {
			walking = false;
		}
		
	}
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob(x-8, y-8, sprite, 0);
	}

}