package client.calc;

import javax.swing.*;
import java.io.IOException;

public class Runner {

    static MainWindow mainWindow;

    public static void main(String[] args) {

        Connection connection = new Connection();
        Sender sender = new Sender(connection);

        if (connection.isConnected()) {
            mainWindow = new MainWindow(sender);

            while (connection.isConnected()) {
                mainWindow.changeStatusLabel("Connected to "  + connection.getFullAddress().substring(1));

                try {

                    final String displayText = connection.getInputStream().readUTF();
                    mainWindow.display(displayText);
                    System.out.println(displayText);

                } catch (IOException e) {
                    mainWindow.changeStatusLabel("Connection lost");
                    System.out.println("Connection lost");
                    connection.setConnected(false);
                    int option = JOptionPane.showConfirmDialog (null, "The connection is lost! \n Do you want to reconnect?","Disconnected", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        connection.connect(ConnectionDialog.DEFAULT_TITLE);
                    } else {
                        System.exit(0);
                    }
                }

            }
        }
    }
}
