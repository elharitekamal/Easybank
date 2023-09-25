package dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CompteEpargne extends Compte{

    private  int num_compte;
    private double tauxInteret;


    public CompteEpargne(int numero, double solde, LocalDateTime dateCreation, Etat etat, Client client, Employe employe) {
        super(numero, solde, dateCreation, etat, client, employe);
    }

    public int getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(int num_compte) {
        this.num_compte = num_compte;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
