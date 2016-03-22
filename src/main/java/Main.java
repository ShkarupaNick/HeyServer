import client.Client;
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

        Client c = new Client();
        c.sendMessage("action:get_new_messages;380997085725");
        c.sendMessage("action:get_messages");
    }
}
