package DonneeClient;

import java.awt.Point;
import java.util.ArrayList;

import aquarium.items.AquariumItem;
import java.net.Socket;


public class Client {
	private int clientId;
        private Socket clientSocket;//UTILE ?
	private ArrayList<AquariumItem> clientsFish;
	
	/*
	 * Constructeur de donnée client, permettant de stocker des numéros clients (ID),
	 * ainsi que les item de l'aquarium
	 * 
	 * arg: 
	 * 
	 */
	public Client(){
		this.clientId = 0;
		clientsFish = new ArrayList<AquariumItem>();
	}
	
	public Client(int clientId, ArrayList<AquariumItem> items){
		this.clientId = clientId;
		clientsFish = new ArrayList<AquariumItem>();
		
		for (int i = 0; i < items.size(); i++)
			clientsFish.add(items.get(i)); //Fish should be cloned ideally
	}
        
        
        public void addClient(int clientId){
            this.clientId = clientId;
        }
	
	public void addFish(AquariumItem fish){
		clientsFish.add(fish);
		
	}
	
	
	public Point getPosition(int index){
		return clientsFish.get(index).getPosition();
		
	}
        public Socket getSocketClient(){
                return clientSocket;
        }
	
}
