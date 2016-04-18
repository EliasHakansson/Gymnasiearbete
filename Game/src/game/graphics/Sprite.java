package game.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x,y;
	private int width, height;
	public int[] pixels;
	protected SpriteSheet sheet;
	
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
	public static Sprite spawn_flower_1 = new Sprite(16, 3,0, SpriteSheet.spawn_level);
	public static Sprite spawn_flower_2 = new Sprite(16, 2,0, SpriteSheet.spawn_level);
	public static Sprite spawn_stone_grass = new Sprite(16, 4,0, SpriteSheet.spawn_level);
	
	public static Sprite spawn_floor_wood = new Sprite(16, 0,1, SpriteSheet.spawn_level);
	
	public static Sprite spawn_wall_stone = new Sprite(16, 5,2, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_top_stone = new Sprite(16, 5,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_bottom_stone = new Sprite(16, 5,3, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_rightSide_stone = new Sprite(16, 6,2, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_topRight_stone = new Sprite(16, 6,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_topLeft_stone = new Sprite(16, 4,1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_bottomRight_stone = new Sprite(16, 6,4, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_bottomLeft_stone = new Sprite(16, 4,4, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_topBottom_stone = new Sprite(16, 5,4, SpriteSheet.spawn_level);
	public static Sprite spawn_wall_leftSide_stone = new Sprite(16, 4,2, SpriteSheet.spawn_level);
	
	public static Sprite spawn_water = new Sprite(16, 2,5, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_left = new Sprite(16, 3,5, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_right = new Sprite(16, 1,5, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_top	 = new Sprite(16, 2,4, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_bottom = new Sprite(16, 2,6, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_bottom_right = new Sprite(16, 3,6, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_bottom_left = new Sprite(16, 1,6, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_top_right = new Sprite(16, 3,4, SpriteSheet.spawn_level);
	public static Sprite spawn_water_edge_top_left = new Sprite(16, 1,4, SpriteSheet.spawn_level);
	

	//Player Sprites:
	public static Sprite player_forward = new Sprite(16,2,13, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(16,1,13, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(16,0,13, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(16,2,14, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(16,2,15, SpriteSheet.tiles);
	
	public static Sprite player_side_1 = new Sprite(16,1,14, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(16,1,15, SpriteSheet.tiles);
	
	public static Sprite player_down_1 = new Sprite(16,0,14, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(16,0,15, SpriteSheet.tiles);
	
	public static Sprite dummy = new Sprite (16,0, 0, SpriteSheet.dummy_down);
	//Projectile sprites
	public static Sprite projectile_pirate = new Sprite(16,0,0, SpriteSheet.pirate_projectiles);
	public static Sprite projectile_arrow = new Sprite(16,1,0, SpriteSheet.pirate_projectiles);
	
	// Particles
	public static Sprite particle_wall = new Sprite(2,0xFF3F3F3F);
	public static Sprite particle_mob = new Sprite(3,0xFF7F0000);
	
	
	protected Sprite(SpriteSheet sheet, int width, int height){			
		SIZE = width == height ?  width : -1;
		this.width = width;
		this.height= height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x*size;
		this.y = y*size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width, int height, int colour){
		SIZE = -1;
		this.width= width;
		this.height=height;
		pixels = new int[width * height];
		setColour(colour);
	}
	
	public Sprite(int size, int colour){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	public Sprite(int[] pixels, int width, int height) {
		this.width = width;
		this.height = height;
		SIZE = width == height ?  width : -1;
		this.pixels = pixels;
	}

	private void setColour(int colour) {
		for (int i = 0; i < width*height; i++ ){
			pixels[i] = colour;	
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	private void load(){
		for (int y = 0; y < height; y++ ){
			for ( int x = 0; x < width; x++){
				pixels[x+y*width]= sheet.pixels[(x+this.x)+(y+this.y) * sheet.WIDTH];
			}
		}
	}
}


