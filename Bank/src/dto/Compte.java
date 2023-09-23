package dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Compte {

    private String numero;
    private double solde;
    private LocalDateTime dateCreation;
    private Etat etat;
    private List<Operation> operations;
    private Client client;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Compte(String numero, double solde, LocalDateTime dateCreation, Etat etat, List<Operation> operations, Client client) {
        this.numero = numero;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.etat = etat;
        this.operations = operations;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", etat=" + etat +
                ", operations=" + operations +
                ", client=" + client +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Double.compare(solde, compte.solde) == 0 && Objects.equals(numero, compte.numero) && Objects.equals(dateCreation, compte.dateCreation) && etat == compte.etat && Objects.equals(operations, compte.operations) && Objects.equals(client, compte.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, solde, dateCreation, etat, operations, client);
    }

    enum Etat{
        actif,
        inactif
    }
}
