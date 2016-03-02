package game.graphics;

public class Sprite {
	
	final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass_1 = new Sprite(16, 0,9, SpriteSheet.tiles);
	public static Sprite grass_2 = new Sprite(16, 1,9, SpriteSheet.tiles);
	public static Sprite grass_flower_1 = new Sprite(16, 4,9, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 2,9, SpriteSheet.tiles);
	public static Sprite grass_flower_2 = new Sprite(16, 5,9, SpriteSheet.tiles);
	public static Sprite wall_stone = new Sprite(16, 6,9, SpriteSheet.tiles);
	public static Sprite floor_wood = new Sprite(16, 7,9, SpriteSheet.tiles);
	public static Sprite wall_top_stone = new Sprite(16, 6,9, SpriteSheet.tiles);
	
	public static Sprite voidSprite = new Sprite(16,0);
	
	//Spawn level Sprites:
	public static Sprite spawn_grass_1 = new Sprite(16,0,0,SpriteSheet.spawn_level);
	public static Sprite spawn_grass_2 = new Sprite(16, 1,0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2,0, SpriteSheet.spawn_level);	
	public static Sprite spawn_flower_1 = new Sprite(16, 3,0, SpriteSheet.spawn_level);
	public static Sprite spawn_flower_2 = new Sprite(16, 4,0, SpriteSheet.spawn_level);
	public static Sprite spawn_floor_wood = new Sprite(16, 0,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_stone = new Sprite(16, 3,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_top_stone = new Sprite(16, 5,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_bottom_stone = new Sprite(16, 3,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_side_stone = new Sprite(16, 6,2, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_topRight_stone = new Sprite(16, 6,1, SpriteSheet.spawn_level);

	//Player Sprites:
	public static Sprite player_up = new Sprite(16,2,13, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(16,1,13, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(16,0,13, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(16,2,14, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(16,2,15, SpriteSheet.tiles);
	
	public static Sprite player_side_1 = new Sprite(16,1,14, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(16,1,15, SpriteSheet.tiles);
	
	public static Sprite player_down_1 = new Sprite(16,0,14, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(16,0,15, SpriteSheet.tiles);
	
	
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x*size;
		this.y = y*size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE*SIZE; i++ ){
			pixels[i] = colour;	
		}
	}

	private void load(){
		for (int y = 0; y < SIZE; y++ ){
			for ( int x = 0; x < SIZE; x++){
				pixels[x+y*SIZE]= sheet.pixels[(x+this.x)+(y+this.y) * sheet.SIZE];
			}
		}
	}
}


