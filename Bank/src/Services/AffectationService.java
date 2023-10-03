package Services;

import dto.Affectation;
import dto.Client;
import dto.Employe;
import dto.Mission;
import implimentation.AffectaionDaoImp;
import implimentation.ClientDaoImpl;
import implimentation.EmployeDaoImpl;
import implimentation.MissionDaoImp;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class AffectationService {
    public void ajouterAffectation(){
        Scanner scanner = new Scanner(System.in);

        LocalDate dateDebut = LocalDate.now();

        System.out.print("Entrez la date de fin (au format yyyy-MM-dd) : ");
        String dateFinStr = scanner.nextLine();
        LocalDate dateFin = LocalDate.parse(dateFinStr);

        System.out.print("Entrez le code de la mission : ");
        int missionCode = scanner.nextInt();
        MissionDaoImp miss = new MissionDaoImp();
        Optional<Mission> missionOptionnal = miss.chercherMissionParCode(missionCode);

        System.out.print("Entrez le matricule de l'employé : ");
        int employeMatricule = scanner.nextInt();
        EmployeDaoImpl emp = new EmployeDaoImpl();
        Optional<Employe> employeOptional = emp.chercherEmploye(employeMatricule);


        try {

            Affectation affectation = new Affectation(dateDebut, dateFin, missionOptionnal.get(), employeOptional.get());
            AffectaionDaoImp affect = new AffectaionDaoImp();

            Optional<Affectation> resultat = affect.ajouterAffectation(affectation);

            if (resultat.isPresent()) {
                System.out.println("Affectation ajouté avec succès ! : ");
            } else {
                System.out.println("Échec de l'ajout d'affectation.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie des données : " + e.getMessage());
        }

    }


    public void supprimer(){

        AffectaionDaoImp aff = new AffectaionDaoImp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le code de la mission :");
        int mission = scanner.nextInt();

        System.out.println("Entrez le matricule de client :");
        int employe = scanner.nextInt();


        int rslt = aff.supprimerAffectation(mission, employe);
        if (rslt != 0){
            System.out.println("L'affectation a été supprimée ");
        }else{
            System.out.println("L'affectation n'est pas supprimée");
            supprimer();
        }




    }
}
