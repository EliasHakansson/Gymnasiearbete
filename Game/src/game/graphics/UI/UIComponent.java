package game.graphics.UI;

import game.util.Vector2i;

public class UIComponent {

	public Vector2i position, offset;
	public int backgroundColor;
	
	public UIComponent(Vector2i position){
		this.position = position;
		offset = new Vector2i();
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}
	void setOffset(Vector2i offset){
		this.offset = offset;
	}
	
}
