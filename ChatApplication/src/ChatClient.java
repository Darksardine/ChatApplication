
// Import statements
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Assignment: Chat Applications
 * Date: 22nd December 2016
 * @author Kieran Ryan: eeu444
 * @author Dainel Jones: eeu---
 */
public class ChatClient 
{
      /**
     * The server port
     */
    private Socket socket;
    /**
    * @throws IOException
    * @throws UnknownHostException
    * @param serverName The server address
    * @param port  The server port
    */
    public ChatClient(String serverName, int port) throws IOException
    {
        System.out.println("Establishing connection. Please wait...");
         try
        {
            socket = new Socket(serverName, port);
            System.out.println("Client socket created: " + socket);
            // Reads keyboard input and outputs it to server
            Scanner in = new Scanner(System.in);
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            String line = "";
            // Will close connection when the ".bye" is inputted in the console
            while(!line.equals(".bye")) { line = in.nextLine(); output.println(line); output.flush(); }
        }
        catch(UnknownHostException event) {}
        catch(IOException event){}
        finally{ System.out.println("Closing connection..."); socket.close() ;} 
    }
    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        ChatClient client;
        if(args.length != 2) { System.out.println("Usage: java ChatClient ChatServer port"); }
        
        else{ String serverName = args[0]; int port = Integer.parseInt(args[1]); client = new ChatClient(serverName, port); }
    }
}
