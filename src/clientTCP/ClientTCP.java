package clientTCP;

import java.net.ServerSocket;
import java.net.Socket;

public class ClientTCP {

	public ClientTCP(int server){
		try {
			ServerSocket s = new ServerSocket(server);

			Socket receive = s.accept();
			
			s.close();
			} catch(Exception e) {
				System.exit(0);	
			}
		
	}
	
}
