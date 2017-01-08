// Import statements
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Assignment: Chat Applications
 * Date: 22nd December 2016
 * @author Kieran Ryan: eeu444
 * @author Daniel Jones: eeu6b7
 */

public class ChatServer2
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
    public ChatServer2(int port) throws IOException
    {
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started" + server);
            System.out.println("Waiting for connection...");
            while(true){
                try
                {
                     socket = server.accept();
                    System.out.println("Socket created: " + socket);
                    System.out.println("Connected to client...");
                    //Takes input from client
                    Scanner in = new Scanner(socket.getInputStream());
                    //Until the client enters ".bye", server will continue running
                    boolean done = false;
                    while(!done)
                    {
                        String line = in.nextLine();
                        System.out.println(line);
                        done = line.equals(".bye");
                    }
                    System.out.println("Client dropped.");
                }
                catch(IOException event) { System.out.println(event); }
            }
        }
        catch(IOException event) { System.out.println(event); }
        
        finally{ socket.close(); System.out.println("Connection closed..."); }
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

