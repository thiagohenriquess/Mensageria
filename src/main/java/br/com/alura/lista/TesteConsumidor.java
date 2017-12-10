package br.com.alura.lista;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TesteConsumidor {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination queue = (Destination) context.lookup("financeiro");
        MessageConsumer consumer = session.createConsumer(queue);

       consumer.setMessageListener(new MessageListener() {
           public void onMessage(Message message) {

               TextMessage textMessage = (TextMessage) message;

               try {
                   System.out.println(textMessage.getText());
               } catch (JMSException e) {
                   System.out.println(e.getMessage());
               }

           }
       });

       new Scanner(System.in).nextLine();


        connection.close();
        context.close();
    }
}