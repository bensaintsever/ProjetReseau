package aquarium;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;

/**
 * Starting point of the Aquarium application
 */
public class Main {
	
	
	public static void main(String[] args) {
		/*Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();*/
		ServeurTCP serveur = new ServeurTCP(7776);
		
		/*new Thread(new Runnable()
			{
				public void run(){
					
					
				}
			}
		).start();*/
		
		ClientTCP client;
		
		while(true){
			serveur.accept();
			
			client = new ClientTCP("127.0.0.1",7776);
			client.send("Coucou");
			client.close();
			
			serveur.receive();
		}
		
		
	}
}
