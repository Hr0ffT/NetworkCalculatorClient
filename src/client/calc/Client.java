package client.calc;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {

        int serverPort = 6666;

        String address = "127.0.0.1";

        try {

            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");

            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            String line2 = null;

            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");

            System.out.println();

            while (true) {

                line = keyboard.readLine();

                System.out.println("Sending the line to the server...");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                line2 = in.readUTF();
                System.out.println("The serfer sent me this: " + line);
                System.out.println("The serfer sent me this: " + line2);
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
