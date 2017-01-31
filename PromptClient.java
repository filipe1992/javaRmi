package trabalhormi;

import java.rmi.Naming;
import javax.swing.*;

public class PromptClient {

	static PromptInt pronpt = null;
	static String retorno = null;
	
    public static void main(String args[]) {
    	JFrame frame = new JFrame("InputDialog Example #1");
    	
        try {
            pronpt = (PromptInt) Naming.lookup("//" + "127.0.0.1:9999" + "/Prompt");
            while (true){
            	
            	String comando = JOptionPane.showInputDialog(frame, "digite o comando para ser execultado no cliente");
            	if (comando == null) {break;}
	            retorno = pronpt.comand(comando);
	            System.out.println(retorno);
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }
	
}
