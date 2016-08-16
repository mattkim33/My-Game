package dinorun;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle extends Shape {
	// class attributes
	PApplet p;
	PImage img;
	int xspeed;
	
	// constructor
	public Obstacle (PApplet _p, String name, int _x, int _y, int _width, int _height, int _xspeed) {
		super(_x, _y, _width, _height);
		p = _p;
		img = p.loadImage(name);
		xspeed = _xspeed; 
	}
	
	//display
	public void display () {
		p.image(img, x, y, width, height);
	
	}
	
	
	//move
	public void move() {
		//move to the  left
		x -= xspeed;				
		
		//if at left side of screen, respawn
			if(x <= 0) {
				int random = 0 + (int)(Math.random() * 150);
				x = p.width + random;
			}
		
	}
}
