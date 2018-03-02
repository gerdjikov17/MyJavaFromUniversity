import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ServerDemo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
		public ServerDemo() {
			super("Instang Messenger");
			userText =  new JTextField();
			userText.setEditable(false);
			userText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			});
			add(userText, BorderLayout.NORTH);
			chatWindow = new JTextArea();
			add(new JScrollPane(chatWindow));
			setSize(300,150);
			setVisible(true);
		}
		// set up and run the server
		public void startRunning() {
			try {
				server = new ServerSocket(6789,100);
				while(true) {
					try {
						//connect and have conversation
						waitForConnection();
						setupStreams();
						whileChatting();
					}catch(EOFException eofException) {
						showMessage("\n Server ended the connection! ");
					}
					finally {
						closeCrap();
					}
				}
			}
			catch(IOException ioException) {
				ioException.printStackTrace();
			}
		}
		private void closeCrap() {
			showMessage("\n Closing connections...\n");
			ableToType(false);
			try {
				output.close();
				input.close();
				connection.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		//during the chat conversation
		private void whileChatting() throws IOException{
			String message = " You are now connected! ";
			sendMessage(message);
			ableToType(true);
			do {
				try {
					message = (String) input.readObject();
					showMessage("\n"+message);

				}catch (ClassNotFoundException ex) {
					showMessage("\n idk wtf that user sent!");
				}
			}while(!message.equals("CLIENT - END"));
			
		}
		//updates chatWindow
		private void showMessage(final String text) {
			SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						chatWindow.append(text);
					}
				}
			);
			
		}
		//let the user type stuff into their box
		private void ableToType(final boolean tof) {
			SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						userText.setEditable(tof);
					}
				}
			);
		}
		// get stream to send and receive data
		private void setupStreams() throws IOException{
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input = new ObjectInputStream(connection.getInputStream());
			showMessage("\n Streams are now setup! \n");
		}
		//wait for connection, then display connection information
		private void waitForConnection() throws IOException{
			showMessage("Waiting for someone to connect...\n");
			connection = server.accept();
			showMessage(" Now connected to "+connection.getInetAddress().getHostName());			
		}
		private void sendMessage(String msg) {
			try {
				output.writeObject("SERVER - "+msg);
				output.flush();
				showMessage("\n SERVER - "+msg);
			}catch(IOException e) {
				chatWindow.append("\nERROR");
			}
		}
}
