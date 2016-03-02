package game.level.tile.Spawn_level;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

public class SpawnWaterTile extends Tile{

	public SpawnWaterTile(Sprite sprite) {
		super(sprite);	
	}
	
	public void render(int x, int y, Screen screen){	
		screen.renderTile(x *16, y*16, this);
	}
}