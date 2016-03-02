package game.level;

import game.graphics.Screen;
import game.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/Maps/Spawn.png");
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel(){	
	}
	
	protected void loadLevel(String path){	
	}

	public void update(){	
	}
	
	private void time(){	
	}
	
	public void render(int xScroll, int yScroll, Screen screen){		
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll / 16;
		int x1 = (xScroll + screen.width + 16) / 16;
		int y0 = yScroll / 16;
		int y1 = (yScroll + screen.height + 16) / 16;	
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x,y).render(x,y, screen);
			}
		}
	}	
	
	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;	
		if (tiles[x + y * width] == Tile.col_spawn_wood) return Tile.spawn_floor_wood;
		if (tiles[x + y * width] == Tile.col_spawn_flower_1) return Tile.spawn_flower_1;	
		if (tiles[x + y * width] == Tile.col_spawn_flower_2) return Tile.spawn_flower_2;
		if (tiles[x + y * width] == Tile.col_spawn_grass_1) return Tile.spawn_grass_1;
		if (tiles[x + y * width] == Tile.col_spawn_grass_2) return Tile.spawn_grass_2;
		if (tiles[x + y * width] == Tile.col_spawn_wall_stone) return Tile.spawn_wall_stone;
		if (tiles[x + y * width] == Tile.col_spawn_wall_top_stone) return Tile.spawn_wall_top_stone;
		if (tiles[x + y * width] == Tile.col_spawn_wall_bottom_stone) return Tile.spawn_wall_bottom_stone;
		if (tiles[x + y * width] == Tile.col_spawn_wall_side_stone) return Tile.spawn_wall_side_stone;
		if (tiles[x + y * width] == Tile.col_spawn_wall_topRight_stone) return Tile.spawn_wall_topRight_stone;
		return Tile.voidTile;	
	}
}
