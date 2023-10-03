package dao;

import dto.Compte;
import dto.Employe;

import java.util.List;
import java.util.Optional;

public interface Comptedao {

    Optional<List<Compte>> chercherCompte(int client);
    boolean modifierEtat(int numero, Compte.Etat nouvelEtat);
}
