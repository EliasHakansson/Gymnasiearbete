package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Spawn_level.SpawnGrassTile;
import game.level.tile.Spawn_level.SpawnStoneWallTile;
import game.level.tile.Spawn_level.SpawnWaterTile;

public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass_1        	= new GrassTile(Sprite.grass_1);
	public static Tile grass_2        	= new GrassTile(Sprite.grass_2);
	public static Tile grass_flower_1 	= new GrassTile(Sprite.grass_flower_1);
	public static Tile water          	= new WaterTile(Sprite.water);
	public static Tile grass_flower_2 	= new GrassTile(Sprite.grass_flower_2);	
	public static Tile wall_stone      	= new VoidTile(Sprite.wall_stone);
	public static Tile voidTile       	= new VoidTile(Sprite.voidSprite);
	public static Tile floor_wood     	= new VoidTile(Sprite.floor_wood);
	
	public static Tile spawn_grass_1				= new SpawnGrassTile(Sprite.spawn_grass_1);
	public static Tile spawn_grass_2				= new SpawnGrassTile(Sprite.spawn_grass_2);
	public static Tile spawn_flower_1				= new SpawnGrassTile(Sprite.spawn_flower_1);
	public static Tile spawn_flower_2				= new SpawnGrassTile(Sprite.spawn_flower_2);
	public static Tile spawn_water					= new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall_stone				= new SpawnStoneWallTile(Sprite.spawn_wall_stone);
	public static Tile spawn_wall_top_stone 		= new SpawnStoneWallTile(Sprite.spawn_wall_top_stone);
	public static Tile spawn_wall_topBottom_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_topBottom_stone);
	public static Tile spawn_wall_bottom_stone 		= new SpawnStoneWallTile(Sprite.spawn_wall_bottom_stone);
	public static Tile spawn_wall_topRight_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_topRight_stone);
	public static Tile spawn_wall_bottomRight_stone = new SpawnStoneWallTile(Sprite.spawn_wall_bottomRight_stone);
	public static Tile spawn_wall_bottomLeft_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_bottomLeft_stone);
	public static Tile spawn_wall_topLeft_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_topLeft_stone);
	public static Tile spawn_wall_rightSide_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_rightSide_stone);
	public static Tile spawn_wall_leftSide_stone 	= new SpawnStoneWallTile(Sprite.spawn_wall_leftSide_stone);
	public static Tile spawn_floor_wood				= new SpawnGrassTile(Sprite.spawn_floor_wood);
	
	public static final int col_spawn_grass_1					= 0xff0ff00f;
	public static final int col_spawn_grass_2 					= 0xff007F46;
	public static final int col_spawn_flower_1 					= 0xffffff00;
	public static final int col_spawn_flower_2 					= 0xffff00DC;
	public static final int col_spawn_wall_stone 				= 0xff808080;
	public static final int col_spawn_wall_top_stone 			= 0xffFF0000;
	public static final int col_spawn_wall_bottom_stone 		= 0xff0026FF;
	public static final int col_spawn_wall_rightSide_stone 		= 0xffFF006E;
	public static final int col_spawn_wall_leftSide_stone 		= 0xff00FFFF;
	public static final int col_spawn_wall_topRight_stone 		= 0xffFF7F7F;
	public static final int col_spawn_wall_topBottom_stone 		= 0xff404040;
	public static final int col_spawn_wall_topLeft_stone 		= 0xff007F0E;
	public static final int col_spawn_wall_bottomRight_stone	= 0xffffffff;
	public static final int col_spawn_wall_bottomLeft_stone 	= 0xffB6FF00;
	public static final int col_spawn_wood 						= 0xffA56B43;
	
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean sinking(){
		return false;
	}
}