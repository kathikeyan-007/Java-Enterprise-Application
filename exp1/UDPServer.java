import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            
            System.out.println("UDP Server started on port 9876...");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientMessage);
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String response = "Hi 22ITR026";
                sendData = response.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
