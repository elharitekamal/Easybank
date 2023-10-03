package dao;

import dto.Employe;
import dto.Operation;

import java.util.Optional;

public interface Operationdao {
    Optional<Operation> effectuerRetrait(int numero, double montant, Employe employe);

    Optional<Operation>  effectuerVirement(int compteSource, int compteDestinataire, double montant, Employe employe);

    int supprimerOperation(int numero);

    Optional<Operation> chercherOperationParNumero(int matricule);





}
