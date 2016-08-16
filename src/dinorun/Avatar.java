package dinorun;
import processing.core.PImage;
import processing.core.PApplet;

public class Avatar extends Shape{
	//class attributes
	PApplet p;
	PImage img;
	boolean isJumping;
	int gravity = 5;
	int yspeed = -50;
	int currentSpeed = 0; 
	
	//avatar constructor:
	public Avatar(PApplet _p, String name, int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
		p = _p;
		img = p.loadImage(name);
		isJumping = false;
		
		
				
	}
	public void display() {
		jump();
		p.image(img, x, y, width, height);
		
	}
	
	public void activateJump()
	{
		if(isJumping == false) 
		{
			isJumping = true;
			currentSpeed = yspeed;
		}
	}
	public void jump() {
		
		if(isJumping == true)
		{
			y = currentSpeed + y;
			currentSpeed = currentSpeed + gravity;
			if(currentSpeed > -yspeed)
			{
				currentSpeed = 0;
				isJumping = false;
			}
		}
		
	}
}

