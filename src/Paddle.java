/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/* Paddle class
** Implements behavior of a paddle for the game of pong
** The paddle can move side to side and can collide with the ball
*/


import csta.ibm.pong.GameObject;


public class Paddle extends GameObject
{
	// Add any state variables here

	//Constructors
	public Paddle(int x, int y){
		setX(x);
		setY(y);
		setSize(10,50);
	}
	public Paddle(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setSize(width,height);

	}

	/**
	 * Fill in this method with code that describes the behavior
	 * of a paddle from one moment to the next 
	 */


	// Act the paddle.
	public void act()
	{
		setX(getX());
	}

	// Add any additional methods here

	/**
	 * Use key to move the paddle up
	 */
	// the paddle moves up
	public void moveUp(){
		if(this.getY() > 0){
			setY(getY()-4);
		}
	}

	/**
	 * Use key to move the paddle down
	 */
	// the paddle moves down
	public void moveDown(){

		setY(getY()+4);

	}



}
