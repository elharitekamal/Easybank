package dao;

import dto.CompteCourant;
import dto.Employe;

import java.util.Optional;

public interface CompteCourantdao {
    Optional<CompteCourant> ajouterCompteC(CompteCourant compteCourant);
}
