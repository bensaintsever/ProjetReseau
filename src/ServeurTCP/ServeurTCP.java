package ServeurTCP;
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
			
			OutputStream os = client.getOutputStream()
			
		}
		
		}catch(Exception e){}
		
	}
}
