package dto;


import java.time.LocalDateTime;

public class Affectation {

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private Mission mission;
    private Employe employe;

    public Affectation(LocalDateTime dateDebut, LocalDateTime dateFin, Mission mission, Employe employe) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.mission = mission;
        this.employe = employe;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
