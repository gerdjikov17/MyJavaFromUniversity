import javax.swing.JFrame;
public class ServerTest {

	public static void main(String[] args) {
		ServerDemo chatServer = new ServerDemo();
		chatServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatServer.startRunning();
	}

}
