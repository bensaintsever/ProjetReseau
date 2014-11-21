package aquarium;

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

/**
 * Starting point of the Aquarium application
 */
public class Main {
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
		 int IdClient = 0;
		

		
                
                 /****************Protocole****************/
                        
                    String AddFish = "aquarium!addfish!";
                    String DeleteFish = "aquarium!deletefish";
                        
                 /******************************************/
                

                    
                  
                    
		ServeurTCP serveur = new ServeurTCP(7763);
		

                
		int i = 0;
		while(true){
            //Ecoute du serveur
			serveur.accept();
			
			
			// Si nouveau client alors on détache un thread
			
			   final int IdClient_copy=IdClient;
			   IdClient++;
			   
			   final ServeurTcp serveur_copy = serveur.clone();
			
			
			//AJOUTER THREAD ! + SYNCHRO !
            /**************** WIP *****************/
            
			new Thread(new Runnable()
			{
				public void run(){
								
			
					//Preparation des données clients
		            ClientTmp c = new ClientTmp(IdClient_copy);
		            
		
		            //Ajout d'un poisson client
		            c.addFish(new Fish());
		
		            //Reception d'un commande provenant du client
					String commande1 = serveur.receive();
		                        
		                        
		                        
		            //Interprétation commandes
					if (commande1.equals("Add me")){
		                            aquarium.addFish();//Ajout d'un poisson dans l'aquarium
		                            
		                            c.addFish(new Fish()); //Ajout reference d'un nouveau client
		                            
		                            Fish poisson = aquarium.getFish(c.getIndice());//On recupere l'objet Fish que l'on souhaite créer
		                            		
		                            
		                            //On envoi aux clients la nouvelle position du poisson
		                            serveur.send(AddFish+poisson.getPosition());
						
					}
					
					
					//Deconnection avec le client
					serveur.closeClient();
                        
                        
			
				}
			});//.start());

		}
		serveur.closeServeur();
		
		
	}
}
