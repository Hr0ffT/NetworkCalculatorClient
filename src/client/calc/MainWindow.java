package client.calc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {
    JPanel mainPanel;
    JPanel numbersPanel;
    JPanel operationsPanel;
    JPanel rightPanel;
    JPanel bottomPanel;
    JFrame frame;
    JLabel statusLabel;

    JTextField displayField;

    List<JButton> numButtons;
    List<JButton> operationButtons;

    BorderLayout borderLayout;
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout rightGridLayout3;
    BorderLayout bottomBorderLayout;

    Sender sender;

    public MainWindow(Sender sender) {

         this.sender = sender;

        this.mainPanel = new JPanel();
        this.numbersPanel = new JPanel();
        this.operationsPanel = new JPanel();
        this.rightPanel = new JPanel();
        this.bottomPanel = new JPanel();

        this.borderLayout = new BorderLayout(1,1);
        this.gridLayout1 = new GridLayout(0, 3);
        this.gridLayout2 = new GridLayout(2,0);
        this.rightGridLayout3 = new GridLayout(0,1);
        this.bottomBorderLayout = new BorderLayout(1,1);


        this.displayField = new JTextField(15);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        this.frame = new JFrame("Calc");
        this.numButtons = new ArrayList<>();
        this.operationButtons = new ArrayList<>();
        this.statusLabel = new JLabel("PIPISKA");
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        displayField.setFont(font1);


        String OPERATIONS = "+-*/";

        for (int i = 0; i < OPERATIONS.length(); i++) {
            operationButtons.add(new JButton(String.valueOf(OPERATIONS.charAt(i))));

        }

        for (int i = 1; i < 10; i++) {
            numButtons.add(new JButton(String.valueOf(i)));
        }
        numButtons.add(new JButton("0"));
        numButtons.add(new JButton("."));

        for (JButton numButton : numButtons) {
            numbersPanel.add(numButton);
        }

        for (JButton operationButton : operationButtons) {
            operationsPanel.add(operationButton);
        }

        JButton clear = new JButton("C");
        JButton equalsButton = new JButton("=");
        JButton percentButton = new JButton("%");

        mainPanel.setLayout(borderLayout);
        numbersPanel.setLayout(gridLayout1);
        operationsPanel.setLayout(gridLayout2);
        rightPanel.setLayout(rightGridLayout3);
        bottomPanel.setLayout(bottomBorderLayout);

        rightPanel.add(clear);
        rightPanel.add(percentButton);
        rightPanel.add(equalsButton);

        bottomPanel.add("North", operationsPanel);
        bottomPanel.add("South", statusLabel);

        mainPanel.add("North", displayField);
        mainPanel.add("Center", numbersPanel);
        mainPanel.add("East", rightPanel);
        mainPanel.add("South", bottomPanel);

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);

        for (JButton numButton : numButtons) {
            numButton.addActionListener(sender);
        }
        for (JButton actionButton : operationButtons) {
            actionButton.addActionListener(sender);
        }

        for (JButton actionButton : operationButtons) {
            actionButton.setFont((new Font("Arial", Font.BOLD, 15)));
        }

        clear.addActionListener(sender);
        equalsButton.addActionListener(sender);
        percentButton.addActionListener(sender);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void terminate() {
        System.out.println("Closed");
        System.exit(0);
    }
}