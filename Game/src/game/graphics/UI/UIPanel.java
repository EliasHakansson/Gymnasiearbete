package game.graphics.UI;

import java.util.ArrayList;
import java.util.List;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.util.Vector2i;

public class UIPanel {

	private List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i position;
	
	private Sprite sprite;
	
	public UIPanel(Vector2i position){
		this.position = position;
		sprite = new Sprite(260, 20, 0xff383838);
	}
	
	public void addComponent(UIComponent component){
		components.add(component);
	}
	
	public void tick(){
		for (UIComponent component : components){
			component.setOffset(position);
			component.tick();
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(position.x, position.y, sprite, false);
		for (UIComponent component : components){
			component.render();
		}
	}


}