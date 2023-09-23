package dto;

import java.time.LocalDateTime;

public class Operation {

    private String numero;
    private LocalDateTime dateCreation;
    private double montant;
    private TYPE type;
    private Employe employe;
    private Compte compte;

    public Operation(String numero, LocalDateTime dateCreation, double montant, TYPE type, Employe employe, Compte compte) {
        this.numero = numero;
        this.dateCreation = dateCreation;
        this.montant = montant;
        this.type = type;
        this.employe = employe;
        this.compte = compte;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
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

    enum TYPE{
        virememt,
        retrait
    }
}
