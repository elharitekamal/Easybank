import Services.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        EmployeService emp = new EmployeService();
        ClientService cli = new ClientService();
        CompteCourantService compteC = new CompteCourantService();
        CompteEpargneService compteE = new CompteEpargneService();
        CompteService compte = new CompteService();
        OperationService ope = new OperationService();
        MissionService miss = new MissionService();
        AffectationService aff = new AffectationService();

        while (x) {

            System.out.println("Options:");
            System.out.println("1. Ajouter un employee");
            System.out.println("2. Supprimer un employee");
            System.out.println("3. Chercher un employee par matricule ");
            System.out.println("4. Ajouter un client ");
            System.out.println("5. Supprimer un Client");
            System.out.println("6. Chercher un client par code");
            System.out.println("7. Ajouter un compte courant");
            System.out.println("8. Ajouter un compte epargne");
            System.out.println("9. Supprimer un compte");
            System.out.println("10. Chercher compte par client");
            System.out.println("11. Effectuer un retrait");
            System.out.println("12. Effectuer un virement");
            System.out.println("13. Supprimer une oppération");
            System.out.println("14. Chercher une opération par son numéro");
            System.out.println("15. Ajouter une mission");
            System.out.println("16. Supprimer une mission");
            System.out.println("17. Afficher la liste des employés");
            System.out.println("18. Chercher employé par Telephone");
            System.out.println("19. Afficher la liste des clients");
            System.out.println("20. Chercher client par Telephone");
            System.out.println("21. Modifier l'etat de compte");
            System.out.println("22. Lister les comptes");
            System.out.println("23. Lister les comptes selon Le statut");
            System.out.println("24. Lister les comptes par date de création");
            System.out.println("25. Afficher liste des missions ");
            System.out.println("26. Ajouter une affectation");
            System.out.println("27. Supprimer une affectation");
            System.out.println("28. Modifier un employé");
            System.out.println("29. Modifier un client");











            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    emp.ajouterEmploye();
                    break;
                case 2:
                    emp.supprimerEmploye();
                    break;
                case 3:
                    emp.chercherEmploye();
                    break;
                case 4:
                    cli.ajouterClient();
                    break;
                case 5:
                    cli.supprimerClient();
                    break;
                case 6:
                    cli.chercherClient();
                    break;
                case 7:
                    compteC.ajouterCompteC();
                    break;
                case 8:
                    compteE.ajouterCompteE();
                    break;
                case 9:
                    compteC.supprimerCompte();
                    break;
                case 10:
                    compte.chercherToutCompte();
                    break;
                case 11:
                    ope.retrait();
                    break;
                case 12:
                    ope.virement();
                    break;
                case 13:
                    ope.supprimer();
                    break;
                case 14:
                    ope.chercherOperation();
                    break;
                case 15:
                    miss.ajouterMission();
                    break;
                case 16:
                    miss.supprimer();
                    break;
                case 17:
                    emp.afficherList();
                    break;
                case 18:
                    emp.chercherEmployeparTel();
                    break;
                case 19:
                    cli.afficherList();
                    break;
                case 20:
                    cli.chercherClientTel();
                    break;
                case 21:
                    compte.modifierEtat();
                    break;
                case 22:
                    compte.listerCompte();
                    break;
                case 23:
                    compte.ListerParStatut();
                    break;
                case 24:
                    compte.ListerParDateCreation();
                    break;
                case 25:
                    miss.afficherList();
                    break;
                case 26:
                    aff.ajouterAffectation();
                    break;
                case 27:
                    aff.supprimer();
                    break;
                case 28:
                    emp.modifierEmploye();
                    break;
                case 29:
                    cli.modifierClient();
                    break;
                case 30:
                    compteE.modifierCompteEpargne();
                    break;
                case 0:
                    x = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide SVP.");
                    break;
            }

        }
    }

}






