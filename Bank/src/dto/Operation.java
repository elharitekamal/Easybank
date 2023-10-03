package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Operation {

    private int numero;
    private Date dateCreation;
    private double montant;
    private TYPE type;
    private Employe employe;
    private Compte compte;

    public Operation(Date dateCreation, double montant, TYPE type, Employe employe) {
        this.dateCreation = dateCreation;
        this.montant = montant;
        this.type = type;
        this.employe = employe;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Operation(int numero, Date dateCreation, double montant, TYPE type, Employe employe) {
        this.numero = numero;
        this.dateCreation = dateCreation;
        this.montant = montant;
        this.type = type;
        this.employe = employe;
    }

    public enum TYPE{
        virement,
        retrait
    }
}
