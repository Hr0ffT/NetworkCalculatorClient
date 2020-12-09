package client;

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

    public Connection(int serverPort, String address) {
        this.serverPort = serverPort;
        this.serverAddress = address;
        try {
            createSocket(serverPort, address);
            createInOutStreams(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSocket(int port, String address) throws IOException {
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            this.socket = new Socket(ipAddress, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown host!");
        }

    }

    private void createInOutStreams(Socket socket) throws IOException {

            in = (DataInputStream) socket.getInputStream();
            out = (DataOutputStream) socket.getOutputStream();

    }


}
