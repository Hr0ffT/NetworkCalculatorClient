package client.calc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {

    private int serverPort;
    private InetAddress ipAddress;
    private Socket socket;

    private DataInputStream in;
    private DataOutputStream out;

    private boolean connected;

    public void connect(String title){
        showConnectionDialog(title);
        connected = true;

        try {
            createSocket();
            createInOutStreams(socket);

        } catch (IOException e) {
            connect(ConnectionDialog.INCORRECT_INPUT);
            System.out.println("фывыв");
//            connected = false;
        }


    }

    public Connection() {
        connected = false;
        connect(ConnectionDialog.DEFAULT_TITLE);
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
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getFullAddress() {
        return ipAddress + ": " + serverPort;
    }

    public boolean isConnected() {
        return connected;
    }

    public DataInputStream getInputStream() {
        return in;
    }

    public DataOutputStream getOutputStream() {
        return out;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
