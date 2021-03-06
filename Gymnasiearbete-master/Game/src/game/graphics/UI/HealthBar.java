package game.graphics.UI;

import java.awt.Color;
import java.awt.Graphics;

import org.w3c.dom.ranges.RangeException;

import game.util.Vector2i;

public class HealthBar extends UIComponent {

	private Vector2i size;
	private double progress; // 0.0 -> 1.0
	
	private Color foregroundColor;
	
	public HealthBar(Vector2i position, Vector2i size) {
		super(position);
		this.size = size;
		
		foregroundColor = new Color(0xfffff0ff);
	}

	public void setProgress(double progress){
		if (progress < 0.0 || progress > 1.0){
			throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR,"Progress must be between 0 and 100");		
		}
		this.progress = progress;
	}
	
	public void setForegroundColor(int color){
		this.foregroundColor = new Color(color);
	}
	
	public double getProgress(){
		return progress;
	}
	
	public void tick(){
	
	}
	
	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(position.x, position.y, size.x, size.y);
		
		g.setColor(foregroundColor);
		g.fillRect(position.x, position.y, (int)(progress * size.x), size.y);
	}

}
