import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 6789);
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream())) {
            
            String message = "Hello from client\n";
            outToServer.writeBytes(message);
            
            String serverResponse = inFromServer.readLine();
            System.out.println("Received from server: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
