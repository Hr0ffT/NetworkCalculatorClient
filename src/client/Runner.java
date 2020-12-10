package client;


import client.calc.MainWindow;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        final Connection connection = new Connection();
        final Sender sender = new Sender(connection);
        final MainWindow mainWindow = new MainWindow(sender);



        System.out.println();


        while   (true) {

        }

    }



}
