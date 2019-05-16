package socket;

import java.io.*;
import java.net.Socket;

/**
 * Client class to send data to server using a socket.
 */
public class Client {

    public static void main(String[] args) {

        try {
            //Takes ip address and port #. Since our server is on this machine, we don't specify an ip address.
            String ip = "localhost";
            int port = 9999;
            Socket socket = new Socket(ip, port);

            String str = "Jesse Tice";

            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os,true);
            out.println(str);
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String initials = br.readLine();

            System.out.println("C: Data from Server - \"" + initials + "\"");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
