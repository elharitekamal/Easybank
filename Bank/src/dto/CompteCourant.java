package dto;

import java.time.LocalDateTime;
import java.util.List;

public class CompteCourant extends Compte{

    private  int num_compte;
    private double decouvert;

    public CompteCourant(int numero, double solde, LocalDateTime dateCreation, Etat etat, List<Operation> operations, Client client, Employe employe, int num_compte, double decouvert) {
        super(numero, solde, dateCreation, etat, operations, client, employe);
        this.num_compte = num_compte;
        this.decouvert = decouvert;
    }

    public CompteCourant() {
        super();
    }

    public int getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(int num_compte) {
        this.num_compte = num_compte;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
