package dao;

import dto.CompteCourant;
import dto.Employe;

import java.util.Optional;

public interface CompteCourantdao {
    Optional<CompteCourant> ajouterCompteC(CompteCourant compteCourant);
    int supprimerCompte(int numero);

    Optional<CompteCourant> modifierCompteCourant(CompteCourant compteCourantModifie);
    CompteCourant chercherCompteC(int numero);

}
