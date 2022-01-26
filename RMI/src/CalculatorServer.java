import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
	CalculatorServer() {
		try {
			LocateRegistry.createRegistry(32001); 
			Calculator c = new CalculatorImpl();
			Naming.rebind("rmi://127.0.0.1:32001/CalculatorService", c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CalculatorServer();
	}
}