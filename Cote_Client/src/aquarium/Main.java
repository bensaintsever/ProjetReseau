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
		
		
		
		ClientTCP client;
		
		
		/*new Thread(new Runnable()
			{
				public void run(){
					
					
				}
			}
		).start();*/
		
		
		ArrayList<AquariumItem> mine = aquarium.getItems();

		client = new ClientTCP("10.0.206.6",7760);
		client.send("Add me"); //or whatever to get permission
		
		// receive authorisation
		
		for(int i = 0; i < items.size(); i++){
			client.send("addFish!"+ i +"!" + items.get(i).getWidth() +"!"+ items.get(i).getPosition().getX() + "!" + items.get(i).getPosition().getY())
		}
		
		int i = 0;
		while(true){
			
			//check every second to see fishies are changed or moved
		
		}	
		
		client.close();
}
