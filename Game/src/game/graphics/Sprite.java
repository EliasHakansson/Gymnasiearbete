package game.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x,y;
	private int width, height;
	public int[] pixels;
	protected SpriteSheet sheet;
	
	public static Sprite voidSprite = new Sprite(16,0);
	
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
	
	public static Sprite spawn_sand_1 = new Sprite(16,7,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_bottomRight = new Sprite(16,7,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_bottomLeft = new Sprite(16,7,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_topLeft = new Sprite(16,7,3, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_topRight = new Sprite(16,7,4, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_top = new Sprite(16,8,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_right = new Sprite(16,8,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_bottom = new Sprite(16,8,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_left = new Sprite(16,8,3, SpriteSheet.spawn_level);
	 
	 public static Sprite spawn_water_1 = new Sprite(16,9,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_2 = new Sprite(16,9,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_3 = new Sprite(16,9,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_4 = new Sprite(16,9,3, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_top = new Sprite(16,10,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_right = new Sprite(16,10,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_bottom = new Sprite(16,10,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_left = new Sprite(16,10,3, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_top = new Sprite(16,11,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_right = new Sprite(16,11,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_bottom = new Sprite(16,11,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_left = new Sprite(16,11,3, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_topLeft = new Sprite(16,1,4, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_topRight = new Sprite(16,3,4, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_bottomRight = new Sprite(16,3,6, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_sand_bottomLeft = new Sprite(16,1,6, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_bottomRight = new Sprite(16,13,0, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_bottomLeft = new Sprite(16,13,1, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_topLeft = new Sprite(16,13,2, SpriteSheet.spawn_level);
	 public static Sprite spawn_water_shallow_topRight = new Sprite(16,13,3, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_leftTop = new Sprite(16,8,4, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_rightTop = new Sprite(16,8,5, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_rightBottom = new Sprite(16,8,6, SpriteSheet.spawn_level);
	 public static Sprite spawn_sand_grass_leftBottom = new Sprite(16,7,5, SpriteSheet.spawn_level);
	

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
	public static Sprite particle_player = new Sprite(2,0xFF7F0000);
	
	
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
		tick();
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

	private void tick(){
		for (int y = 0; y < height; y++ ){
			for ( int x = 0; x < width; x++){
				pixels[x+y*width]= sheet.pixels[(x+this.x)+(y+this.y) * sheet.WIDTH];
			}
		}
	}
}


