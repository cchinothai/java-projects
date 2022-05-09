/** Hare class
 *   inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Hare extends Racer
{
    /** Default Constructor: calls Racer default constructor
     */
    public Hare( )
    {
        super( );
    }

    /** Constructor
     *    @param rID   racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Hare( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
    }

    /** move:  calculates the new x position for the racer
     *   Hare move characteristics:  30% of the time, Hare jumps 5 pixels
     *                               70% of the time, Hare sleeps (no move)
     *   generates random number between 1 & 10
     *          for 1 - 7,  no change to x position
     *          for 8 - 10, x position is incremented by 5
     */
    public void move( )
    {
        Random rand = new Random( );
        int move =  rand.nextInt( 10 ) + 1 ;

        if ( getX( ) < 100 )
        {
            if ( move > 7 )
                setX( getX( ) + 5 );
        }
        else
        {
            if ( move > 7 )
                setX( getX( ) + 5 );
        }
    }

    /** draw: draws the Hare at current (x, y) coordinate
     *   @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startY = getY( );
        int startX = getX( );

        //body
        g.setColor( Color.GRAY );
        g.fillOval( startX - 30, startY,  20,  20 );

        //head
        g.fillOval( startX - 13, startY + 2, 13, 8 );
        g.fillOval( startX - 13, startY - 8, 8, 28 );

        //flatten bottom
        g.clearRect( startX - 37, startY + 15, 32, 5 );

        // tail
        g.setColor( Color.LIGHT_GRAY );
        g.fillOval( startX - 37, startY + 8,  12, 12 ) ;
        if(this.isWinner)
        {
            morph(g);
        }
    }

    /**
     * Redraws the Hare to grow a carrot tail and put on a carrot hat if he wins the race
     * @param g Graphics Context
     */
        public void morph(Graphics g)
    {
        int startY = getY( );
        int startX = getX( );

        g.setColor(Color.WHITE);
        g.fillOval(startX - 37, startY + 8, 12, 12);

        g.setColor(Color.ORANGE);
        //carrot head
        int[] xVals = {startX - 13, startX - 9, startX -5, startX-9, startX-13};
        int[] yVals = {startY -4, startY -1, startY -4, startY - 32, startY-4};
        g.fillPolygon(xVals, yVals, 5);
        //carrot tail
        int[] xValsb = {startX - 60, startX - 35, startX - 30, startX - 35, startX - 45};
        int[] yValsb = {startY + 12, startY + 16, startY + 12, startY + 8, startY + 12};
        g.fillPolygon(xValsb, yValsb, 5);

    }
}