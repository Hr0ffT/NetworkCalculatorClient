package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {


    private int serverPort;
    private String serverAddress;
    Socket socket;

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

    public Connection(int serverPort, String serverAddress) {
        this.serverPort = serverPort;
        this.serverAddress = serverAddress;
        createSocket(serverPort, serverAddress);

    }

    private void createSocket(int port, String address) {
        try {
            this.socket = new Socket(address, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown host!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
