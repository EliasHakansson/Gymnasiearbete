package game.entity;

import java.util.Random;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.Level;

public class Entity {
	
	protected int x, y;
	protected Sprite sprite;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void tick(){	
	}
	
	public void render(Screen screen){
		if ( sprite != null) screen.renderSprite(x,y,sprite, true);
	}

	public void remove(){
		//remove from level
		removed = true;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
}
