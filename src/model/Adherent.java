package model;

/**
 * Classe Adherent : mod�le adh�rent.
 */
public class Adherent {
	// Attributs de classe.
	private String nom;
	private String prenom;

	// M�thodes 'getters'.
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	// M�thodes 'setters'.
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}
	
}
