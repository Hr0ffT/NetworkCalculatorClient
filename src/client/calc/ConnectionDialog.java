package client.calc;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;

public class ConnectionDialog {

    Connection connection;
    JPanel panel;

    JTextField portField;
    JTextField addressField;

    JLabel addressLabel;
    JLabel portLabel;
    GridLayout gridLayout;

    public static final String DEFAULT_TITLE = "Connection";
    public static final String INCORRECT_INPUT = "Некорректный адрес или порт";

    public ConnectionDialog(Connection connection, String title) {

        this.connection = connection;
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

        showDialog(title);
    }

    private boolean incorrectInput() {
        System.out.println("Checking");
        return parsePort() && parseInetAddress();
    }

    private void showDialog(String title) {
        int option = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.DEFAULT_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("yes");
            while (!incorrectInput()) {
                showDialog(INCORRECT_INPUT);
            }
        } else terminate();
    }

    private boolean isCorrectAddress(String input) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return input.matches(PATTERN);
    }

    private boolean parsePort() {
        try {
            connection.setServerPort(Integer.parseInt(portField.getText()));

            return true;
        } catch (NumberFormatException e) {
            System.out.println("Некорректный порт");
            return false;
        }
    }

    private boolean parseInetAddress() {
        System.out.println("Parsing address");
        String host = addressField.getText();
        if (isCorrectAddress(host)) {
            try {
                InetAddress inet = InetAddress.getByName(host);
                if (inet.isReachable(100)) {
                    connection.setIpAddress(inet);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Некорректный адрес");

        }
        return false;
    }

    private void terminate() {
        System.out.println("Closed");
        System.exit(0);
    }

}


