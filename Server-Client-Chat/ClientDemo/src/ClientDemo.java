import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClientDemo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	public ClientDemo(String host) {
		super("Client mofo!");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow),BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	protected void sendMessage(String msg) {
		try {
			output.writeObject("CLIENT - "+msg);
			output.flush();
			showMessage("\n CLIENT - "+msg);
		}catch(IOException e) {
			chatWindow.append("Something went wrong");
		}
		
	}
	public void startRunning() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
			
		}catch(EOFException eofException) {
			showMessage("\n Client terminated connection!");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
		finally {
			closeCrap();
		}
	}
	private void closeCrap() {
		showMessage("\n closing crap down...");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private void ableToType(final boolean b) {
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				userText.setEditable(b);
			}
		});
		
	}
	private void connectToServer() throws IOException{
		showMessage("Attempting connection...\n");
		connection = new Socket(InetAddress.getByName(serverIP),6789);
		showMessage("Connected to:"+connection.getInetAddress().getHostName());
	}
	private void showMessage(final String m) {
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				chatWindow.append(m);
			}
		});
		
	}
	private void setupStreams()throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are set and good to go!");
		
	}
	private void whileChatting()throws IOException{
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n"+message);
			}catch(ClassNotFoundException e) {
				showMessage("\n Unidentified object!");
			}
		}while(!message.equals("SERVER - END"));
	}

}
