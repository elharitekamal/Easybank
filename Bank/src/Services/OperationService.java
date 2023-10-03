package Services;

import dto.Employe;
import dto.Operation;
import implimentation.EmployeDaoImpl;
import implimentation.OperationDaoImp;

import java.util.Optional;
import java.util.Scanner;

public class OperationService {
    public void retrait(){
        Scanner scanner = new Scanner(System.in);
        OperationDaoImp op = new OperationDaoImp();

        System.out.print("Veuillez entrer le numéro d'employe : ");
        int employe = scanner.nextInt();
        EmployeDaoImpl emp = new EmployeDaoImpl();
        Optional<Employe> employeOptional = emp.chercherEmploye(employe);

        System.out.print("Veuillez entrer le numéro de compte : ");
        int numero = scanner.nextInt();


        System.out.print("Veuillez entrer le montant du retrait : ");
        double montant = scanner.nextDouble();

        Optional<Operation> retraitReussi = op.effectuerRetrait(numero, montant, employeOptional.get());

        if(retraitReussi.isPresent()){
            System.out.print("Le retrait a été bien éffectué");

        }else{
            System.out.print("Veuillez ressayer");

        }

    }

    public void virement(){
        Scanner scanner = new Scanner(System.in);
        OperationDaoImp op = new OperationDaoImp();

        System.out.print("Veuillez entrer le numéro d'employe : ");
        int employe = scanner.nextInt();
        EmployeDaoImpl emp = new EmployeDaoImpl();
        Optional<Employe> employeOptional = emp.chercherEmploye(employe);

        System.out.print("Veuillez entrer le numéro de compte source : ");
        int numeroS = scanner.nextInt();

        System.out.print("Veuillez entrer le numéro de compte destinataire : ");
        int numeroD = scanner.nextInt();

        System.out.print("Veuillez entrer le montant de virement : ");
        int montant = scanner.nextInt();

        Optional<Operation> virementReussi = op.effectuerVirement(numeroS, numeroD, montant,  employeOptional.get());

        if(virementReussi.isPresent()){
            System.out.print("Le virement a été bien éffectué .");

        }else{
            System.out.print("Veuillez ressayer");

        }

    }

    public void supprimer(){
        OperationDaoImp op = new OperationDaoImp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numero d'operation que vous souhaitez SUPPRIMER :");
        int numero = scanner.nextInt();
        int rslt = op.supprimerOperation(numero);
        if (rslt != 0){
            System.out.println("L'operation a été supprimé ");
        }else{
            System.out.println("Vueillez valider le numero que vous avez entrez");
            supprimer();
        }
    }


    public void chercherOperation(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le numéro de l'opération à rechercher : ");
        int numero = scanner.nextInt();

        OperationDaoImp op = new OperationDaoImp();
        Optional<Operation> opTrouve = op.chercherOperationParNumero(numero);

        if (opTrouve.isPresent()) {
            Operation oper = opTrouve.get();
            System.out.println("Operation trouvée :");
            System.out.println("Numero : " + oper.getNumero());
            System.out.println("Date de creation : " + oper.getDateCreation());
            System.out.println("Montant : " + oper.getMontant());
            System.out.println("Type d'operation : " + oper.getType());
            System.out.println("Le numero d'employe : " + oper.getEmploye().getMatricule());

        } else {
            System.out.println("Aucun opération trouvée avec le matricule " + numero);
        }
    }
}
