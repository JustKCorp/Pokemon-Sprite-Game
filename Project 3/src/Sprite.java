
//Written by Justin Corpuz
//Edited by Cris Javier

import java.awt.event.KeyEvent;

public class Sprite {

	EZImage spriteSheet;

	int x = 0; // Position of Sprite
	int y = 0;
	int spriteWidth; // Width of each sprite
	int spriteHeight; // Height of each sprite
	int direction = 0; // Direction character is walking in
	int walkSequence = 0; // Walk sequence counter
	int cycleSteps; // Number of steps before cycling to next animation step
	int counter = 0; // Cycle counter
	int Lives = 3;
	EZImage poke;

	public Sprite(String imgFile, int startX, int startY, int width, int height, int steps) {
		x = 512; // position of the sprite character on the screen
		y = 740;
		spriteWidth = width; // Width of the sprite character
		spriteHeight = height; // Height of the sprite character
		cycleSteps = steps; // How many pixel movement steps to move before changing the sprite graphic
		spriteSheet = EZ.addImage(imgFile, x, y);
		setImagePosition();

	}

	public void setImagePosition() {

		// Move the entire sprite sheet
		spriteSheet.translateTo(x, y);

		// Show only a portion of the sprite sheet.
		// Portion is determined by setFocus which takes 4 parameters:
		// The 1st two numbers is the top left hand corner of the focus region.
		// The 2nd two numbers is the bottom right hand corner of the focus region.
		spriteSheet.setFocus(walkSequence * spriteWidth, direction, walkSequence * spriteWidth + spriteWidth,
				direction + spriteHeight);
	}

	public void moveDown(int stepSize) {
		y = y + stepSize;

		direction = 0;

		if ((counter % cycleSteps) == 0) {
			walkSequence++;
			if (walkSequence > 3)
				walkSequence = 0;
		}
		counter++;
		setImagePosition();
	}

	public void moveLeft(int stepSize) {
		x = x - stepSize;
		direction = spriteHeight;

		if ((counter % cycleSteps) == 0) {
			walkSequence--;
			if (walkSequence < 0)
				walkSequence = 3;
		}
		counter++;
		setImagePosition();
	}

	public void moveRight(int stepSize) {
		x = x + stepSize;
		direction = spriteHeight * 2;

		if ((counter % cycleSteps) == 0) {
			walkSequence++;
			if (walkSequence > 3)
				walkSequence = 0;
		}
		counter++;

		setImagePosition();
	}

	public void moveUp(int stepSize) {
		y = y - stepSize;
		direction = spriteHeight * 3;

		if ((counter % cycleSteps) == 0) {
			walkSequence--;
			if (walkSequence < 0)
				walkSequence = 3;
		}
		setImagePosition();

		counter++;
	}

	// Keyboard controls for moving the character.
	public void go() {
		int posY = spriteSheet.getYCenter();
		int posX = spriteSheet.getXCenter();

		if (posY > 705) {
			if (EZInteraction.isKeyDown('w')) {
				moveUp(8);
			}
		}
		if (posX > 0) {
			if (EZInteraction.isKeyDown('a')) {
				moveLeft(8);
			}
		}
		if (posY < 760) {
			if (EZInteraction.isKeyDown('s')) {
				moveDown(8);
			}
		}
		if (posX < 1000) {
			if (EZInteraction.isKeyDown('d')) {
				moveRight(8);
			}
		}
	}

	public void shoot() {

		int posY = spriteSheet.getYCenter();
		int posX = spriteSheet.getXCenter();

		if (EZInteraction.isKeyDown("f")) {
			EZImage Fireball = EZ.addImage("Fireball.png", posX, posY);
			Fireball.scaleTo(0.1);
			if (Fireball.getYCenter() > 0) {
				 posY--;
				System.out.println(posY);
				Fireball.translateTo(posX, posY);
			}
		}
			
		

	}

//	public void shoot() {
//		int posX = spriteSheet.getXCenter();
//		int posY = spriteSheet.getYCenter();
//		
//		if (EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE)) {
//			EZImage poke = EZ.addImage("pokeball.png", posX, posY);
//			
//			//if (EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE)) {
//			posY-=100;
//			poke.translateBy(posX, posY);
//			
//		}

}

/*
 * void moveBall() { if (EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE)) {
 * poke.yCenter-=10; }
 * 
 * 
 * 
 * 
 * }
 */

/*
 * void MovebBall() { if (posX < 1024) { poke.translateBy(1024, posY);
 */
