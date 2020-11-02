import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * This program has a count button that goes up as it is clicked, stopping at 10
 * @author Thomas Quigley
*/

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton countButton;
  JButton resetButton;

  JLabel counterLabel;
  JTextField counterField;

  // create the count variable
  int count = 0;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 400 pixels by 200 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Counter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,200);
    frame.setVisible(true);

    // make the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    // make the two buttons and add them to the frame
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");

    countButton.setBounds(50, 50, 150, 30);
    resetButton.setBounds(200, 50, 150, 30);

    countButton.setActionCommand("count");
    resetButton.setActionCommand("reset");

    countButton.addActionListener(this);
    resetButton.addActionListener(this);

    mainPanel.add(countButton);
    mainPanel.add(resetButton);

    // make the label and add it to the frame
    counterLabel = new JLabel("Counter:");
    counterLabel.setBounds(50, 100, 100, 30);
    mainPanel.add(counterLabel);

    // make the text field and add it to the frame
    counterField = new JTextField("0");
    counterField.setBounds(140, 95, 200, 40);
    counterField.setEnabled(false);
    mainPanel.add(counterField);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // find out what button was pressed
    if (command.equals("reset")) {
      // reset the count in the counterField to 0
      counterField.setText("0");
      
      // set count to 0
      count = 0;

    } else if (command.equals("count")) {
      // until the count gets to 10 add 1 when clicked
      if (count < 10) {
        count = count + 1;
        counterField.setText("" + count);
      }
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
