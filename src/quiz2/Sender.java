package quiz2;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

public class Sender extends Agent {
    Scanner input = new Scanner(System.in);
    @Override
    protected void setup() {
        String word;
        for (int i = 0; i < 5; i++) {
            word = input.next();
            ACLMessage message = new ACLMessage();
            message.addReceiver(new AID("Receiver", false));
            message.setContent(word);
            message.setPerformative(ACLMessage.INFORM);
            send(message);
        }
         addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage reply=receive();
                if(reply!=null){
                    System.out.println(reply.getContent());
                }
            }
         });
    }
}
