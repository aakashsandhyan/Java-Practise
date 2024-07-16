import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String args[]) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("http://dev-cr-shipmentpostingtest.turvo.net/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);

        Payment payment = new Payment(25.0, "Account-1", "123123123");
        Payment payment2 = new Payment(36.0, "Account-2", "987987987");
        byte[] serialized = ObjectSerialize.serialize(payment);
        byte[] serialized2 = ObjectSerialize.serialize(payment2);
        Connection connection = null;
        try{
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
//            channel.exchangeDeclare("logs", "fanout");
//            String queuename = channel.queueDeclare().getQueue();

            channel.queueDeclare(QUEUE_NAME,false, false, false, null);
            String message = "Hello World!";
            Receive receive = new Receive();
            receive.run();
            channel.basicPublish("", QUEUE_NAME, null, serialized);
            System.out.println(" Sent msg - 1: ");
            channel.basicPublish("", QUEUE_NAME, null, serialized2);
            System.out.println(" Sent msg : - 2  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }
}
