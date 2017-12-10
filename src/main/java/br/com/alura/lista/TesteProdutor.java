package br.com.alura.lista;

import javax.jms.*;
import javax.naming.InitialContext;

public class TesteProdutor {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = (Destination) context.lookup("financeiro");

        MessageProducer messageProducer = session.createProducer(queue);

        for (int i = 1; i<= 100; i++) {
            Message message = session.createTextMessage("<id>" + i + "</id>");
            messageProducer.send(message);
        }
    }
}
