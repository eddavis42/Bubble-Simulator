/**
 * Edward Davis
 * edddavis42@gmail.com
 *
 * This is a simple game I made for an intermediate programming class, for an
 * assignment in using Layouts.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleSimulator extends JFrame implements ActionListener {
    int width = 500;
    int height = 500;
    static shapesPanel shapes;
    static int bubblesAdded;
    static int bubblesPopped;
    static JLabel Tracker;

    BubbleSimulator() {
        super (" Bubble Simulator");
        bubblesAdded = 0;
        bubblesPopped=0;
        setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
        setPreferredSize(new Dimension(width,height));
        JPanel upperPanel = new JPanel ();
        Tracker = new JLabel("You have added "+bubblesAdded+" bubbles and"+
                " popped " + bubblesPopped + " bubbles.");
        upperPanel.add (Tracker);
        JPanel buttonPanel = new JPanel();
        /**
         * The bubbleButton creates a dialog box and calls the newBubble
         * ActionListener, which updates the variable bubblesAdded to track
         * how many times the dialog box has been opened, and then update the
         * dialog box message and the Tracker panel message to reflect this.
         * It also calls the shapes panel's addBubble method to interact with
         * the painting by creating a new bubble object and animating it.
         */
        JButton bubbleButton = new JButton("New Bubble");
        ActionListener newBubble = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bubblesAdded++;
                JOptionPane.showMessageDialog(BubbleSimulator.this,
                        "You have added "+bubblesAdded+" bubbles.",
                        "New Bubble",1);
                shapes.addBubble(shapes.getWidth(),shapes.getHeight());
                (Tracker).setText("You have added "+bubblesAdded+" bubbles and" +
                        " popped " + bubblesPopped + " bubbles.");
            }
        };
        bubbleButton.addActionListener(newBubble);

        /**
         * I added a second button that produces a dialog box just for fun
         */
        JButton readMeButton = new JButton("Read Me");
        ActionListener readMe = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BubbleSimulator.this,
                        "Welcome to  Bubble Simulator, the latest in " +
                                "advanced bubble simulation technology. " +
                                "\n Click the " +
                                "New Bubble button to add a new bubble. " +
                                "Click on any bubble to pop it, but you'll " +
                                "have to be quick!",
                        "Bubble Simulator", 1);
            }
        };
        readMeButton.addActionListener(readMe);
        buttonPanel.add(bubbleButton);
        buttonPanel.add(readMeButton);
        add(upperPanel,BorderLayout.PAGE_START);
        add(buttonPanel,BorderLayout.PAGE_END);
        shapes = new shapesPanel(width,height);
        add(shapes);
        pack ();
        setVisible(true);

    }

    /**
     * Helper method updates bookkeeping when a bubble is popped.
     */
    public static void popBubble(){
        bubblesPopped++;
        (Tracker).setText("You have added "+bubblesAdded+" bubbles and" +
                " popped " + bubblesPopped + " bubbles.");
    }


    public static void main(String[] args) {
        BubbleSimulator window = new BubbleSimulator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

