package client.calc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

    private int serverPort;
    private String serverAddress;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public int serverPort() {
        return serverPort;
    }

    public void setServerPort(int port) {
        this.serverPort = port;
    }

    public String address() {
        return serverAddress;
    }

    public void setAddress(String address) {
        this.serverAddress = address;
    }

    public Connection() {
        showConnectionDialog();

        try {
            createSocket();
            createInOutStreams(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSocket() throws IOException {
        try {
            InetAddress ipAddress = InetAddress.getByName(serverAddress);
            this.socket = new Socket(ipAddress, serverPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown host!");
        }

    }

    private void createInOutStreams(Socket socket) throws IOException {

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

    }


    private void showConnectionDialog() {
        final ConnectionDialog connectionDialog = new ConnectionDialog();
        serverPort = connectionDialog.getServerPort();
        serverAddress = connectionDialog.getServerAddress();
    }
}