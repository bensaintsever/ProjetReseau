package Protocole;

/**
 *  Classe permettant le référencement du protocole de communication.
 * @author benjamin
 */
public class Protocole {
    
    /**
     * Constructeur par défaut
     */
    public Protocole(){
        
    }
    
    /**
     * Ajout d'un poisson
     * @param IdFish
     *          Identifiant du poisson
     * @param width
     *          Taille du poisson
     * @param x
     *          Coordonnée x du poisson 
     * @param y
     *          Coordonnée y du poisson 
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
    public String addFish(int IdFish, int width, int x, int y){
        
        return "aquarium!addFish!"+Integer.toString(IdFish)+"!"+Integer.toString(width)+"!"+Integer.toString(x)+"!"+Integer.toString(y);
    }
    
  
    /**
     * Supprime un poisson
     * @param IdFish
     *          Identifiant du poisson
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
    public String removeFish(int IdFish){
        return "aquarium!removefish"+IdFish;
    }
    
    /**
     * Deplacer un poisson
     * @param IdFish
     *           Identifiant du poisson
     * @param x
     *          Coordonnée x du poisson 
     * @param y
     *          Coordonnée y du poisson 
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
    public String moveFish(int IdFish, int x, int y){
        
        return "aquarium!moveFish!"+Integer.toString(IdFish)+"!"+Integer.toString(x)+"!"+Integer.toString(y);
    }
     
    /**
     * Modifier la taille d'un poisson
     * @param IdFish
     *          Identifiant du poisson
     * @param width
     *          Taille du poisson
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
    public String setFishWidth(int IdFish, int width){
        return "aquarium!setFish!"+Integer.toString(IdFish)+"!"+Integer.toString(width);
    }
     
    /**
     * Ajout d'une pierre
     * @param width
     *          Taille de la pierre
     * @param x
     *          Coordonnée x de la pierre 
     * @param y
     *          Coordonnée y de la pierre
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
    public String addStone(int width, int x, int y){
        return "aquarium!addStone!"+Integer.toString(width)+"!"+Integer.toString(x)+"!"+Integer.toString(y);
    }
     
    /**
     * Ajout d'une plante
     * @param width
     *          Taille de la plante
     * @param x
     *          Coordonnée x de la plante
     * @param y
     *          Coodonnée y de la plante
     * @return 
     *          Retourne sous forme de chaine de caractère la trame a transmettre
     */
     
    public String addWeed(int width, int x, int y){
        return "aquarium!addWeed!"+Integer.toString(width)+"!"+Integer.toString(x)+"!"+Integer.toString(y);
    }
    
    
    
    
}
/****************Protocole****************/
                        
                  
                    //String SendData = c.getCoordonnees()+ "!"+c.getTaille()+"!"+c.getImagesBuffer();
                    //String Image = c.getImage()
                        
                    /* LIRE IMAGE
                    File file = (File)obj;
                    FileInputStream fis = new FileInputStream(file);
                    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fis);
                    BufferedImage image = decoder.decodeAsBufferedImage();
                    fis.close();
                    
                    */
                    
                    
                 /******************************************/