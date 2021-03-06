package game.entity.mob;

import java.util.List;

import game.graphics.AnimatedSprite;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.graphics.SpriteSheet;
import game.level.Node;
import game.util.Vector2i;

public class Star extends Mob{

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int xa = 0;
	private int ya = 0;
	public List<Node> path = null;
	private int time = 0;
	
	public Star(int x, int y){
		this.x = x *16;
		this.y = y *16;
		sprite = Sprite.dummy;
	}
	
	private void move() {
		xa = 0;
		ya = 0;
		
		int px = level.getPlayerAt(0).getX();
		int py = level.getPlayerAt(0).getY();
		Vector2i start = new Vector2i(getX() / 16, getY() / 16);
		Vector2i destination = new Vector2i (px / 16, py / 16);
		if (time % 1 == 0)  {
			path = level.findPath(start, destination);
		}
		if (path != null) {
			if (path.size()> 0){
				Vector2i vec = path.get(path.size()-1).tile;
				
				if (x < vec.getX() * 16){
					xa++;
				}
				if (x > vec.getX() * 16){
					xa--;
				}
				if (y < vec.getY() * 16){
					ya++;
				}
				if (y > vec.getY() * 16){
					ya--;
				}
			}
		} 
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}else {
			walking = false;
		}
	}
	
	public void tick() {
		time++;
		move();
		if (walking){
			animSprite.tick();
		}else {
			animSprite.setFrame(0);
		}
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
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
