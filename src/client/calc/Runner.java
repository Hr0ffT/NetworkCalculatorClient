package client.calc;

import java.io.IOException;

public class Runner {

    static  MainWindow mainWindow;

    public static void main(String[] args) {

        Connection connection = new Connection();
        Sender sender = new Sender(connection);

    if (connection.connected) {
        mainWindow = new MainWindow(sender);
        while (connection.connected) {

            try {
                final String displayText = connection.in.readUTF();
                mainWindow.displayField.setText(displayText);
                System.out.println(displayText);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    }
}
