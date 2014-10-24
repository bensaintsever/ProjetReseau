package clientTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTCP {

	public ClientTCP(int server){
		try {
			ServerSocket s = new ServerSocket(server);

			Socket client = s.accept();
			
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			os.write('a');
			System.out.println(is.read());
			
			
			s.close();
			client.close();
			} catch(Exception e) {
				System.exit(0);	
			}
		
	}
	
}
