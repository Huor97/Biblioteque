package model;

/**
 * Classe Adherent : modèle adhérent.
 */
public class Adherent {
	// Attributs de classe.
	private String nom;
	private String prenom;

	// Méthodes 'getters'.
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	// Méthodes 'setters'.
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}
	
}
