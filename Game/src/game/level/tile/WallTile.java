package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;



public class WallTile extends Tile {
	
	public WallTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y, Screen screen){	
		screen.renderTile(x *16, y*16, this);
	}
	public boolean solid(){
		wall = true;
		return true;
		
		
	}
	
	
	
}