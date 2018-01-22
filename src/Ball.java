/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/* Ball
** Implements a Ball as used in the game of Pong.
** A ball moves a distance in the x & y direction
** every time act is called.
** When a ball bounces off a surface, it reverses
** either its x or y direction.
*/

import csta.ibm.pong.GameObject;

public class Ball extends GameObject 
{
	// Add any state variables here
	private  double  dx = 3; // indicates how far ball moves in x direction each time step
	private  double  dy = 3; //indicates how far ball moves in y direction each time step
	
	//Constructors
	public Ball(int x, int y)
	{
		setX(x);
		setY(y);
		setSize(10,10);
	}
	public Ball(int x, int y, int width, int height)
	{
		setX(x);
		setY(y);
		setSize(width,height);
	}
	/**
	 * Fill in this method with code that describes the behavior
	 * of a ball from one moment to the next 
	 */

	// called every time step. moves the ball according to velocityX/Y
	public void act() 
	{
		setX((int)(getX()+dx));
		setY((int)(getY()+dy));
	}

	// Add any additional methods here

	/**
	 * When the ball collides with paddlew, it will bounce
	 */
	// precondition: paddle is on two sides
	// reverses the x direction of the ball
	public void bouncePaddle(){ dx *= -1; }

	/**
	 * When the ball collides with top and bottom, it will bounce
	 */
	// precondition: walls are on the top and bottom
	// reverses the y direction of the ball
	public void bounceWall()
	{
		dy *= -1;
	}



	
}
