package trabalhormi;

import java.rmi.*;

public interface PromptInt extends Remote {

	String comand(String comando) throws RemoteException;
	
}