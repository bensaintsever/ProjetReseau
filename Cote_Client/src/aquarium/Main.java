package aquarium;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;

/**
 * Starting point of the Aquarium application
 */
public class Main {
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
		
		
		
		/*Autoriser le client a avoir son poisson
		si on recois une demande de move alors on move le poisson vers un target correspondant*/
		
		
		
		
		ServeurTCP serveur = new ServeurTCP(7763);
		
		/*new Thread(new Runnable()
			{
				public void run(){
					
					
				}
			}
		).start();*/
		
		
		

		int i = 0;
		while(true){
			serveur.accept();

			
			String commande1 = serveur.receive();
			if (commande1.equals("Add me")){
				serveur.send("aquarium!addfish"+getcoordonneefish+gettargetfish);
				
			}
			
			
			
			serveur.send("salut suzen");
			serveur.closeClient();
			//serveur.closeServeur();
			i++;
			
			if(i > 5)//Temporaire car limite le nombre de boucle
				break;
		}
		serveur.closeServeur();
		
		
	}
}
