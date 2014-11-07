package ServeurTCP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServeurTCP {
	
	private PrintWriter out;
	private BufferedReader in;
	private Socket client;
	private ServerSocket ecoute;
	
	
	public ServeurTCP(int portNumber){
		try{
				ecoute = new ServerSocket(portNumber);
	
			//out = new PrintWriter(client.getOutputStream(), true);
			//in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//System.out.println("Serveur reçois : "+ receive());
		
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
	
	
	public void accept(){
		try {
			client = ecoute.accept();
		} catch (IOException e) {
			System.out.println("bad accept !");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void send(String message){
		out.println(message);
		
	}
	
	public String receive(){
		try{
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				return in.readLine();
		} catch(Exception e) {System.out.println("receive failed"); return null;}
	}
	
	public void closeClient(){
		try{
			client.close();
		} catch(Exception e){}
	}
	
	public void closeServeur(){
		try{
			ecoute.close();
		} catch(Exception e){}
	}
	
	
}
