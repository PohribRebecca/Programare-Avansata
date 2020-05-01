import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {

    static  DataInputStream  input   = null;
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line = "";
            input  = new DataInputStream(System.in);
            while (!(line.equals("stop"))) {
                try {
                    line = input.readLine();
                    out.println(line);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            try
            {
                in.close();
                out.close();
                socket.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
           /* String request = "";
            request=System.console().readLine();
            out.println(request);
            String response = in.readLine();
            System.out.println(response);*/

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
