package vtp2022.day4.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    
    public static void main(String[] args){
        // retrieve server port number from the first argument
        String serverPort = args[0];
        // retrieve cookie file from the second argument
        String cookieFilePath = args[1];
        
        try {
            System.out.printf("Cookie Server Started at %s\n", serverPort);
        
            // Instantiate the server socket class along with the port number
            ServerSocket server = new ServerSocket(Integer.parseInt(serverPort));
            // Waiting for connection from the client side
            Socket sock = server.accept();
            // Get the input and out stream in bytes
            InputStream is = sock.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            String requestFromClient = dis.readUTF();
            System.out.printf("Received request from client : %s\n ", requestFromClient);
            
            if(requestFromClient.equals("get-cookie")){
                System.out.printf("file -> %s\n", cookieFilePath);
                
                String randomCookie = Cookie.getRandomCookie(cookieFilePath);
                System.out.println(randomCookie);
                dos.writeUTF("cookie-text "+randomCookie);
            }else{
                dos.writeUTF("Invalid command !");
            }   
            
            is.close();
            os.close();

            sock.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }   
}
