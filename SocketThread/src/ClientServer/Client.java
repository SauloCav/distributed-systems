package ClientServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.io.IOException;
import java.net.ServerSocket;

public class Client {

	public void sentClient() {
		try {
			
			int [] numList = new int[1000000];

			Random random = new Random();

			for (int i = 0; i < 1000000; i++) {
				numList[i] = random.nextInt(1000);
			}
			
			System.out.println("[End]!");
						
			Socket socket = new Socket("127.0.0.1", 9876);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			Object sendMessage = numList;
			output.writeObject(sendMessage);

			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Object message = (int) input.readObject();
			System.out.println("[Client] Received: " + message);

			input.close();
			output.close();
			socket.close();	
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
}
