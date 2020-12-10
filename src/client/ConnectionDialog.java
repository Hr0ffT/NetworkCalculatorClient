package client;

import javax.swing.*;
import java.awt.*;

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


        Object[] message = {
                "", addressField
//                ,                "Port:", portField
        };

        int connection = JOptionPane.showConfirmDialog(null, panel, "Connection", JOptionPane.DEFAULT_OPTION);
        serverAddress =  addressField.getText();
        System.out.println(serverAddress);
        try {
            serverPort = Integer.parseInt(portField.getText());
            System.out.println(serverPort);
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            System.out.println("Incorrect number.");
        }

    }

    public String getServerAddress() {
        return serverAddress;
    }

    public int getServerPort() {
        return serverPort;
    }
}


