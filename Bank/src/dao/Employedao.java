package dao;
import java.util.Optional;

import dto.Employe;

public interface Employedao {

     Optional<Employe> ajouterEmploye(Employe employe);
     int supprimerEmploye(int matricule);
     Optional<Employe> chercherEmploye(int matricule);








}
