package br.com.alura;

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

        Message message = consumer.receive();

        System.out.println("Recebendo mensagem: " + message);
        new Scanner(System.in).nextLine(); //parar o programa para testar a conexao


        connection.close();
        context.close();
    }
}