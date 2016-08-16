package dinorun;

import processing.core.PApplet;
import processing.core.PImage;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.*;
	public class DinoRun extends PApplet{
		
		PImage image;
		
		public static void main(String[] args) {
			PApplet.main("dinorun.DinoRun");
			
		}
		
		Minim minim;
		AudioPlayer song;

		//list of objects in or game
		Avatar person;
		Obstacle ob;
		Obstacle ob2;
		Obstacle ob3;
		Obstacle ob4;
		Obstacle ob5;
		int platform = 755;
		int timer = 0;
		int highscore = 0;
		long lastTime = System.currentTimeMillis();
		boolean over = false;
		boolean playing = true;
		
	public void settings() {
		size(1500,950);
	}

	public void setup() {
		image = loadImage("Background.png");
		background(image);
		//build our main character:
		 
		person = new Avatar(this, "Avatar.png", 200, platform, 50, 50);
		ob = new Obstacle(this, "spikes.png", 800, platform, 60, 50, 13);
		ob2 = new Obstacle(this, "spikeball.png", 1300, platform, 50, 50, 13);
		ob3 = new Obstacle(this, "knives.png", 1650, platform, 60, 60, 13);
		ob4 = new Obstacle(this, "carobstacle.png", 1250, platform, 60, 60, 13);
		ob5 = new Obstacle(this, "cactus.png", 22000, platform, 60, 30, 13);
		minim = new Minim(this);
		song = minim.loadFile("music.mp3", 512);
		song.play();
		song.loop();
		//ob = new Obstacle(this, "name.png", width/2, + 300 platform, xsizeof image, y size of image, 20);
		
	}

	public void draw() {
			if (playing == true){
				
			
				background(image);
				person.display();
				ob.display();
				ob.move();
				ob2.display();
				ob2.move();
				ob3.display();
				ob3.move();
				ob4.display();
				ob4.move();
				ob5.display();
				ob5.move();
				checkCollisions();
				timer();
				textSize(32);
				text(timer, width/2, 400);
				fill(255);
				if(highscore > 0) {
					text("highscore is " + highscore, width/2 - 100, height/2);
				}
				
			}	else {
					// game is over + restart logic
					if (keyPressed == true && key == 'r') {
						
						ob.x = 800;
						ob2.x = 1300;
						ob3.x = 1650;
						ob4.x = 1250;
						ob5.x = 22000;
						
						int newscore = timer;
						if (newscore > highscore) {
							highscore = newscore;
						}
						
						timer = 0;
						playing = true;
					}
			}
		}
	
	public void gameOver() {
	{
		playing = false;
		background(0);
		textSize(50);
		fill(255);
		text("Game Over", width/2 - 130, height/2 + 100);
		text("press r to restart", width/2 - 200, height/2 + 200);
		}
	}
	public void keyPressed()
	{
		if(key == ' ')
		{
			person.activateJump();
		}
	}
	
	public void checkCollisions()
	{
		if (person.hasCollided(ob))
		{
			println("this has worked");
			gameOver();
		}
		if (person.hasCollided(ob2))
		{
			gameOver();
		}
		if (person.hasCollided(ob3))
		{
			gameOver();
		}
		if (person.hasCollided(ob4))
		{
			gameOver();
		}
		if (person.hasCollided(ob5))
		{
			gameOver();
		}
	}
	
	public void timer() {
		//we want to count a single second and then add 1 to a timer
		if (System.currentTimeMillis() - lastTime > 100) {
			timer +=1;
					lastTime= System.currentTimeMillis();
		}
	}
}
