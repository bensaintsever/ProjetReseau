package ServeurThread;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DonneeClient.ClientTmp;
import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.AquariumItem;
import aquarium.items.Fish;

public class ServeurThread {

	private ServeurTCP serveur;
	private int numClient;
	
	public ServeurThread(ServeurTCP s){
		serveur = s;
		numClient = 0;
	}
	
	
	
	public void accepterCommunication(){
		serveur.accept();
		numClient++;
		 ClientTmp c = new ClientTmp(numClient);
	}
	
	public void Thread(){
		
		//Traiter les commandes
		
		
		
		
	}
	
	
	
}
