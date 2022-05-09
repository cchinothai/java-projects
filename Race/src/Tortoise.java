/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Tortoise extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Tortoise( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Tortoise( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }

    /** move:  calculates the new x position for the racer
     *   Tortoise move characteristics: "slow & steady wins the race"
     *      increment x by 1 most of the time
     */
    public void move( )
    {
        int move =  rand.nextInt( 100 )  + 1;
        if ( move < speed )
            setX( getX( ) + 1 );
    }

    /** draw: draws the Tortoise at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );

        g.setColor( new Color( 34, 139, 34 ) ); // dark green

        //body
        g.fillOval( startX - 30, startY, 25, 15 );

        //head
        g.fillOval( startX - 10, startY + 5,  15, 10 );

        //flatten bottom
        g.clearRect( startX - 30, startY + 11, 35, 4 );

        if(this.isWinner)
        {
            morph(g);
        }
        
        //feet
        g.setColor( new Color( 34, 139, 34 ) );  // brown
        g.fillOval( startX - 27, startY + 10,  5, 5 );
        g.fillOval( startX - 13, startY + 10, 5, 5 );


    }

    /**
     * Redraws the tortoise to hold a wooden staff while next to a cherry blossom tree
     * (Kung Fu Panda reference)
     * @param g
     */
    public void morph(Graphics g)
    {
        int startX = getX( );
        int startY = getY( );


        //tree branch
        g.setColor(new Color(121,48,48));
        int[] xVals = {startX+4, startX + 14, startX + 11, startX + 11, startX +7, startX +7, startX + 4};
        int[]yVals = {startY + 18, startY + 18, startY + 14, startY - 2, startY - 2, startY + 14, startY + 18};
        g.fillPolygon(xVals,yVals,7);
        //tree leaves
        g.setColor(new Color(255,205,210));
        g.fillOval(startX, startY - 4, 10,10);
        g.fillOval(startX+7, startY - 4, 10,10);
        g.fillOval(startX + 4, startY - 10,10,10);
        //master oogway staff
        g.setColor(new Color(121,48,48));
        g.fillRect( startX-10, startY -10, 3, 30);

        //int[] xValsb = {startX + 11, startX + 23, startX + 19, startX + 15, startX + 11};
       // int[] yValsb = {startY - 2, startY - 8, startY - 11, startY - 8, startY-2};
        //g.fillPolygon(xValsb, yValsb, 5);
    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this tortoise moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 90;
    }


}