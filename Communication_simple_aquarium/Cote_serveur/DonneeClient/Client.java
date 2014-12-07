package DonneeClient;

import java.awt.Point;
import java.util.ArrayList;

import aquarium.items.AquariumItem;
import java.net.Socket;

/**
 * Classe permettant de stocker les données clients
 * 
 * @author benjamin
 * 
 */
public class Client {
	private int clientId;
        private Socket clientSocket;//UTILE ?
	private ArrayList<AquariumItem> clientsFish;
	
	/*
	 * Constructeur de donnée client, permettant d'initialiser des numéros clients (ID),
         * ainsi que les item de l'aquarium
	 * 
	 * 
	 */
	public Client(){
		this.clientId = 0;
		clientsFish = new ArrayList<AquariumItem>();
	}
        
	/*
	 * Constructeur de donnée client, permettant d des numéros clients (ID),
         * leurs socket, ainsi que les item de l'aquarium
	 * 
	 * @param clientID
         *          Identifiant Client
         * @param items
         *          Liste d'elements contenu dans l'aquarium
	 */
	public Client(int clientId, ArrayList<AquariumItem> items){
		this.clientId = clientId;
		clientsFish = new ArrayList<AquariumItem>();
		
		for (int i = 0; i < items.size(); i++)
			clientsFish.add(items.get(i)); //Fish should be cloned ideally
	}
        
        /**
         * Ajout d'un Identifiant client
         * @param clientId 
         *          Identifiant Client
         */
        public void addClient(int clientId){
            this.clientId = clientId;
        }
	/**
         * Ajout d'un Poisson dans la liste clientsFish
         * @param fish 
         */
	public void addFish(AquariumItem fish){
		clientsFish.add(fish);
		
	}
	/**
         * Obtenir la position d'un poisson client
         * @param index
         *      numéro de poisson dans la liste
         * @return 
         *      Coordonnées du poisson
         */
	public Point getPosition(int index){
		return clientsFish.get(index).getPosition();
		
	}
        /**
         * Obtenir le socket du client
         * @return 
         *      Retourne le socket du client
         */
        public Socket getSocketClient(){
                return clientSocket;
        }
	
}
