
package multiserver;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Atende extends Thread{
    
    Socket cli;

    public Atende(Socket cli) {
        this.cli = cli;
    }
    
    @Override
    public void run(){
        Scanner in;
        PrintStream out;
        String msg = "";
        
        try {
            in = new Scanner(cli.getInputStream());
            out = new PrintStream(cli.getOutputStream());
            do{
                msg = in.nextLine();
                System.out.println("Recebido: " + msg +
                " de " + cli.getInetAddress());
                out.println("Recebido");
            } while(!msg.equalsIgnoreCase("fim"));
            System.out.println("Encerrou com "+
                    cli.getInetAddress());
            cli.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
