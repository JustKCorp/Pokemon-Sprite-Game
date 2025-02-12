//Written by Justin Corpuz
//Edited by Cris Javier

import java.util.Random;

public class Ray extends Pokemon{

	// Method that creates random X,Y
	Ray() {

		// Random number generator, assign to X,Y
		
		y = -1500;
		spd = randomGenerator.nextInt(5	)+1;
		// add pokemon picture and scale down
		pokemon = EZ.addImage("Ray.gif", x, y);
		pokemon.scaleTo(0.25);

	}

	// method that sets the speed of the pokemon and returns the value
	public int setSpeed() {

		Random randomGenerator;
		randomGenerator = new Random();
		int spd = randomGenerator.nextInt(3)+1;
		return spd;

	}

	
		
	}
	

