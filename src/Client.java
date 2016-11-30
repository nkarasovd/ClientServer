import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) throws IOException {

        InetAddress addr = InetAddress.getByName("www.math.spbu.ru");

        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, Server.PORT);
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);

            out.println("GET /index.htm /HTTP/1.0\r\n\r\n ");
            out.flush();

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }



        }
        finally {
            socket.close();
        }
    }
}