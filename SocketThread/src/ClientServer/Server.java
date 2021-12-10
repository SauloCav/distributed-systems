package ClientServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
	
	public Socket client;

	public Server(Socket client) {
		this.client = client;
	}
	
	static int i = 0;
	static long sumTime = 0;

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9876);
		
		while (true) {

			Socket client = server.accept();
			Server treatment = new Server(client);
			Thread thread = new Thread(treatment);
			thread.start();
			i++;
			if (i > 4) {
				server.close();
			}

		}

	}

	public void run() {
		try {

			int[] numList = new int[1000000];
			int sum = 0;
			
			long time = System.currentTimeMillis();

			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			numList = (int[]) input.readObject();

			for (int j = 0; j < 1000000; j++) {
				sum += numList[j];
			}
			
			if(i < 2) {
				
				System.out.println("One Client:");
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				System.out.println("[Server] Result " + sum + " sent!");
				System.out.println("Process Time: " + (System.currentTimeMillis() - time) + "ms" );
				output.writeObject(sum);
				
			}
			else if(i == 2) {
				
				System.out.println("\n\nThree Client:");
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				System.out.println("[Server] Result " + sum + " sent!");
				output.writeObject(sum);
				sumTime = sumTime + ((System.currentTimeMillis() - time));
				
			}
			else if(i == 3) {
				
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				System.out.println("[Server] Result " + sum + " sent!");
				output.writeObject(sum);
				sumTime = sumTime + ((System.currentTimeMillis() - time));
				
			}
			else if(i == 4) {
				
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				System.out.println("[Server] Result " + sum + " sent!");
				output.writeObject(sum);
				sumTime = sumTime + ((System.currentTimeMillis() - time));
				System.out.println("[Server] Result " + sum + " sent!");
				System.out.println("Process Time: " + sumTime + "ms\n" );
				input.close();
				output.close();
				client.close();
				
			}

		} catch (Exception ex) {

		}
	}
}
