package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdherentDAO;
import dao.DAOContext;
import model.Adherent;

/**
* Servlet - Contrôleur.
*/
@WebServlet( urlPatterns = "/adherent", loadOnStartup = 1 )
public class AdherentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//.. Future implémentation 'AdherentDAO'.
	private AdherentDAO adherentDao;
	
	//-- Initialisation de la servlet.
	//--------------------------------
	public void init() throws ServletException {
		// Initialiser le contexte.
		DAOContext daoContext = new DAOContext();
		DAOContext.init( this.getServletContext() );
		// Instancier l'implémentation AdherentDAO.
		this.adherentDao = daoContext.getAdherentDao();
	}
	
	/**
	* Méthode doGet : cette méthode est appelée en dehors d'un formulaire.
	*/
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {	
		// Récupérer la liste des adhérents depuis la table 'adherent' via la méthode 'lister' de l'impplémentation.
		request.setAttribute( "listeAdherents", this.adherentDao.lister() );
	
		// Appeler la JSP 'Adherent.jsp' avec les informations de la liste des adhérents.
		RequestDispatcher redirige = request.getRequestDispatcher( "/WEB-INF/adherent.jsp" );
		redirige.forward( request, response );
	}

	/**
	* Méthode doPost : cette méthode est appelée depuis un formulaire.
	 **/
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {	
		// Récupérer les informations saisies sur le formulaire.
		Adherent adherent = new Adherent();
		adherent.setNom( request.getParameter( "nom" ) );
		adherent.setPrenom( request.getParameter( "prenom" ) );		
		
		// Le bouton 'Ajouter' a été cliqué sur le formulaire.
		if ( request.getParameter( "Ajouter" ) != null ) {
			// Vérifier que le nom et le prénom ont été saisis.
			if ( adherent.getNom() != "" && adherent.getPrenom() != "" ) {
				// Ajouter l'adhérent dans la table 'adherent' via la méthode 'ajouter' de l'impplémentation.		
				adherentDao.ajouter( adherent );
			}			
		}
		
		// Le bouton 'Supprimer' a été cliqué sur le formulaire.
		if ( request.getParameter( "Supprimer" ) != null ) {
			// Vérifier que le nom et le prénom ont été saisis.
			if ( adherent.getNom() != "" && adherent.getPrenom() != "" ) {
				// Supprimer l'adhérent dans la table 'adherent' via la méthode 'supprimer' de l'impplémentation.						
				adherentDao.supprimer( adherent );
			}			
		}		
		
		// Récupérer la liste des adhérents depuis la table 'adherent' via la méthode 'lister' de l'impplémentation.
		request.setAttribute( "listeAdherents", this.adherentDao.lister() );
		
		// Appeler la JSP 'Adherent.jsp' avec les informations de la liste des adhérents.
		RequestDispatcher redirige = request.getRequestDispatcher( "/WEB-INF/adherent.jsp" );
		redirige.forward( request, response );
	}

}