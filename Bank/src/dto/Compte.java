package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Compte {

    private int numero;
    private double solde;
    private LocalDateTime dateCreation;
    private Etat etat;
    private List<Operation> operations;
    private Client client;

    private Employe employe;


    public int getEmploye() {
        return employe.getMatricule();
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getClient() {
        return client.getCode();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Compte(int numero, double solde, LocalDateTime dateCreation, Etat etat,  Client client, Employe employe) {
        this.numero = numero;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.etat = etat;
        this.client = client;
        this.employe = employe;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "etat=" + etat +
                '}';
    }

    public enum Etat{
        actif,
        inactif
    }
}
