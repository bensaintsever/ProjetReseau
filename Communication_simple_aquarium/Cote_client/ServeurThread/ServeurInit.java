package ServeurThread;
import ServeurTCP.ServeurTCP;
import Protocole.*;
import aquarium.items.Fish;
import aquarium.gui.Aquarium;
import java.net.Socket;

/**
 * Classe permettant l'initialisation d'une communication (coté serveur)
 * 
 * @author benjamin
 * 
 */
public class ServeurInit extends Thread{
	private ServeurTCP serveur;
        private Fish f;
        private int idFish;
        private Aquarium aquarium;
        private Socket sockClient;
	
        /**
         * Constructeur par défaut
         */
        public ServeurInit(){}
        
        /**
         * Constructeut permettant d'initialiser la configuration serveur, 
         * de recuperer la reference vers l'aquarium pour recuperer ses données (poissons),
         * et on recupère le socket client.
         * @param s
         *      Configuration serveur
         * @param aquariumRef
         *          Reference de l'aquarium
         * @param sockClient 
         *          Socket client
         */
	public ServeurInit(ServeurTCP s, Aquarium aquariumRef, Socket sockClient){
		serveur = s;
                aquarium = aquariumRef;
                this.sockClient = sockClient;
	}
	
        /**
         * Permet le premier contact avec le(s) client(s), cette méthode sera appelé par un thread.
         */
        public void InitialContact(){
            
            /* 
             * Le client communique avec le serveur pour la premiere fois
             * Le serveur envois la position des éléments de l'aquarium
             * Le client demande d'initier un poisson
            */
            String commande1 = serveur.receive(sockClient);
            
            //Ajout d'un nouveau poisson dans l'aquarium
            f = aquarium.getFish(aquarium.addFish());
            
            //On transmet les données du nouveaux poissons
            serveur.send(new Protocole().addFish(
                    idFish, f.getWidth(), f.getPosition().x,f.getPosition().y));
                   
            
            //Move Fish ?
            
           
            
        }
        

        @Override
	public void run(){
		
            InitialContact();
		
		
	}
	
	
	
}


   /*
                                    //Reception d'un commande provenant du client
                                    String commande1 = serveur.receive();



                                    //Interprétation commandes
                                    if (commande1.equals("Add me")){
                                        aquarium.addFish();//Ajout d'un poisson dans l'aquarium
                                        c.addClient(); //Ajout reference d'un nouveau client

                                        Fish poisson = aquarium.getFish(c.getIndice());//On recupere l'objet Fish que l'on souhaite créer


                                        //On envoi aux clients la nouvelle position du poisson
                                        serveur.send(AddFish+poisson.getPosition());

                                    }   */