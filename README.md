# Biblioteque
Projet bibliothèque avec école Simplon.
## Gestion d'une bibliothèque

Vous avez été contacté pour participer à la création d’une application web de gestion d’une
bibliothèque :
Grâce à ce système, un abonné devra pouvoir retrouver un livre dans les rayons en
connaissant son titre. L'abonné devra aussi pouvoir connaître la liste des livres d'un auteur ou
la liste par éditeur ou encore la liste par genre (bande dessinée, science-fiction, policier...).
L’abonné pourra également rechercher des documents par mots-clé.
Les livres sont identifiés par un code catalogue affecté à l'achat et par un code rayon qui
permet de les situer dans la bibliothèque. Chaque livre est acheté en un ou plusieurs
exemplaires (on stocke la date d'acquisition). Tous les exemplaires d'un même livre ont un
code rayon différent mais le même code catalogue. Les différents exemplaires d'un même livre
peuvent éventuellement provenir de différents éditeurs.
La bibliothèque gère un fichier des abonnés organisé par numéro de matricule qui contient
notamment les coordonnées (nom, adresse et téléphone) de l'abonné, sa date d'adhésion, sa
date de naissance, sa catégorie professionnelle (ou bien étudiant ou enfant, le cas échéant).
La gestion des prêts implique la possibilité de connaître à tout moment la liste des livres
détenus par un abonné, et inversement, qu'on puisse retrouver le nom des abonnés détenant
un livre non présent dans les rayons.
Les prêts sont accordés pour une durée de quinze jours, éventuellement renouvelable, si
aucune demande de ce livre n'a eu lieu entre-temps. Il faudrait donc connaître pour chaque
livre emprunté, la date du prêt et la date de retour.
La gestion des prêts nécessite aussi la mémorisation des livres demandés par un abonné. Cet
abonné sera prioritaire lors du retour du livre en prêt. Sa priorité est maintenue pendant une
semaine, à partir de la date de retour du livre.
Pour suivre de près l'état du stock, la bibliothèque utilise un code indiquant l'état d'usure de

chaque livre. Ce code d'usure est éventuellement mis à jour par un bibliothécaire à chaque re-
tour d'un livre en prêt.

Les fonctions que le système devra effectuer sont :
1. la gestion des prêts (prêts et retours) ;
2. la mise à jour du fichier des livres (mises au rebut ou achats de livres) ;
3. la mise à jour du fichier des abonnés (retraits et nouvelles inscriptions) ;
4. la gestion des demandes non satisfaites ;
5. la mise en place d'un échéancier permettant le contrôle des restitutions par les abonnés
ainsi que la gestion automatique des relances ;
6. la possibilité d'aide au choix d'un ouvrage grâce à une procédure de recherche par nom
d'auteur, par éditeur, par thème, ou par mot-clé ;
7. la possibilité d'établir des états statistiques permettant de connaître quel type d'abonné
(catégorie d'âge, catégorie professionnelle) emprunte les livres d'un thème donné.
Livrables Attendus :
I- BDD :
1- Construire le MCD, modélisant ce système en indiquant les entités, les attributs et
les relations

2- Définir les modèles Logique et Physique de données (MLD, et MPD) en utilisant
MySQL, Alimenter votre base par au moins 3 entrées par table.
3- Tester votre Base de données avec des requêtes répondants aux besoins
fonctionnels ci dessus..
II- App Web Java :
1-Traduire le cahier de charges ci dessus en diagrammes de cas d’utilisation et
diagramme de classes UML
2- Implémenter une application web java MVC qui répond au cahier de charge conçu
et en s’appuyant sur le TD_OO fournie
3- afficher sur une interface web la liste des adhérents de la bibliothèque avec la
possibilité de modifier ou supprimer une entrée de cette table.
III Bonus :
continuer votre application web avec le reste des onglets permettant d’exploiter le
reste des tables de la BDD (livres, auteurs, liste des emprunts...)
