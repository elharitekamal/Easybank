package implimentation;

import dao.CompteCourantdao;
import dto.CompteCourant;
import helper.Connectionbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class CompteCourantImp implements CompteCourantdao {
    @Override
    public Optional<CompteCourant> ajouterCompteC(CompteCourant compteCourant) {
        Connection con = Connectionbd.getConn();
        try {
            String sql = "CALL create_compteCourant(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, compteCourant.getNumero());
            stmt.setDouble(2, compteCourant.getSolde());
            stmt.setTimestamp(3, Timestamp.valueOf(compteCourant.getDateCreation()));
            stmt.setString(4, compteCourant.getEtat().name()); // Convert Enum to String
            stmt.setInt(5, compteCourant.getClient());
            stmt.setInt(6, compteCourant.getEmploye());
            stmt.setDouble(7, compteCourant.getDecouvert());


            stmt.execute();

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return Optional.of(compteCourant);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.of(compteCourant);
        }
    }


}
