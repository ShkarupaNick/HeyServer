package controller;

import db.PSQLConnector;
import org.apache.log4j.Logger;
import parser.RequestParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Syma on 06.02.2016.
 */
public class ActionController {
    public static final Logger log = Logger.getLogger(ActionController.class);
    private RequestParser parser;
    private String action;
    private String result;


    public ActionController(RequestParser p) {
        this.parser = p;
        this.action = p.getAction();
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
                        stringBuilder.append("{");
                        stringBuilder.append(resultSet.getString(1));
                        stringBuilder.append(":");
                        stringBuilder.append(resultSet.getString(2));
                        stringBuilder.append("}");

                    }
                    result = stringBuilder.toString().equals("")?"null":stringBuilder.toString();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "get_new_messages":
                try {
                    ResultSet resultSet = c.execQuery("   select sender_phone_number, recipient_phone_number, sending_date, m.message_content from message_log ml \n" +
                            "    join message m on m.message_id = ml.message_id and upper(ml.delivering_status) = 'NEW' and recipient_phone_number = '"+ parser.getRecipientPhone()+"'");
                    log.debug("SQL -->    select sender_phone_number, recipient_phone_number, sending_date, m.message_content from message_log ml \njoin message m on m.message_id = ml.message_id and upper(ml.delivering_status) = 'NEW'");
                    stringBuilder = new StringBuilder("");
                    while (resultSet.next()) {
                        stringBuilder.append("{sender_phone_number:");
                        stringBuilder.append(resultSet.getString(1));
                        stringBuilder.append(";");
                        stringBuilder.append("sending_date:");
                        stringBuilder.append(resultSet.getString(3));
                        stringBuilder.append(";");
                        stringBuilder.append("message_content:");
                        stringBuilder.append(resultSet.getString(4));
                        stringBuilder.append("}");
                    }
                    result = stringBuilder.toString();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
        }



    }
}
