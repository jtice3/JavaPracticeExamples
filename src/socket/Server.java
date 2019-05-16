package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Two-way communication using socket.  We're sending data from the client side to the server side and printing it.
 * We're then using the data sent to the Server and making an abbreviation to then send back to the client.
 */
public class Server {

    public static void main(String[] args) {
        try {
            //This ServerSocket is used for accepting incoming client connection requests.
            System.out.println("S: Server is started ...");
            ServerSocket ss = new ServerSocket(9999);

            //Accept listens for a connection and returns socket object, which is then used for communication.
            System.out.println("S: Server is waiting for client request.");
            Socket socket = ss.accept();
            System.out.println("S: Client connected");

            //Using buffered reader to fetch/read data from the socket.
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();
            System.out.println("S: Client data: " + str);

            //Manipulating the data to create initials or an abbreviation of the first two words
            String[] abbreviate = str.split(" ");
            String initials = abbreviate[0].substring(0,1) + abbreviate[1].substring(0,1);

            //Using OutputStreamWriter to send data.
            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os,true);
            out.println(initials);
            os.flush();
            System.out.println("S: Data sent from Server to Client");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
