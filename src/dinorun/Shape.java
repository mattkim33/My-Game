package dinorun;

public class Shape {
	int x;
	int y;
	int height;
	int width;

	
	public Shape(int _x, int _y, int _width, int _height)
	{
		x = _x;
		y = _y;
		width = _width;
		height = _height;
	}
	
	
	public boolean hasCollided(Shape shape)
	{
		if(Math.abs((x - shape.x ))<= width && Math.abs((y-shape.y)) <= height)
		{
			return true;
		}
		
//		if (Math.abs((x - shape.x ))< shape.width && Math.abs((y-shape.y)) < shape.height)
//		{
//			return true;
//		}
		
		
		
		
		return false;
	}
	
}

