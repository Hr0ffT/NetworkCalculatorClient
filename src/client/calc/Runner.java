package client.calc;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {

        Connection connection = new Connection();
        Sender sender = new Sender(connection);
        MainWindow mainWindow = new MainWindow(sender);


        while (true) {

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
