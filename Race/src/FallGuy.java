/**
 * Program 4: TortoiseAndTheHare/FallGuy
 * FallGuy class is a type of Racer and extends the Racer class. It uses its own unique characteristics
 * within move(), draw(), and morph()
 * CS108-3
 * 10/13/2020
 * @author Cody Chinothai
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class FallGuy extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public FallGuy( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public FallGuy( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }

    /** move:  calculates the new x position for the racer
     *   FallGuy move characteristics: Energetic but temporary run hop
     *      increment x by 2 for the first 250 units (getX) while jumping up and down 5 units
     *      increment x by 1 once FallGuy has moved more than 250 units (getX)
     */
    public void move( )
    {
        int move =  rand.nextInt( 100 )  + 1;
        if( getX() < 250) {
            if (move < speed)
                setX(getX() + 2);

            if (getX() % 5 == 1) {
                setY(getY() + 5);

            }
            if (getX() % 10 == 0) {
                setY(getY() - 5);
            }
        }
        else if( getX() > 200 )
        {
            setX(getX() + 1);
        }


    }

    /** draw: draws the Tortoise at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );

        int randA = (int)(Math.random()*256);
        int randB = (int)(Math.random()*256);
        int randC = (int)(Math.random()*256);

        g.setColor(new Color(randA,randB,randC)); // random color



        //body
        g.fillOval( startX - 25, startY, 23,35 );
        g.fillOval(startX - 25, startY - 1, 22,22);
        g.fillOval( startX - 25, startY + 15 ,22, 22);

        //feet

        g.fillOval( startX - 21, startY + 32,  7, 10 );
        g.fillOval( startX - 13, startY + 32, 7, 10 );

        //arms

        g.fillOval(startX - 35, startY + 11, 15,7);
        g.fillOval(startX - 6, startY +11, 15,7);

        //head
        g.setColor(Color.WHITE);
        g.fillOval( startX - 21, startY +3,  14, 16 );

        //eyes
        g.setColor(Color.BLACK);
        g.fillOval(startX - 18, startY + 9, 3, 5);
        g.fillOval(startX - 13, startY + 9, 3, 5);

        g.setColor(new Color(randA,randB,randC));
        if(this.isWinner)
        {
            morph(g);
        }


    }

    /**
     * Redraws the Racer to flex his arms and put on a crown if he wins the race
     * @param g Graphics Context
     */
    public void morph( Graphics g)
    {
        int startX = getX( );
        int startY = getY( );

        //body
        g.fillOval( startX - 25, startY, 23,35 );
        g.fillOval(startX - 25, startY - 1, 22,22);
        g.fillOval( startX - 25, startY + 15 ,22, 22);

        //flexing arms
        g.setColor(g.getColor());
        g.fillOval(startX - 35, startY + 11, 15,7);
        g.fillOval(startX - 6, startY +11, 15,7);
        g.fillOval(startX - 35, startY + 5, 4, 10);
        g.fillOval(startX + 5, startY + 5, 4, 10 );

        //feet
        g.fillOval( startX - 21, startY + 32,  7, 10 );
        g.fillOval( startX - 13, startY + 32, 7, 10 );



        //head
        g.setColor(Color.WHITE);
        g.fillOval( startX - 21, startY +3,  14, 16 );

        //eyes
        g.setColor(Color.BLACK);
        g.fillOval(startX - 20, startY + 9, 5, 3);
        g.fillOval(startX - 13, startY + 9, 5, 3);

        //crown
        g.setColor(new Color(251,192,45));
        g.fillRoundRect(startX - 23, startY - 8, 18,6, 3,3);
        g.fillOval(startX - 23, startY - 12, 4, 4);
        g.fillOval( startX - 16, startY - 12, 4, 4 );
        g.fillOval( startX - 10, startY - 12, 4, 4);

    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this tortoise moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 90;
    }
}

