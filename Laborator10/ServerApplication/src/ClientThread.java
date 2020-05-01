import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread {
    private  ServerSocket serverSocket;
    private Socket socket = null;

    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket=serverSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request = "";
            while (!request.equals("stop")) {
                try {
                    if (request.equals("exit")) {
                        serverSocket.close();

                    }
                    request = in.readLine();
                    System.out.println("Am primit comanda " + request);
                } catch (IOException i) {
                    System.out.println(i);
                }
                out.flush();
            }

            System.out.println("Se doreste inchiderea conexiunii");
            socket.close();
            in.close();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }


}


