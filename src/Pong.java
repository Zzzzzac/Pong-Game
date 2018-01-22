/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/* Pong
** Implements the game of Pong
** by creating two paddles and a ball and
** bouncing the ball off the walls and deflecting
** the ball on a paddle.
** The ball and the paddles implement behavior that
** is critical to the operation of the game.
*/
import csta.ibm.pong.Game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.Font;


public class Pong extends Game
{
	// Add any state variables or object references here

	/* Create 2 paddles and a ball and JLabels*/
	public Ball ball;
	public Paddle paddle1, paddle2;
	private int p1score = 0, p2score = 0;
	private JLabel compareLabel, p1ScoreLabel,p2ScoreLabel;
	private boolean musicPlay = true;






	/**
	 * Fill in this method with code that tells the game what to do
	 * before actual play begins
	 */

	/* Makes the paddles and ball the specified sizes and
	** adds them to the game
	** Sets the initial position of the ball */
	public void setup()
	{
		// JLabel setting
		compareLabel = new JLabel();
		p1ScoreLabel = new JLabel();
		p2ScoreLabel = new JLabel();
		p1ScoreLabel.setForeground(Color.white);
		p1ScoreLabel.setBounds((int)(getFieldWidth()/4.0), 0, 200, 20);
		p1ScoreLabel.setText(""+p1score);
		p1ScoreLabel.setFont(new Font("Courier New", Font.ITALIC, 18));
		p2ScoreLabel.setForeground(Color.white);
		p2ScoreLabel.setBounds((int)(getFieldWidth()/4.0*3.0), 0, 200, 20);
		p2ScoreLabel.setText(""+p2score);
		p2ScoreLabel.setFont(new Font("Courier New", Font.ITALIC, 18));
		compareLabel.setForeground(Color.white);
		compareLabel.setBounds(getFieldWidth()/2,0,200,20);
		compareLabel.setText("vs");
		add(p1ScoreLabel);
		add(p2ScoreLabel);
		add(compareLabel);
		repaint();

		// Object setting
		paddle1 = new Paddle(0,100);
		add(paddle1);
		paddle2 = new Paddle(getFieldWidth()-paddle1.getWidth(), 100);
		add(paddle2);
		gameInstruction();
		ball = new Ball(100,100);
		add(ball);

		setDelay(8);
		// Background music setting
		try
		{
			Music.load();
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		this.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e)
			{

			}

			public void keyPressed(KeyEvent e)
			{

			}

			public void keyReleased(KeyEvent e) // KeyReleased Events.
			{
				int id = e.getKeyCode();
				if (id == KeyEvent.VK_V)
				{
					if (musicPlay)
					{
						Music.pause();
						musicPlay = false;
					} else
					{
						Music.resume();
						musicPlay = true;
					}
				}
			}
		});
	}

	/**
	 * Fill in this method with code that tells the playing field what to do
	 * from one moment to the next
	 */

	/* Every step of time act() is called.
	** This detects whether a key is pushed which
	** causes the paddles need to move
	** and whether a collision has occured which causes the
	** ball to bounce or deflect
	*/
	public void act()
	{
		// if ball and paddle collide, the ball will be bounced
		if (ball.collides(paddle1) || paddle1.collides(ball))
		{
			ball. bouncePaddle();
			ball.setX(ball.getX()+ball.getWidth()+1);
		}
		if (ball.collides(paddle2) || paddle2.collides(ball))
		{
			ball. bouncePaddle();
			ball.setX(ball.getX()-ball.getWidth()+1);
		}
		// if m is pressed and the paddle is not off the screen, move p2 down
		if (MKeyPressed() && paddle2.getY() < getFieldHeight() - paddle2.getHeight())
		{
			paddle2.moveDown();
		}
		// if n is pressed and the paddle is not off the screen, move p2 up
		if (NKeyPressed())
		{
			paddle2.moveUp();
		}
		// if x is pressed and the paddle is not off the screen, move p1 down
		if (XKeyPressed()&& paddle1.getY() < getFieldHeight() - paddle1.getHeight())
		{
			paddle1.moveDown();
		}
		// if z is pressed and the paddle is not off the screen, move p1 up
		if (ZKeyPressed())
		{
			paddle1.moveUp();
		}
		// if ball hits wall, ball bounces
		if (ball.getY() + ball.getHeight() > this.getFieldHeight() || ball.getY() < 0)
		{
			ball.bounceWall();
		}
		// if ball exceeds out of the paddles, game ends
		if (ball.getX() < 0)
		{
			p2score++;
			resetBall();
			p2ScoreLabel.setText(""+p2score);


			if (p2score == 10)
			{
				stopGame();
				p2Wins();
				remove(ball);
				remove(paddle1);
				remove(paddle2);
			}
		}
		if (ball.getX() + ball.getWidth()> getFieldWidth())
		{
			p1score++;
			resetBall();
			p1ScoreLabel.setText(""+p1score);

			if (p1score == 10)
			{
				stopGame();
				p1Wins();
				remove(ball);
				remove(paddle1);
				remove(paddle2);
			}
		}




	}

	// Add any additional methods here

	/**
	 * After the ball exceeds teo sides, reset the position of the ball
	 */
	// When the Player hits the ball and get score, the ball will re-start move from the same side with the player.
	public void resetBall(){
		if (ball.getX() + ball.getWidth()> getFieldWidth()){
			ball.setX(paddle1.getX()+paddle1.getWidth());
		}
		if (ball.getX() < 0){
			ball.setX(getFieldWidth()-paddle2.getWidth());
		}

	}

	/**
	 * Set a dialog before game starting, which contains the instructions of the game
	 */
	// Initial instructions before starting the game
	public void gameInstruction()
	{
		JOptionPane.showMessageDialog(this,
				"Player1: Press Z/M to control the paddle."
						+ "\nPlayer2: Press N/M to control the paddle."
						+ "\nGame end when one player get ten points." +
						"\nPress \'v\' key to turn ON/OFF the background music.",
				"Pong",
				JOptionPane.PLAIN_MESSAGE);
	}




	/**
	 * This code has been provided for you, and should not be modified
	 */
	public static void main(String[] args)
	{
		Pong p = new Pong();
		p.setVisible(true);
		p.initComponents();

	}
}