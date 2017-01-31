package trabalhormi;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Prompt extends UnicastRemoteObject implements PromptInt {

	protected Prompt() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String comand(String comando) throws RemoteException {
		// TODO Auto-generated method stub
		String result = "";
		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
			builder.redirectErrorStream(true);
			Process p = null;

			p = builder.start();

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = null;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
				result += line+"\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		try {
			Prompt p = new Prompt();

			LocateRegistry.createRegistry(9999);

			Naming.rebind("//127.0.0.1:9999/Prompt", p);
			System.out.println("servidor ligado!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
