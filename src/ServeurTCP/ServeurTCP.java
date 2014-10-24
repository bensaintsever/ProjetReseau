package ServeurTCP;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServeurTCP {
	
	
	
	public ServeurTCP(){
		try{
				ServerSocket ecoute = new ServerSocket(1234);
		while(true){
			Socket client = ecoute.accept();
			InputStream is = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			OutputStream os = client.getOutputStream();
			
			client.close();
			
			}
		
		}catch(Exception e){}
		
	}
}
