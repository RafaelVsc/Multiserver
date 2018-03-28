
package multiserver;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String[] args) {
        
        ServerSocket server;
        Socket cli;
        
        
        try {
            server = new ServerSocket(9600);
            while (true) {                
                cli = server.accept();
                System.out.println("Conectado com " +
                        cli.getInetAddress().getHostAddress());
                Atende at = new Atende(cli);
                at.start();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
    
}
