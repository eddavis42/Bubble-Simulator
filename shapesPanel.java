
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import static java.lang.Math.abs;

public class shapesPanel extends JPanel implements ActionListener{
    static int width;
    static int height;
    ArrayList<Bubble> bubbles = new ArrayList<>();

    shapesPanel(int width, int height){
        this.width = width;
        this.height = height;


        setPreferredSize(new Dimension(width,height));
        addBubble(width,height);

        setBackground(Color.BLACK);


        Timer timer = new Timer(10, this);
        timer.setInitialDelay(0);
        timer.start();

        /**
         * As an additional way to interact with the painting, the
         * mouseClicked event triggers an iteration through the list of
         * bubbles to identify if any were within distance of the click, and
         * if so removes them from the collection, "popping" them, and
         * increases the bubbles popped counter, which is displayed in the
         * tracker panel.
         */
        addMouseListener ( new MouseAdapter() {
            public void mouseClicked ( MouseEvent ev) {
                for (int i = 0; i< bubbles.size(); i++){
                    if(abs(ev.getX() - bubbles.get(i).xPosition)<
                            (bubbles.get(i).radius) &&
                            abs(ev.getY() - bubbles.get(i).yPosition)<
                                    (bubbles.get(i).radius) ){
                        bubbles.remove(i);
                        BubbleSimulator.popBubble();
                        i=0;
                    }
                }
            }
        });

    }

    /**
     * Helper method called to create a new bubble, called by the
     * LayoutPractice class
     * @param width Width of the current window
     * @param height Height of the current window
     */
    void addBubble(int width,int height) {
        bubbles.add(new Bubble(width,height));
    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i< bubbles.size(); i++){
            bubbles.get(i).draw(g);
        }
    }

    /**
     * Adjusts the positions of the bubbles and repaints every time the timer
     * calls the action performed,to animate the bubbles
     * @param e Action event e called by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        for (int i = 0; i< bubbles.size(); i++){
            bubbles.get(i).animate(getWidth(),getHeight());
            repaint();

        }
    }
}
