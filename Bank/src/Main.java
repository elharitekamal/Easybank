import Services.ClientService;
import Services.CompteCourantService;
import Services.EmployeService;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        EmployeService emp = new EmployeService();
        ClientService cli = new ClientService();
        CompteCourantService compteC = new CompteCourantService();

        while (x) {

            System.out.println("Options:");
            System.out.println("1. Ajouter un employee");
            System.out.println("2. Supprimer un employee");
            System.out.println("3. Chercher un employee par matricule ");
            System.out.println("4. Ajouter un client ");
            System.out.println("5. Supprimer un Client");
            System.out.println("6. Chercher un client par code");
            System.out.println("7.Ajouter un compte courant");
            System.out.println("8.Ajouter un compte epargne");
            System.out.println("9.");
            System.out.println("10. ");
            System.out.println("11.");
            System.out.println("12.");
            System.out.println("13. ");
            System.out.println("14.");
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
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
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






