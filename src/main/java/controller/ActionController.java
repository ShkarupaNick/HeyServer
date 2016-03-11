package controller;

import db.PSQLConnector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Syma on 06.02.2016.
 */
public class ActionController {
    public static final Logger log = Logger.getLogger(ActionController.class);

    private String action;
    private String result;


    public ActionController(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void executeAction(){
        PSQLConnector c = new PSQLConnector();
        StringBuilder stringBuilder = new StringBuilder("");


        switch (action) {
            case "send_message":
                break;
            case "get_messages":
                try {
                    ResultSet resultSet = c.execQuery("select message_id, message_content from public.message");
                    log.debug("SQL --> select message_id, message_content from public.message");
                    while (resultSet.next()) {
                        stringBuilder.append(resultSet.getString(1));
                        stringBuilder.append(":");
                        stringBuilder.append(resultSet.getString(2));
                        stringBuilder.append(";");

                    }
                    result = stringBuilder.toString();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "get_message_log":


                break;
        }



    }
}
