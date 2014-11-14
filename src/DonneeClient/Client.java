/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DonneeClient;
import java.util.ArrayList;

/**
 * these clients need to be associated with their sockets!!!
 * @author benjamin et sezen ^^
 */
public class Client {
    
    private ArrayList<ClientTmp> IdClient;
    
    public Client(){
        IdClient = new ArrayList<ClientTmp>();
    }
    
    public void addClient(){
        IdClient.add(new ClientTmp(IdClient.size()));
        
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
