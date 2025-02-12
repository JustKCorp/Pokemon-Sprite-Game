import java.util.Random;

public class Life extends Pokemon{

	// Method that creates random X,Y
	Life() {

		// Random number generator, assign to X,Y

		y = -300;
		spd = randomGenerator.nextInt(3) + 1;
		// add pokemon picture and scale down
		pokemon = EZ.addImage("heart.png", x, y);
	}

	// method that sets the speed of the life and returns the value
	public int setSpeed() {

		Random randomGenerator;
		randomGenerator = new Random();
		int spd = randomGenerator.nextInt(3) + 1;
		return spd;

	}

}

