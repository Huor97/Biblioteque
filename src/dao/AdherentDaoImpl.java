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
 * Impl�mentation AdherentDAO -  Gestion des adh�rents.
 */
public class AdherentDaoImpl implements AdherentDAO {
	// Objet de contexte pour la connexion � la BDD.	
	private DAOContext daoContext;
	// Objet pour la connexion � la BDD.
	Connection connexion = null;
	
	// Constructeur de classe.
	public AdherentDaoImpl( DAOContext daoContext ) {
		this.setDaoContext( daoContext );
	}

	// M�thode pour ajouter un adh�rent dans la table 'adherent' de la BDD.	
	@Override
    public void ajouter( Adherent adherent ) {
		// Objet pour pr�parer l'ajout de l'adh�rent.
        PreparedStatement preparedStatement = null;

        try {
        	// Se connecter � la BDD.
        	connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Pr�parer l'ajout de l'adh�rent.
            preparedStatement = this.connexion.prepareStatement( "INSERT INTO adherent( nom, prenom ) VALUES( ?,? );" );
            preparedStatement.setString( 1, adherent.getNom() );
            preparedStatement.setString( 2, adherent.getPrenom() );
            // Ajouter l'adh�rent � la table 'adherent'.
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// M�thode pour lister les adh�rents de la table 'adherent' de la BDD.		
	@Override
	public List<Adherent> lister() {
		// Objet pour pr�parer l'extraction de la table 'adh�rent'.		
		Statement statement = null;
		// Objet pour r�cup�rer les informations extraites de la table 'adh�rent'.
		ResultSet resultset = null;
		// Liste des adh�rents.
		List<Adherent> Ladherent = new ArrayList<Adherent>();

		try {	
        	// Se connecter � la BDD.			
			connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Pr�parer l'extraction de la table 'adherent'.
			String strSQL = "SELECT * FROM adherent";
			statement = connexion.createStatement();
            // R�cup�rer les informations extraites de la table 'adh�rent'.
			resultset = statement.executeQuery( strSQL );
			// Construire la liste des adh�rents.
			while ( resultset.next() ) {
				Adherent adherent = new Adherent();
				adherent.setNom( resultset.getString( 2 )  );
				adherent.setPrenom( resultset.getString( 3 ) );
				Ladherent.add( adherent );
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Retourner la liste des adh�rents;
		return Ladherent;
	}
	
	// M�thode pour lister les adh�rents de la table 'adherent' de la BDD.		
	@Override
	public void supprimer (Adherent adherent ) {
		// Objet pour pr�parer la suppression de l'adh�rent.		
		PreparedStatement preparedStatement = null;

		try {
        	// Se connecter � la BDD.			
			connexion = DriverManager.getConnection( DAOContext.url, DAOContext.login, DAOContext.password );
            // Pr�parer la suppression de l'adh�rent.		
			preparedStatement = connexion.prepareStatement( "DELETE FROM adherent WHERE nom=? and prenom=?;" );
			preparedStatement.setString( 1, adherent.getNom() );
			preparedStatement.setString( 2, adherent.getPrenom() );		
            // Supprimer l'adh�rent  de la table 'adherent'.			
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
