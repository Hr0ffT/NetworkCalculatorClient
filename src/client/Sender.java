package client;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Sender implements ActionListener {


    String buttonText;
    Connection connection;

    public Sender(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton)event.getSource();
        buttonText =  clickedButton.getText();
        System.out.println(buttonText);
        try {
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() throws IOException {
        connection.out.writeUTF(buttonText);
    }
}
