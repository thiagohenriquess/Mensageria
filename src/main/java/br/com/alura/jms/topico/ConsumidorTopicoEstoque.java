package br.com.alura.jms.topico;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

public class ConsumidorTopicoEstoque {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.setClientID("estoque");
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Topic topico = (Topic) context.lookup("estoque");
        MessageConsumer consumer = session.createDurableSubscriber(topico,"assinatura");

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
