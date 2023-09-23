package Services;

import dto.Client;
import dto.Employe;
import implimentation.ClientDaoImpl;
import implimentation.EmployeDaoImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class ClientService {

    public void ajouterClient() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir les informations du client :");

        System.out.print("Code du client : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Date de naissance (AAAA-MM-JJ) : ");
        String dateNaissanceStr = scanner.nextLine();
        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, formatter);
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Adresse : ");
        String adress = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();

        try {

            Client client = new Client(nom, prenom, dateNaissance, telephone, adress, code, email);
            ClientDaoImpl clientDao = new ClientDaoImpl();
            Optional<Client> resultat = clientDao.ajouterClient(client);

            if (resultat.isPresent()) {
                System.out.println("Client ajouté avec succès ! Code : " + resultat.get().getCode());
            } else {
                System.out.println("Échec de l'ajout de client.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie des données : " + e.getMessage());
        }

    }


}
