import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import sun.rmi.server.DeserializationChecker;

import java.io.IOException;

public class Receive{

    private final static String QUEUE_NAME = "TechTalkQueue";
    ConnectionFactory factory;
    Channel channel;

    public Receive() throws Exception{
        factory = new ConnectionFactory();
        factory.setHost("10.1.10.111");
        factory.setUsername("guest");
        factory.setPassword("@TurvoPleasel3tm31n");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for messages...");

    }

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println("Received msg: " + message);
    };

    public void run() {
        try {
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
