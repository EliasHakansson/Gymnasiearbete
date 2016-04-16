package game.graphics.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.util.Vector2i;

public class UIPanel {

	private List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i position, size;
	private Color color;
	
	public UIPanel(Vector2i position, Vector2i size){
		this.position = position;
		this.size = size;
		color = new Color(0xff404040);
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
	
	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(position.x, position.y,size.x, size.y);
		for (UIComponent component : components){
			component.render(g);
		}
	}
}
