import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Program: ServerViewer.java
 * Assignment: Chat Applications
 * Date: 7th January 2017
 * @author Kieran Ryan: eeu444
 * @author Daniel Jones: eeu6b7
 */

public class ChatServerViewer {
    public static void main(String[] args) throws IOException {
        JFrame frame = new ServerFrame();
        frame.setTitle("Chat Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ServerFrame extends JFrame {
    //Panels
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel sendPanel = new JPanel();
    JPanel messagePanel = new JPanel();
    //Other components
    JTextArea messageBox = new JTextArea(10, 26);
    JScrollPane messageScroll = new JScrollPane(messageBox);
    JTextField textfield = new JTextField("", 20);
    JButton sendButton = new JButton("Send");
    //Listeners
    SendListener sendButtonListener = new SendListener();
    
    public ServerFrame() {
        messageBox.setEditable(false);
        messageScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messageScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        addComponents();
        pack();
    }
    
    private void addComponents(){
        //Adding the components and listeners
        textfield.addActionListener(sendButtonListener);
        sendPanel.add(textfield);
        sendButton.addActionListener(sendButtonListener);
        sendPanel.add(sendButton);
        messagePanel.add(messageScroll);
        mainPanel.add(messagePanel, BorderLayout.CENTER);
        mainPanel.add(sendPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }
    
    private void sendMessage() {
        messageBox.setText(messageBox.getText() + textfield.getText() + "\n");
        textfield.setText((""));
    }
    
    class SendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sendMessage();
        }
    }
}



