package eu.unareil.dal.jbdc;

import eu.unareil.dal.DALException;

import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Properties properties;
    private static void loadDB() throws DALException{
        if(properties==null){
            properties = new Properties();
            try{
                properties.load(Settings.class.getResourceAsStream("settings.properties"));
            } catch (IOException e){
                throw new DALException("Erreur lors du chargement du fichier properties");
            }
        }
    }

    public static String getProperty(String key) throws DALException{
        loadDB();
        return properties.getProperty(key);
    }
}
