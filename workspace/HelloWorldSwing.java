// Ulises Cantor
// Period 5
// 10/9/2025
// Menchukov
// Computer Programming 3
// The program creates a display that starts with three buttons which change the text onscreen, 
// there is also a menu navigation bar at the top to switch between that screen and another saying that I am the best Java Coder


// Note to self:
// j frame is the back, the n there's a root pane, then a layered plane, then a content pane, then a glass pane
// content pane shows stuff, j stuff is outer thing
/*
import javax.swing.*;        
import java.awt.*;
import java.awt.event.*;

public class HelloWorldSwing {*/
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    /*
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainOne = new JPanel(new FlowLayout());

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        JButton button = new JButton("press me");
        mainOne.add(label);
        mainOne.add(button);

        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("you did it");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});
                    JButton button2 = new JButton("don't press me");
        mainOne.add(button2);

        button2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("how dare");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});
                    JButton button3 = new JButton("am not button");
        mainOne.add(button3);

        button3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("maybe i am");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});

        //Display the window.





        JPanel notTheMainFrame = new JPanel();
        notTheMainFrame.add(new JLabel("Uli is the best Java Coder ever"));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Only the most factual information here");

        JMenuItem fra = new JMenuItem("Real");
        JMenuItem noFr = new JMenuItem("Semi-Real");

        menu.add(fra);
        menu.add(noFr);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setContentPane(mainOne);
        frame.pack();
        frame.setVisible(true);

        fra.addActionListener(e -> {
            frame.setContentPane(mainOne);
            frame.revalidate();
            frame.repaint();
        });
        
        noFr.addActionListener(e -> {
            frame.setContentPane(notTheMainFrame);
            frame.revalidate();
            frame.repaint();
        });

    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


*/