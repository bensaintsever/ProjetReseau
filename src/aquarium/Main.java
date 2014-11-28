package aquarium;

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
import aquarium.items.Fish;
import ServeurThread.ServeurInit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Starting point of the Aquarium application
 */
public class Main{
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
                ArrayList<Thread> t = new ArrayList<>();
                
                //Creer 10 Thread maximum, ils gerent par une file les differents threads 
                final ScheduledExecutorService t1 = Executors.newScheduledThreadPool(10);
                
                
		
                /* Ajouter au client le parametre qui designe le nom d'un machine (realiser un getByname peut etre)*/
		
		
                 //Preparation des données clients
                Client c = new Client();            
                
               	
		ServeurTCP serveur = new ServeurTCP(7763);

                //Thread General Serveur
                t1.execute(new Runnable() {

                    
                    public void run() {
                        
			
			try{	
					
                            int i = 0;
                            while(true){
                                    //Ecoute du serveur
                                    serveur.accept();
                                  
                                    
                                    ServeurInit sInit = new ServeurInit(serveur);
                                    sInit.start();
                                    
                                    /************** WIP ******************
                                    ServeurCommunication sCom = new ServeurCom(serveur);
                                    sCom.start();
                                    *************************************/
                                    
                                    //Ajout d'un poisson client
                                    c.addClient();
                                    
                 
                            }
                            
                        }catch(RuntimeException e){
                            e.printStackTrace();}
                                
                    }
                        
                });

}}
