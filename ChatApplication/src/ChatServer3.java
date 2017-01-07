// Import statements
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Assignment: Chat Applications
 * Date: 22nd December 2016
 * @author Kieran Ryan: eeu444
 * @author Dainel Jones: eeu---
 */

public class ChatServer3
{
    /**
     * The server port and address
     */
    private Socket socket;
    private ServerSocket server;
    /**
     * 
     * @param port
     * @throws IOException 
     */
    public ChatServer3(int port) throws IOException
    {
        server = new ServerSocket(port);
        System.out.println("Server started" + server);
        System.out.println("Waiting for connection...");
        while(true)
        {
            socket = server.accept();
            System.out.println("Socket created: " + socket);
            System.out.println("Connected to client...");
            //Takes input from client
            Scanner in = new Scanner(socket.getInputStream());

            ChatService service = new ChatService(socket);
            Thread t = new Thread(service);
            t.start();
         }
    }
    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        ChatServer client;
        if (args.length != 1) { System.out.println("Usage: java ChatServer port"); }
        
        else{ int port = Integer.parseInt(args[0]);  client = new ChatServer(port); }
    }
}

