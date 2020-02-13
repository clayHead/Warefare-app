package clayHead.warfare.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import clayHead.warfare.*;

public class StandardGUI extends JFrame implements ActionListener {
    // Buttons
    private JButton test = new JButton("Test");
    private JButton close = new JButton("Close");
    private JButton newA = new JButton("New");
    private JButton run = new JButton("Run");

    // Panels

    // Plain text area
    private TextArea printArea = new TextArea(100,100);

    // Labels
    private JLabel welclayHeade = new JLabel("WelclayHeade to /u/clayHead152's Warfare simulator!");
    private JLabel instructions = new JLabel(
        "Use the 'New' button below to start a new simulation." +
        "\nOnce ready, press the 'Run' button below" +
        "\nFor further help, use the 'Help' option on the menu bar."
    );

    // Menu Bar items
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu help = new JMenu("Help");
    JMenu opts = new JMenu("Options");  
    JMenuItem open = new JMenuItem("Open");
    JMenuItem saveAs = new JMenuItem("Save as");

    public StandardGUI() {
        addclayHeadponents();
    }

    private void addclayHeadponents() {
        //Creating the Frame
        JFrame frame = new JFrame("Warfare Simulator v0.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        //Creating the MenuBar and adding components
        JMenuBar menu = new JMenuBar();
        menu.add(file);
        menu.add(help);
        menu.add(opts);
        file.add(open);
        file.add(saveAs);

        //Creating the panel at bottom and adding clayHeadponents
        JPanel panelBottom = new JPanel(); // the panel is not visible in output
        panelBottom.add(newA); // comdponents Added using Flow Layout
        panelBottom.add(run);

        // Content in the center
        // TODO content in the center
        JPanel panelMiddle = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JTextArea battleInfo = new JTextArea();
        JTextArea unitInfo = new JTextArea();
        JButton inspectUnit = new JButton();
        panelMiddle.add(welclayHeade, c);
        panelMiddle.add(instructions, c);
        panelMiddle.add(battleInfo, c);
        panelMiddle.add(unitInfo, c);
        panelMiddle.add(inspectUnit, c);

        //Adding components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panelBottom);
        frame.getContentPane().add(BorderLayout.NORTH, menu);
        frame.getContentPane().add(BorderLayout.CENTER, panelMiddle);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String actioncommand = e.getActionCommand();

        if (actioncommand.equals("")) {
            System.out.println("Yay!");
            printArea.append("\nYay!");
        }
        else if (actioncommand.equals("Close")) {
            this.dispose();
            System.exit(0);
        }
        else if (actioncommand.equals("New")) {
            AddArmyGUI add = new AddArmyGUI();
        }
    }

    public static void main(String[] args) {
        StandardGUI gui = new StandardGUI();
    }
}
