import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6789)) {
            System.out.println("TCP Server started on port 6789...");
            while (true) {
                try (Socket connectionSocket = serverSocket.accept();
                     BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                     DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream())) {
                    
                    String clientMessage = inFromClient.readLine();
                    System.out.println("Received from client: " + clientMessage);
                    
                    String response = "Hi \n";
                    outToClient.writeBytes(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

