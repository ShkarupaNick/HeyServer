import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.log4j.Logger;

/**
 * Created by Syma on 06.02.2016.
 */
public class RequestParser {
    public static final Logger log  = Logger.getLogger(RequestParser.class);
    private String action;
    private String inputString;
    private String senderPhone;
    private String recipientPhone;
    private String message;

    public RequestParser(String inputString) {
        this.inputString = inputString;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "RequestParser{" +
                "action='" + action + '\'' +
                ", senderPhone='" + senderPhone + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void parse() {
        if (inputString.startsWith("action:get_messages")) {
            action = "get_messages";
        } else if (inputString.startsWith("action:send_message")) {
            String[] inputData = inputString.split(";");

            action = inputData[0].replace("action:", "");
            senderPhone = inputData[1];
            recipientPhone = inputData[2];
            message = inputData[3];
        }
    }


    private String validatePhoneNumber(){

        //TODO написать валидайию телефонов
      /*  try {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil
                    .getInstance();
            Phonenumber phNumberProto =      phoneUtil.parse(senderPhone, "UA");
            // check if the number is valid
            boolean isValid = phoneUtil.isValidNumber();
        } catch (NumberParseException e) {
            log.error(e.getMessage());
        }*/

        return null;
    }
}
