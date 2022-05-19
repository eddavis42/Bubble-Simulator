

import java.awt.*;
import java.lang.Math;
import static java.lang.Math.abs;

public class Bubble {
    Color color;
    int diameter;
    int radius;
    int xPosition;
    int yPosition;
    int xSpeed;
    int ySpeed;


    Bubble(int windowWidth, int windowHeight) {
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        color = new Color(red, green, blue);
        int minSize = 50;
        int maxSize = 100;
        diameter = (int) (minSize + Math.random()*(maxSize-minSize+1));
        radius = diameter /2;
        xPosition = diameter+(int)(Math.random()*(windowWidth-(2*diameter)));
        yPosition = diameter+(int)(Math.random()*(windowHeight-(2*diameter)));
        xSpeed = 1 + (int) (Math.random()*3);
        ySpeed = 1 + (int) (Math.random()*3);
    }

    /**
     * Animate method which updates the positions of the bubbles each time
     * they are repainted. The trajectories in the xSpeed and ySpeed
     * variables are made positive or negative if a bubble exits the edges of
     * the window, so it appears to bounce off the edges, and return to view
     * if the window is resized.
     * @param windowWidth Current window width
     * @param windowHeight Current window height
     */
    void animate(int windowWidth,int windowHeight){
        //bounce bubbles off edges of the panel by changing direction
        if(xPosition+radius > windowWidth){
            xSpeed = -abs(xSpeed);
        }
        if(xPosition-radius <0){
            xSpeed = abs(xSpeed);
        }

        if(yPosition+radius > windowHeight){
            ySpeed = -abs(ySpeed);
        }
        if(yPosition-radius <0){
            ySpeed = abs(ySpeed);
        }
        //animate their movement by adjusting the x and y coordinates of each
        // bubble
        xPosition += xSpeed;
        yPosition += ySpeed;

    }

    /**
     * Draws the shape of a bubble, given its properties.
     * @param g Graphics object for painting
     */
    void draw (Graphics g) {
        g.setColor(color);
        g.fillOval(xPosition-radius,yPosition-radius, diameter, diameter);
        g.setColor(Color.WHITE);
        g.fillOval((int) (xPosition+ (radius/4)),
                (int) (yPosition-(radius/1.7)), (int)(radius/3.5),
                (int)(radius/3.5));
    }


}