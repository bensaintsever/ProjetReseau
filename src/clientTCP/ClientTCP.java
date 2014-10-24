package clientTCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTCP {
	
	Socket s;
	private OutputStream os;
	private InputStream is;
	private PrintWriter ps;
	BufferedReader in;

	
	public ClientTCP(String server, int portNumber){
		try {
			s = new Socket(server, portNumber);

			os = s.getOutputStream();
			is = s.getInputStream();
			
			} catch(Exception e) {
				System.exit(0);	
			}
		
	}
	
	public String receive(){
		try{
			in = new BufferedReader(new InputStreamReader(is));
				return in.readLine();
		} catch(Exception e) {return null;}
				
	}
	
	
	public void send(String message){
		ps = new PrintWriter(os);
		
		ps.println(message);
		
	}
	
	
	public void close(){
		try{
			s.close();
		} catch(Exception e) {System.exit(0);}
		
	}
	
}
