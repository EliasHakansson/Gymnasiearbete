package game.graphics;

public class Sprite {
	
	final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 12,0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,12,1,SpriteSheet.tiles);
	
	public static Sprite player_still = new Sprite(48,0,0, SpriteSheet.tiles);
	public static Sprite player_up = new Sprite(48,2,0, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(48,1,1, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(48,0,2, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(48,2,1, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(48,2,2, SpriteSheet.tiles);
	
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


