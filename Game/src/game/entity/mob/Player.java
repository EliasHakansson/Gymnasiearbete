package game.entity.mob;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.Keyboard;
import game.input.Mouse;

public class Player extends Mob{

	private Keyboard input;
	private Sprite sprite ;
	private int animation = 0;
	private boolean walking = false;
	
	
	public Player(Keyboard input){
		this.input = input;
		 
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down;
	}
	
	public void tick(){
		int xa=0, ya=0;
		if(animation < 8000) 
			animation++; 
		 else animation = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		if(Mouse.getButton()==1){
			shoot(x, y, dir);
		}
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}
		else {
			walking = false;
		}
		updateShooting();
	}
	
	private void updateShooting() {	
		if(Mouse.getButton()==1){
			double dx = Mouse.getX()- 300/2;
			double dy = Mouse.getY()-(300/16*9)/2;
			double dir = Math.atan2(dy, dx);
			
			shoot( x, y, dir);
		}	
	}

	public void render(Screen screen){
		int flip = 0;	
		if(dir == 0){
			sprite = Sprite.player_up;
			if (walking ){
				if(animation % 20 > 10){
					sprite = Sprite.player_up_1;
				}
				else {
					sprite = Sprite.player_up_2;		
				}
			}
		}
		if(dir == 1){
			sprite = Sprite.player_side;	
			if (walking ){
				if(animation % 20 > 10){
					sprite = Sprite.player_side_1;
				}
				else {
					sprite = Sprite.player_side_2;		
				}
			}		
		}
		if(dir == 2){
			sprite = Sprite.player_down;
			if(walking){		
					if(animation % 20 > 10){
						sprite = Sprite.player_down_1;
					}
					else {
						sprite = Sprite.player_down_2;		
					}
				
			}
		}
		if(dir == 3){
			sprite = Sprite.player_side;
			if(walking){
				
				if(animation % 20 > 10){
					sprite = Sprite.player_side_1;
				}
				else {
					sprite = Sprite.player_side_2;		
				}
			
			}flip = 1;		
		}
		screen.renderPlayer(x-(16/2),y-(16/2),sprite, flip);	
	}
}








