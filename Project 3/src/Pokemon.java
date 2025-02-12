//Written by Cris Javier

import java.util.Random;

public class Pokemon {

	int x;
	int y;
	double spd;
	EZImage pokemon;
	Random randomGenerator = new Random();

	// Method that creates random X,Y
	Pokemon() {

		// Random number generator, assign to X,Y
		Random randomGenerator;
		randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		y = 0;
		spd = randomGenerator.nextInt(3) + 0.5;
		// add pokemon picture and scale down

	}

	// method that sets the speed of the pokemon and returns the value
	public int setSpeed() {

		Random randomGenerator;
		randomGenerator = new Random();
		int spd = randomGenerator.nextInt(30) + 10;
		return spd;

	}

	// Method that checks the boundaries of the pokemon and assigns a random speed
	// once it reaches the boundary
	public void movePokemon() {
		if (pokemon.yCenter <= 1000) {
			pokemon.yCenter += spd;
		}
		if (pokemon.yCenter == 1000) {
			pokemon.translateTo(x, y);
		}

		// if (PikachuPic.xCenter >= 1030) {

		// Moves pokemon with designated speed

	}

	public void teleport() {
		Random randomGenerator;
		randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		pokemon.translateTo(x, y);
	}
}
