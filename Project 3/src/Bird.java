
//Written by Justin Corpuz
//Edited by Cris Javier

import java.util.Random;

public class Bird extends Pokemon {

	Bird() {

		y = -700;
		spd = randomGenerator.nextInt(4) + 1;

		// add hurricane picture and scale down
		pokemon = EZ.addImage("Bird1.gif", x, y);
		pokemon.scaleTo(0.5);
	}

	// method that sets the speed of the hurricane and returns the value
	public int setSpeed() {

		Random randomGenerator;
		randomGenerator = new Random();
		int spd = randomGenerator.nextInt(3) + 1;
		return spd;

	}

}
