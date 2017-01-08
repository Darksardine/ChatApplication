
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author obliv
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
