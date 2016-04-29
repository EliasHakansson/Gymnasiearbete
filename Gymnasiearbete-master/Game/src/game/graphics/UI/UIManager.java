package game.graphics.UI;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class UIManager {

	private List<UIPanel> panels = new ArrayList<UIPanel>();
	
	
	public UIManager(){
		
	}
	
	public void addPanel(UIPanel panel){
		panels.add(panel);
	}
	
	public void tick() {
		for (UIPanel panel : panels){
			panel.tick();
		}
		
	}

	public void render(Graphics g) {
		for (UIPanel panel : panels){
			panel.render(g);
		}
	}

}
