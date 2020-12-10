package client.calc;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ConnectionDialog {
    JPanel panel;

    JTextField portField;
    JTextField addressField;

    JLabel addressLabel;
    JLabel portLabel;
    GridLayout gridLayout;

    private  String serverAddress;
    private  int serverPort;

    public ConnectionDialog() {
        this.portField = new JTextField("6666");
        this.addressField = new JTextField("127.0.0.1");
        this.panel = new JPanel();
        this.addressLabel = new JLabel("IP address:");
        this.portLabel = new JLabel("Port:");
        this.gridLayout = new GridLayout(2,2);
        panel.setLayout(gridLayout);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(portLabel);
        panel.add(portField);
//        final JOptionPane jOptionPane = new JOptionPane();


        int option = showDialog("Connection");

        if (option == JOptionPane.CLOSED_OPTION) {
            System.out.println("Closed");
            System.exit(0);
        } else if (option == JOptionPane.YES_OPTION){
            System.out.println("YES");
            if  (isCorrectAddress(addressField.getText())){
                System.out.println("IP is correct");
                try {
                    serverAddress =  addressField.getText();
                    serverPort = Integer.parseInt(portField.getText());
                    System.out.println(serverPort);
                    System.out.println(serverAddress);
                } catch (NumberFormatException exception) {
                    exception.printStackTrace();
                    System.out.println("Incorrect number.");
                }
            } else  {
                while (!isCorrectAddress(addressField.getText())) {
                    System.out.println("Некорректный адресс, введите еще раз.");
                    int option2 =  showDialog("Некорректный адресс, введите еще раз.");
                    if (option2 == JOptionPane.CLOSED_OPTION) {
                        System.out.println("Closed");
                        System.exit(0);
                    }
                }

            }

        }

    }

    private int showDialog(String title) {
        return JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.DEFAULT_OPTION);


    }

    private boolean isCorrectAddress(String input) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return input.matches(PATTERN);
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public int getServerPort() {
        return serverPort;
    }
}


