import db.PSQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Syma on 06.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Server()).start();
     /*   PSQLConnector c = new PSQLConnector();
        Connection connection = c.getConnection();
        try {
            Statement stm = connection.prepareStatement("SELECT * FROM PUBLIC.MESSAGE");

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
