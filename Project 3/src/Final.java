
//Written by Justin Corpuz
//Edited by Cris Javier

import java.awt.Color;

public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EZ.initialize(1024, 768);
		EZ.addImage("background.png", 524 / 2, 786 / 2);
		Sprite me = new Sprite("mc.png", 200, 200, 60, 67, 15);
		Pokemon pokemon = new Pokemon();
		int fontsize = 30;
		Color c = new Color(200, 0, 0);
		EZText Score = EZ.addText(135, 99, "", c, fontsize);
		EZText Lives = EZ.addText(60, 99, "Lives: ", c, fontsize);
		Lives.setFont("Pokemon Solid.ttf");
		Score.setFont("Pokemon Solid.ttf");

	//	EZSound ost = EZ.addSound("PokeOst.wav");
		//ost.play();
		//wost.loop();

		// Pikachu Array
		int NumOfPika = 15;
		Pikachu[] PikachuHolder = new Pikachu[NumOfPika];

		// Bird Array
		int NumOfBird = 12;
		Bird[] BirdHolder = new Bird[NumOfBird];

		// Ray Array
		int NumOfRay = 80;
		Ray[] RayHolder = new Ray[NumOfRay];
		
		// Lives array
		int NumOfLife = 20;
		Life[] LifeHolder = new Life[NumOfLife];
		

		// Array for Pikachu pictures
		for (int i = 0; i < NumOfPika; i++) {
			PikachuHolder[i] = new Pikachu();
		}

		// Array for Bird pictures
		for (int a = 0; a < NumOfBird; a++) {
			BirdHolder[a] = new Bird();
		}
		// Array for Ray pictures
		for (int b = 0; b < NumOfRay; b++) {
			RayHolder[b] = new Ray();
		}
		// Array for Lives pictures
		for (int z = 0; z < NumOfLife; z++) {
			LifeHolder[z] = new Life();
		}

		// While loop
		while (me.Lives > 0) {
			me.go();
			me.shoot();
//			me.shoot();
			// me.moveBall();

			// If loop that checks the Y coordinate of Pikachu. If it goes beyond 768 then
			// the moveBird method is called.
			for (int i = 0; i < 8; i++) {
				for (int a = 0; a < 8; a++) {
					if (PikachuHolder[i].pokemon.yCenter >= 768) {
						BirdHolder[a].movePokemon();
					}
				}
			}

			// If loop that checks the Y coordinate of Pikachu. If it goes beyond 768 then
			// the moveRay method is called.
			for (int i = 0; i < 8; i++) {
				for (int a = 0; a < 8; a++) {
					if (BirdHolder[i].pokemon.yCenter >= 768) {
						RayHolder[a].movePokemon();
					}
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int a = 0; a < 8; a++) {
					if (RayHolder[i].pokemon.yCenter >= 768) {
						LifeHolder[a].movePokemon();
					}
				}
			}
			
		// If loop that checks the Y coordinate of Life. If it goes beyond 768 then
			for (int i = 0; i < 8; i++) {
				for (int a = 0; a < 8; a++) {
					if (LifeHolder[i].pokemon.yCenter >= 768) {
						PikachuHolder[a].movePokemon();

					}
				}
			}

			// If pikachu hits player then 1 life is deducted
			for (int i = 0; i < 8; i++) {
				if (PikachuHolder[i].pokemon.isPointInElement(me.x, me.y)) {
					me.Lives -= 1;
					PikachuHolder[i].teleport();

				}

			}

			// If Bird hits player then 1 life is deducted
			for (int i = 0; i < 3; i++) {
				for (int a = 0; a < 5; a++) {
					if (BirdHolder[i].pokemon.isPointInElement(me.x, me.y)) {
						me.Lives -= 1;
						BirdHolder[i].teleport();

					}
				}
			}

			for (int i = 0; i < 8; i++) {
				if (RayHolder[i].pokemon.isPointInElement(me.x, me.y)) {
					me.Lives -= 1;
					RayHolder[i].teleport();
				}

			}
			
			// If heart hits player then 1 life is added
				for (int i = 0; i < 8; i++) {
					if (LifeHolder[i].pokemon.isPointInElement(me.x, me.y)) {
						me.Lives += 1;
						LifeHolder[i].teleport();
					}

				}
			// Move all pikachu pictures
			for (int i = 0; i < NumOfPika; i++) {
				PikachuHolder[i].movePokemon();

			}

			// Value of Lives
			Score.setMsg(String.valueOf(me.Lives));

			EZ.refreshScreen();

		}
		if(me.Lives<=0) {
			//ost.stop();
			EZImage endscreen = EZ.addImage("endscreen.png", 1024/2, 768/2);
			endscreen.scaleTo(5);
			EZImage textbox = EZ.addImage("textbox.png", 1024/2, 768/2);
			textbox.scaleTo(0.9);
			EZText gameover = EZ.addText(1024/2, 768/2, "Player has blacked out!", c = new Color(0,0,0), fontsize = 25);
			gameover.setFont("Pokemon GB.ttf");
		}

	}
}
