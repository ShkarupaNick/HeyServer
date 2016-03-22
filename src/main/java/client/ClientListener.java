package client;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Administrator on 3/22/2016.
 */
public class ClientListener extends Thread{
    private final Socket socket;
    public static final Logger log  = Logger.getLogger(Client.class);


    public ClientListener(Socket socket){
        this.socket = socket;
        this.setDaemon(true);
    }

    public void run() {
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            while (true){
               log.info ((String)input.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
