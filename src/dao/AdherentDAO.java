package dao;

import java.util.List;

import model.Adherent;

public interface AdherentDAO {
	public void ajouter( Adherent adherent );
	public void supprimer( Adherent adherent );	
	public List<Adherent> lister();
}
