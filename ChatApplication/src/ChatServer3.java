// Import statements
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Assignment: Chat Applications
 * Date: 22nd December 2016
 * @author Kieran Ryan: eeu444
 * @author Daniel Jones: eeu6b7
 */

public class ChatServer3 implements Runnable
{
    /**
     * The server port and address
     */
    private Socket socket;
    private ServerSocket server;
    private Thread thread;
    private ChatService client;
    /**
     * 
     * @param port
     * @throws IOException 
     */
    public ChatServer3(int port)
    {
        final int MAX_CLIENTS = 10;
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started" + server);
            System.out.println("Waiting for connection...");
            if(thread == null)
            {
                thread = new Thread(this);
                thread.start();
            }
        }
        catch(IOException event) { System.out.println(event); }
    }
    public void run()
    {
        while(thread != null)
        {
            try
            {
                socket = server.accept();
                System.out.println("Socket created: " + socket);
                System.out.println("Connected to client...");
                client = new ChatService(this, socket);
                try
                {
                    client.open();
                    client.start();
                }
                catch(IOException event) {}
                /*Scanner in = new Scanner(socket.getInputStream());
                boolean done = false;
                while(!done)
                {
                    try
                    {
                        String line = in.nextLine();
                        System.out.println(line);
                        done = line.equals(".bye");
                    }
                    finally {done = true;}
                }
                if(socket != null)
                    socket.close();
                in.close();
                System.out.println("Client dropped.");*/
            }
            catch(IOException event) { System.out.println(event); }
        }
    }
    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        ChatServer3 client;
        if (args.length != 1) { System.out.println("Usage: java ChatServer port"); }
        
        else{ int port = Integer.parseInt(args[0]);  client = new ChatServer3(port); }
    }
}

