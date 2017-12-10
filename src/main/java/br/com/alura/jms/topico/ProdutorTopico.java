package br.com.alura.jms.topico;

import javax.jms.*;
import javax.naming.InitialContext;

public class ProdutorTopico {
    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination topic = (Destination) context.lookup("estoque");

        MessageProducer messageProducer = session.createProducer(topic);

        for (int i = 1; i<= 20; i++) {
            Message message = session.createTextMessage("<id>" + i + "</id>");
            messageProducer.send(message);
        }
    }
}
