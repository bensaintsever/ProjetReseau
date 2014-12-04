package ServeurThread;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DonneeClient.Client;
import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.AquariumItem;
import aquarium.items.Fish;


/**
 * Classe permettant de communiquer avec le client(coté serveur)
 * 
 * @author benjamin
 * 
 */

public class ServeurCommunication extends Thread{

	private ServeurTCP serveur;
	private Socket sockClient;
        //private Fish f;
        //private int idFish;
        private Aquarium aquarium;
	
        
        /**
         * Constructeur permettant d'initialiser les données serveur et socket du client
         * @param s
         *      Configuration du serveur
         * @param sockClient 
         *      Donnée socket du client
         */
	public ServeurCommunication(ServeurTCP s, Socket sockClient){
		serveur = s;
		this.sockClient = sockClient;
                
	}
	
        
        
        @Override
        public void run(){
            
            //Il me faut le protocole coté client pour continuer
            switch (serveur.receive(sockClient)){
                case "addFish":
                    
                    
                    //aquarium.addFish()
                    
                    
                    
                    break;
                    
                default: 
                    break;
            }
                    
            
            
        }
	
}
 /* EXEMPLE DE RECEPTION COTE SERVEUR
                                    //Reception d'un commande provenant du client
                                    String commande1 = serveur.receive();



                                    //Interprétation commandes
                                    if (commande1.equals("Add me")){
                                        aquarium.addFish();//Ajout d'un poisson dans l'aquarium
                                        c.addClient(); //Ajout reference d'un nouveau client

                                        Fish poisson = aquarium.getFish(c.getIndice());//On recupere l'objet Fish que l'on souhaite créer


                                        //On envoi aux clients la nouvelle position du poisson
                                        serveur.send(AddFish+poisson.getPosition());

                                    }   
*/
