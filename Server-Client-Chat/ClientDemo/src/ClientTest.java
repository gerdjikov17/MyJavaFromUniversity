import javax.swing.JFrame;
public class ClientTest {

	public static void main(String[] args) {
		ClientDemo client;
		client = new ClientDemo("127.0.0.1");
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.startRunning();
	}

}
