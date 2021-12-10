package ClientServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	
	public static void creatOneClient() {
		
		try {
		Client c1 = new Client();
		
		c1.sentClient();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void creatThreeClients() {
		
		try {
		Client c1 = new Client();
		Client c2 = new Client();
		Client c3 = new Client();
		
		c1.sentClient();
		c2.sentClient();
		c3.sentClient();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args)  {
		
		System.out.println("One Client:\n");
		creatOneClient();
		
		System.out.println("\n\nThree Client:\n");
		creatThreeClients();	
		
	}

}
