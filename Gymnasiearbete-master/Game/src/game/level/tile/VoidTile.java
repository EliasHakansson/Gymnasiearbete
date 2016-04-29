package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y, Screen screen){	
		screen.renderTile(x*16, y*16, this);
	}
	public boolean solid(){
		wall = false;
		return true;
	}
}
