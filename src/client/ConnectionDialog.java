package client;

import javax.swing.*;

public class ConnectionDialog {

     JTextField portField;
     JTextField addressField ;



    private  String serverAddress;
    private  int serverPort;



    public ConnectionDialog() {
        this.portField = new JTextField();
        this.addressField = new JPasswordField();

        Object[] message = {
                "IP address:", addressField,
                "Port:", portField
        };

        JOptionPane.showInputDialog(null, message,"Connection", JOptionPane.PLAIN_MESSAGE);
        serverAddress =  addressField.getText();
        System.out.println(serverAddress);
//        try {
//            serverPort = Integer.parseInt(portField.getText());
//            System.out.println(serverPort);
//        } catch (NumberFormatException exception) {
//            exception.printStackTrace();
//            System.out.println("Incorrect number.");
//        }

    }
}


