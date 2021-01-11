package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Adherent;

/**
 * Implémentation AdherentDAO -  Gestion des adhérents.
 */
public class AdherentDaoImpl implements AdherentDAO {
	// Objet de contexte pour la connexion à la BDD.	
	private DAOContext daoContext;
	// Objet pour la connexion à la BDD.
	Connection connexion = null;
	
	// Constructeur de classe.
	public AdherentDaoImpl( DAOContext daoContext ) {
		this.setDaoContext( daoContext );
	}

	// Méthode pour ajouter un adhérent dans la table 'adherent' de la BDD.	
	@Override
    public void ajouter( Adherent adherent ) {
		// Objet pour préparer l'ajout de l'adhérent.
        PreparedStatement preparedStatement = null;

        try {
        	// Se connecter à la BDD.
        	connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Préparer l'ajout de l'adhérent.
            preparedStatement = this.connexion.prepareStatement( "INSERT INTO adherent( nom, prenom ) VALUES( ?,? );" );
            preparedStatement.setString( 1, adherent.getNom() );
            preparedStatement.setString( 2, adherent.getPrenom() );
            // Ajouter l'adhérent à la table 'adherent'.
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// Méthode pour lister les adhérents de la table 'adherent' de la BDD.		
	@Override
	public List<Adherent> lister() {
		// Objet pour préparer l'extraction de la table 'adhérent'.		
		Statement statement = null;
		// Objet pour récupérer les informations extraites de la table 'adhérent'.
		ResultSet resultset = null;
		// Liste des adhérents.
		List<Adherent> Ladherent = new ArrayList<Adherent>();

		try {	
        	// Se connecter à la BDD.			
			connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Préparer l'extraction de la table 'adherent'.
			String strSQL = "SELECT * FROM adherent";
			statement = connexion.createStatement();
            // Récupérer les informations extraites de la table 'adhérent'.
			resultset = statement.executeQuery( strSQL );
			// Construire la liste des adhérents.
			while ( resultset.next() ) {
				Adherent adherent = new Adherent();
				adherent.setNom( resultset.getString( 2 )  );
				adherent.setPrenom( resultset.getString( 3 ) );
				Ladherent.add( adherent );
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Retourner la liste des adhérents;
		return Ladherent;
	}
	
	// Méthode pour lister les adhérents de la table 'adherent' de la BDD.		
	@Override
	public void supprimer (Adherent adherent ) {
		// Objet pour préparer la suppression de l'adhérent.		
		PreparedStatement preparedStatement = null;

		try {
        	// Se connecter à la BDD.			
			connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Préparer la suppression de l'adhérent.		
			preparedStatement = connexion.prepareStatement( "DELETE FROM adherent WHERE nom=? and prenom=?;" );
			preparedStatement.setString( 1, adherent.getNom() );
			preparedStatement.setString( 2, adherent.getPrenom() );		
            // Supprimer l'adhérent  de la table 'adherent'.			
			preparedStatement.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}	

	public DAOContext getDaoContext() {
		return daoContext;
	}

	public void setDaoContext(DAOContext daoContext) {
		this.daoContext = daoContext;
	}

}
