package client;


import client.calc.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner implements ActionListener {

    public static void main(String[] args)  {

        final Connection connection = new Connection();
        final MainWindow mainWindow = new MainWindow();


        System.out.println();


        while   (true) {

        }

    }


    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton= (JButton)event.getSource();
//        handleInput(clickedButton);
    }
}
