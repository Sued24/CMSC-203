
public class Plot // Private fields with attributes of the plot
{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() // default constructor
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(Plot plot) // copy constructor
	{
		x = plot.getX();
		y = plot.getY();
		width = plot.getWidth();
		depth = plot.getDepth();
	}
	
	public Plot(int x , int y , int width , int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	
	public boolean overlaps(Plot plot) // By far the most challenging method. The overlaps method returns true if two plots are overlapping. False if not
	{
		boolean overlaps = false; // Returned variable, set to false by default
		
		// Simplified variables so they are easier to work with, x,y,w,d belong to the first plot and x2,y2,w2,d2 belong to the second plot
		
		int x = this.x;
		int y = this.y;
		int w = this.width - 1;
		int d = this.depth - 1;
		
		int x2 = plot.getX();
		int y2 = plot.getY();
		int w2 = plot.getWidth() - 1;
		int d2 = plot.getDepth() - 1;
		
		/*
		Works with two if else chains. The first chain calculates if any of the 4 corners of the first plot ( (x,y) (x+w,y) (x,y+d) (x+w,y+d) ) are inside the bounds of the other plot
		the second plot works backwards, doing the same thing with the corners of the second plot.
		*/
		if( ( ( x <= x2 ) && ( x2 <= (x + w) ) ) && ( ( y <= y2 ) && ( y2 <= (y + d) ) ) )
			overlaps = true;
		else if ( ( ( x <= (x2 + w2) ) && ( (x2 + w2) <= (x + w) ) ) && ( ( y <= y2 ) && ( y2 <= (y + d) ) ) )
			overlaps = true;
		else if ( ( ( x <= x2 ) && ( x2 <= (x + w) ) ) && ( ( y <= (y2 + d2) && ( (y2 + d2) <= (y + d) ) ) ) )
			overlaps = true;
		else if ( ( ( x <= (x2 + w2) ) && ( (x2 + w2) <= (x + w) ) ) && ( ( y <= (y2 + d2) ) && ( (y2 + d2) <= (y + d) ) ) )
			overlaps = true;
		
		// If at any point these points are within the bounds of the other plot intersect, select overlaps to true
		
		if( ( ( x2 <= x ) && ( x <= (x2 + w2) ) ) && ( ( y2 <= y ) && ( y <= (y2 + d2) ) ) )
			overlaps = true;
		else if ( ( ( x2 <= (x + w) ) && ( (x + w) <= (x2 + w2) ) ) && ( ( y2 <= y ) && ( y <= (y2 + d2) ) ) )
			overlaps = true;
		else if ( ( ( x2 <= x ) && ( x <= (x2 + w2) ) ) && ( ( y2 <= (y + d) && ( (y + d) <= (y2 + d2) ) ) ) )
			overlaps = true;
		else if ( ( ( x2 <= (x + w) ) && ( (x + w) <= (x2 + w2) ) ) && ( ( y2 <= (y + d) ) && ( (y + d) <= (y2 + d2) ) ) )
			overlaps = true;
		
		return overlaps; // Return overlaps
	}
	
	public boolean encompasses(Plot plot)
	{
		boolean overlaps = false; // Overlaps equals false
		
		/*
		 * Given the way that the plots are generated, I can simply check if the x and y values are of the bigger plot are smaller than the x and y values of the smaller one
		 * and if the width and depth of the bigger plot are bigger than that of the smaller to see if the bigger plot encompasses the smaller one.
		*/
		
		if ( this.x <= plot.getX() && this.width >= plot.getWidth() &&
			 this.y <= plot.getY() && this.depth >= plot.getDepth() )
		{
			overlaps = true;
		}
		
		return overlaps; // Returns true.
	}
	
	// Below are simple get and set methods
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setdepth(int depth)
	{
		this.depth = depth;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public String toString() // To string method, returns a string with information on the class' fields
	{
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
