
//Written by Justin Corpuz
//Edited by Cris Javier

import java.util.Random;

public class Pikachu extends Pokemon {

	// Method that creates random X,Y
	Pikachu() {

		// Random number generator, assign to X,Y

		y = -100;
		spd = randomGenerator.nextInt(3) + 1;
		// add pokemon picture and scale down
		pokemon = EZ.addImage("Pikachu.png", x, y);
		pokemon.scaleTo(0.15);

	}

	// method that sets the speed of the pokemon and returns the value
	public int setSpeed() {

		Random randomGenerator;
		randomGenerator = new Random();
		int spd = randomGenerator.nextInt(3) + 1;
		return spd;

	}

}
