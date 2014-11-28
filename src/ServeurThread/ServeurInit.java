package ServeurThread;
import ServeurTCP.ServeurTCP;


public class ServeurInit extends Thread{
	private ServeurTCP serveur;
	
        
        public ServeurInit(){}
        
        
	public ServeurInit(ServeurTCP s){
		serveur = s;
	}
	
        
        public void InitialContact(){
            
            /* 
             * Le client communique avec le serveur pour la premiere fois
             * Le serveur envois la position des éléments de l'aquarium
             * Le client demande d'initier un poisson
            */
            String commande1 = serveur.receive();
            serveur.send("Coucou");
            
            
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