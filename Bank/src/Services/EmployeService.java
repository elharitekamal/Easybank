package Services;

import dto.Employe;
import implimentation.EmployeDaoImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class EmployeService {
    public void ajouterEmploye() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'un employé :");
        System.out.print("Matricule : ");
        int matricule = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Date de naissance (AAAA-MM-JJ) : ");
        String dateNaissanceStr = scanner.nextLine();
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Adresse : ");
        String adress = scanner.nextLine();
        System.out.print("Date de recrutement (AAAA-MM-JJ) : ");
        String dateRecrutementStr = scanner.nextLine();

        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, formatter);
        LocalDate dateRecrutement = LocalDate.parse(dateRecrutementStr, formatter);

        try {

            Employe employe = new Employe( nom,  prenom,  dateNaissance,  telephone,  adress,  matricule,  dateRecrutement, email);
            EmployeDaoImpl employeDao = new EmployeDaoImpl();
            Optional<Employe> resultat = employeDao.ajouterEmploye(employe);

            if (resultat.isPresent()) {
                System.out.println("Employé ajouté avec succès ! Matricule : " + resultat.get().getMatricule());
            } else {
                System.out.println("Échec de l'ajout de l'employé.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie des données : " + e.getMessage());
        }
    }



    public void supprimerEmploye(){
        EmployeDaoImpl employe = new EmployeDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le matricule d'employée que vous souhaitez SUPPRIMER :");
        int matricule = scanner.nextInt();
        int rslt = employe.supprimerEmploye(matricule);
        if (rslt != 0){
            System.out.println("L'employee a été supprimé ");
        }else{
            System.out.println("Vueillez valider le matricule que vous avez entrez");
            supprimerEmploye();
        }

    }



    public void chercherEmploye(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le matricule de l'employé à rechercher : ");
        int matricule = scanner.nextInt();

        EmployeDaoImpl emp = new EmployeDaoImpl();
        Optional<Employe> empTrouve = emp.chercherEmploye(matricule);

        if (empTrouve.isPresent()) {
            Employe employe = empTrouve.get();
            System.out.println("Employé trouvé :");
            System.out.println("Matricule : " + employe.getMatricule());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("Prénom : " + employe.getPrenom());
            System.out.println("Date de naissance : " + employe.getDateNaissance());
            System.out.println("Date de rectrutement : " + employe.getDateRecrutement());
            System.out.println("Email : " + employe.getEmail());
            System.out.println("Telephone : " + employe.getTelephone());

        } else {
            System.out.println("Aucun employé trouvé avec le matricule " + matricule);
        }
    }


    }






