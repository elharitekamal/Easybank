package dao;

import dto.Affectation;

import java.util.Optional;

public interface AffectationDao {
    Optional<Affectation> ajouterAffectation(Affectation affectation);
    int supprimerAffectation(int mission, int employe);



}
