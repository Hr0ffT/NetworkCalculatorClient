package client.calc;


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
        try {
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() throws IOException {
        connection.getOutputStream().writeUTF(buttonText);
    }
}
