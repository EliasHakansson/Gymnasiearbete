package game.entity.Spawner;

import game.entity.Entity;
import game.level.Level;

public abstract class Spawner extends Entity{
	
	public enum Type{
		MOB, PARTICLE;
	}
	
	public Spawner(int x, int y, Type type, int amount, Level level){
		init(level);
		this.x = x;
		this.y = y;
	}
}
