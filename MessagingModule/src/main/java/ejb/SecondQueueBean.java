/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueConnectionFactory;
import jakarta.jms.QueueSession;
import jakarta.jms.TextMessage;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author HP
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/ictQue2"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ictQue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/ictQue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class SecondQueueBean implements MessageListener {
    
    public SecondQueueBean() {
    }
    
    @Override
    public void onMessage(Message message) {

        try {
            TextMessage tmsg = (TextMessage) message;

            String msg = tmsg.getText();

            System.out.println("Message Recieved By SecondQueueBean:" + msg);

        } catch (JMSException ex) {
            ex.printStackTrace();
        }

        try {

            Properties p = new Properties();
            p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");

            InitialContext ic = new InitialContext(p);

            Queue queue = (Queue) ic.lookup("jms/mware");
            QueueConnectionFactory cf = (QueueConnectionFactory) ic.lookup("jms/mwareFactory");
            QueueConnection con = cf.createQueueConnection();
            QueueSession session = con.createQueueSession(true, 0);
            MessageProducer mp = session.createProducer(queue);
            TextMessage tm = session.createTextMessage();
            tm.setText("Message forwarded to Reciever servlet by SecondQueueBean");
            mp.send(tm);
        } catch (Exception je) {
            je.printStackTrace();
        }
    }
    
}
