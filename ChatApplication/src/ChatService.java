
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Assignment: Chat Applications
 * Date: 22nd December 2016
 * @author Kieran Ryan: eeu444
 * @author Daniel Jones: eeu6b7
 */

public class ChatService extends Thread
{
    private Socket socket;
    private ChatServer3 server;
    private Scanner input;
    public ChatService(ChatServer3 server, Socket socket)
    {
        this.server = server;
        this.socket = socket;
    }
    public void run()
    {
        while(true)
        {
            try
            {
                String line = input.nextLine();
                System.out.println(line);
            }
            finally {}
        } 
    }
    public void open() throws IOException { input = new Scanner(socket.getInputStream()); }
    public void close() throws IOException
    {
        if(socket != null)
            socket.close();
        input.close();
    }
}
