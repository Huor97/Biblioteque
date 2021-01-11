package dao;

import javax.servlet.ServletContext;

/**
 * Initialisation des paramètres de connexion à la BDD et instanciation d'une implémentation AdherentDAO.
 */
public class DAOContext {
	// Attributs pour stocker les informations de connexion à la BDD.
	public static String url;
	public static String parameters;
	public static String login;
	public static String password;

	// Initialiser les paramètres de connexion à  la BDD.
	// (les paramètres sont lus dans le fichier 'web.xml').
	public static void init( ServletContext context ) {
		try {
			// Charger le pilote de BDD pour MySQL.
			Class.forName( context.getInitParameter( "JDBC_DRIVER" ) );
			// Stocker l'url de la BDD.
			url = context.getInitParameter( "JDBC_URL" );
			// Stocker le nom de connexion à la BDD.
			login = context.getInitParameter( "JDBC_LOGIN" );
			// Stocker le mot de passe de connexion à la BDD.
			password = context.getInitParameter( "JDBC_PASSWORD" );
		} catch ( Exception exception ) {
			exception.printStackTrace();
		}		
	}
		
	// Instancier une implémentation AdherentDAO.
	public AdherentDaoImpl getAdherentDao() {
		return new AdherentDaoImpl(this );		
	}

}
