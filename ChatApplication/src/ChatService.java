
import java.io.IOException;
import java.io.PrintWriter;
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
public class ChatService implements Runnable
{
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private ChatClient client;
    
    public ChatService(Socket socket) { this.socket = socket; }
    public void run() 
    {
        try
        {
            try
            {
                in = new Scanner(socket.getInputStream());
                boolean done = false;
                while(true)
                {
                    String line = in.nextLine();
                   
                    if(line.equals(".bye"))
                        return; 
                    System.out.println(line);
                    out.flush();
                }
              }
              finally { socket.close(); System.out.println("Connection closed...");}
         }
        catch(IOException event) {System.out.println(event);}
    }
    
}
