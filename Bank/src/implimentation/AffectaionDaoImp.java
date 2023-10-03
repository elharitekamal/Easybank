package implimentation;

import dao.AffectationDao;
import dto.Affectation;
import dto.Employe;
import dto.Mission;
import helper.Connectionbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AffectaionDaoImp implements AffectationDao {
    @Override
    public Optional<Affectation> ajouterAffectation(Affectation affectation) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "INSERT INTO affectation (datedebut, datefin, mission, employe) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(affectation.getDateDebut()));
            stmt.setDate(2, java.sql.Date.valueOf(affectation.getDateFin()));
            stmt.setInt(3, affectation.getMission().getCode());
            stmt.setInt(4, affectation.getEmploye().getMatricule());


            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.of(affectation);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public int supprimerAffectation(int mission, int employe) {
        Connection con = Connectionbd.getConn();
        try {
            String deleteQuery = "DELETE FROM affectation WHERE mission = ? and employe = ?";
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, mission);
            deleteStmt.setInt(2, employe);


            int rowsAffected = deleteStmt.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
