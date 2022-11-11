import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class SimpleHTTPServer {

    public static void main(String args[] ) throws IOException {

        try (ServerSocket server = new ServerSocket(8081)) {
          System.out.println("Listening for connection on port 8081 ....");
          while (true) {
              try(Socket clientSocket = server.accept()) {
                
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));

              InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
              BufferedReader reader = new BufferedReader(isr);
              String line = reader.readLine();            
              while (!line.isEmpty()) {
                  System.out.println(line);
                  line = reader.readLine();
          }
        }
      }
    }
  }

}