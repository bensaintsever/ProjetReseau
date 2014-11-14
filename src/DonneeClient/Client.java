/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DonneeClient;
import java.util.ArrayList;

/**
 *
 * @author benjamin et sezen ^^
 */
public class Client {
    
    private ArrayList<Client> IdClient;
    
    public Client(){
        IdClient = new ArrayList<Client>();
    }
    
    public void addClient(){
        IdClient.add(IdClient.size());
        
    }
    
    public void deleteClient(int idClient){
        try{
             IdClient.remove(idClient);
        }catch(Exception e){System.err.println("Impossible de supprimer un client");}
       
    }
    
    public int getIndice(){
        return IdClient.size();
    }
    
    
}
