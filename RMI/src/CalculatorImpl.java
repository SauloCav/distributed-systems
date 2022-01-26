import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4804675865338914646L;

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	public long add(long a, long b) throws RemoteException {
		return a + b;
	}
}
