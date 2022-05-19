# Bubble-Simulator
A simple game made using Java swing elements, to fulfill an assignment to use Layouts for CS152L at UNM, in Spring of 2022.
The game consists of three classes: Bubble, shapesPanel, and BubbleSimulator. To run, compile all three classes and run BubbleSimulator, which contains
the main thread. Alternatively, just run the jar file.

The shapesPanel class creates a panel in which to populate with bubbles. It calls the Bubble constructor to create new Bubble objects, and uses ther Jaa swing timer to update the Bubble objects' positions and repaint them using paintComponent to show them animating. It also implements a MouseListener to allow interaction with the bubbles, such that if the user clicks within the radius of a bubble, then the object is removed from the list of bubbles being drawn and animated.

The Bubble class is used for every bubble created. The Bubble constructor randomly assigned a starting location, size, speed, and color for each bubble, and the animate() and draw() methods are used to update a bubble's location and draw it at it's current location. The animate method increments or decrements a bubble's coordinates to change it's position, and reverses the direction as necessary when a bubble reaches the sides of the panel to create the effect of "bouncing" the bubbles of the edges of the window and preventing bubbles from becoming stuck outside the visible window.

The BubbleSimulator class contains the main method, where it constructs itself. The constructor used JFrame to create a new window, and calls the shapesPanel constructor to add a panel housing the bubbles to the frame. It adds panels above and below the shapesPanel, where the lower panel contains a button to add a new bubble, and a button to bring up a dialog box with directions for playing. The upper panel tracks how many bubbles the player has created and how many popped.

