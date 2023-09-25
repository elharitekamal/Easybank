package Services;

import dto.Compte;
import dto.CompteCourant;
import dto.Employe;
import implimentation.CompteCourantImp;

import java.time.LocalDateTime;

import java.util.Optional;
import java.util.Scanner;

public class CompteCourantService {
    public void ajouterCompteC(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Numero: ");
        int numero = scanner.nextInt();

        System.out.print("Enter Solde: ");
        double solde = scanner.nextDouble();

        System.out.print("Enter Date Creation (yyyy-MM-dd HH:mm:ss): ");

        String dateCreationStr = scanner.next();

        LocalDateTime dateCreation = LocalDateTime.parse(dateCreationStr);

        System.out.print("Enter Etat (actif or inactif): ");
        String etatStr = scanner.next();
        Compte.Etat etat = Compte.Etat.valueOf(etatStr);

        System.out.print("Enter Client: ");
        int client = scanner.nextInt();

        System.out.print("Enter Employe: ");
        int employe = scanner.nextInt();

        System.out.print("Enter Decouvert: ");
        double decouvert = scanner.nextDouble();

        scanner.close();



        try {

            CompteCourant compteCourant = new CompteCourant();
            CompteCourantImp employeimp = new CompteCourantImp();
            Optional<CompteCourant> resultat = employeimp.ajouterCompteC(compteCourant);

            if (resultat.isPresent()) {
                System.out.println("Employé ajouté avec succès ! Matricule : ");
            } else {
                System.out.println("Échec de l'ajout de l'employé.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie des données : " + e.getMessage());
        }
    }
}
