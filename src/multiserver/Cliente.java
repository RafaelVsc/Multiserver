
package multiserver;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        
        Socket sc;
        Scanner entrada, in;
        PrintStream saida;
        String msg="";
        try {
            sc = new Socket("localhost",9600);
            entrada = new Scanner (sc.getInputStream());
            saida = new PrintStream(sc.getOutputStream());
            in = new Scanner(System.in);
            
            do {                
                System.out.println("Digite:");
                msg = in.nextLine();
                saida.println(msg);
                System.out.println("::" + entrada.nextLine());
            } while (!msg.equalsIgnoreCase("fim"));
            System.out.println("Final da conexão");
            sc.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
    
}
