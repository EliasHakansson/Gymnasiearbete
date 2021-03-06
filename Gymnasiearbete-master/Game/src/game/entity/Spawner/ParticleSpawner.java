package game.entity.Spawner;

import game.entity.particle.Particle;
import game.level.Level;

public class ParticleSpawner extends Spawner {


	public ParticleSpawner(int x, int y, int life, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		for (int i = 0; i < amount; i++){
			level.add(new Particle(x, y, life));
		}	
	}	
}
