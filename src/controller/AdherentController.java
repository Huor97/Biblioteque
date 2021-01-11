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
* Servlet - Contr�leur.
*/
@WebServlet( urlPatterns = "/adherent", loadOnStartup = 1 )
public class AdherentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//.. Future impl�mentation 'AdherentDAO'.
	private AdherentDAO adherentDao;
	
	//-- Initialisation de la servlet.
	//--------------------------------
	public void init() throws ServletException {
		// Initialiser le contexte.
		DAOContext daoContext = new DAOContext();
		DAOContext.init( this.getServletContext() );
		// Instancier l'impl�mentation AdherentDAO.
		this.adherentDao = daoContext.getAdherentDao();
	}
	
	/**
	* M�thode doGet : cette m�thode est appel�e en dehors d'un formulaire.
	*/
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {	
		// R�cup�rer la liste des adh�rents depuis la table 'adherent' via la m�thode 'lister' de l'imppl�mentation.
		request.setAttribute( "listeAdherents", this.adherentDao.lister() );
	
		// Appeler la JSP 'Adherent.jsp' avec les informations de la liste des adh�rents.
		RequestDispatcher redirige = request.getRequestDispatcher( "/WEB-INF/adherent.jsp" );
		redirige.forward( request, response );
	}

	/**
	* M�thode doPost : cette m�thode est appel�e depuis un formulaire.
	 **/
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {	
		// R�cup�rer les informations saisies sur le formulaire.
		Adherent adherent = new Adherent();
		adherent.setNom( request.getParameter( "nom" ) );
		adherent.setPrenom( request.getParameter( "prenom" ) );		
		
		// Le bouton 'Ajouter' a �t� cliqu� sur le formulaire.
		if ( request.getParameter( "Ajouter" ) != null ) {
			// V�rifier que le nom et le pr�nom ont �t� saisis.
			if ( adherent.getNom() != "" && adherent.getPrenom() != "" ) {
				// Ajouter l'adh�rent dans la table 'adherent' via la m�thode 'ajouter' de l'imppl�mentation.		
				adherentDao.ajouter( adherent );
			}			
		}
		
		// Le bouton 'Supprimer' a �t� cliqu� sur le formulaire.
		if ( request.getParameter( "Supprimer" ) != null ) {
			// V�rifier que le nom et le pr�nom ont �t� saisis.
			if ( adherent.getNom() != "" && adherent.getPrenom() != "" ) {
				// Supprimer l'adh�rent dans la table 'adherent' via la m�thode 'supprimer' de l'imppl�mentation.						
				adherentDao.supprimer( adherent );
			}			
		}		
		
		// R�cup�rer la liste des adh�rents depuis la table 'adherent' via la m�thode 'lister' de l'imppl�mentation.
		request.setAttribute( "listeAdherents", this.adherentDao.lister() );
		
		// Appeler la JSP 'Adherent.jsp' avec les informations de la liste des adh�rents.
		RequestDispatcher redirige = request.getRequestDispatcher( "/WEB-INF/adherent.jsp" );
		redirige.forward( request, response );
	}

}