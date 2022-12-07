
package quiz2;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Receiver extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage message=receive();
                if(message !=null){
                    String content=message.getContent();
                    if(content.equalsIgnoreCase("apple"))
                    {
                        ACLMessage reply=message.createReply();
                        reply.setContent("تفاحه");
                        send(reply);
                    }
                }
            }
        
    });
    }
}
