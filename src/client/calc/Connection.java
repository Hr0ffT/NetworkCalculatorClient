package client.calc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

    private int serverPort;
    InetAddress ipAddress;
//    private String serverAddress;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    boolean connected;

    public Connection() {
        showConnectionDialog(ConnectionDialog.DEFAULT_TITLE);

        try {
            createSocket();
            createInOutStreams(socket);
        } catch (IOException e) {
            showConnectionDialog(ConnectionDialog.INCORRECT_INPUT);
        }

        if (socket != null) {
            connected = true;
        }

    }

    private void createSocket() throws IOException {
            this.socket = new Socket(ipAddress, serverPort);
    }

    private void createInOutStreams(Socket socket) throws IOException {

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

    }


    private void showConnectionDialog(String title) {
        new ConnectionDialog(this, title);
//        serverPort = connectionDialog.getServerPort();
//        serverAddress = connectionDialog.getServerAddress();
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
