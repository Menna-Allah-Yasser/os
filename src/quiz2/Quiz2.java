
package quiz2;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;


public class Quiz2 {
    public static void main(String[] args) {
        jade.core.Runtime r=jade.core.Runtime.instance();
       Profile p=new ProfileImpl("localhost",2001,"MnaPlatform");
       ContainerController Main=r.createMainContainer(p);
       try{
       AgentController rma=Main.createNewAgent("jade" , "jade.tools.rma.rma" , null);
       rma.start();
       
       AgentController Sender=Main.createNewAgent("Sender", "quiz2.Sender", null);
       Sender.start();
       
       AgentController receiver=Main.createNewAgent("Receiver", "quiz2.Receiver", null);
       receiver.start();
        }catch(Exception ex){
            System.out.println("ex");
        }
    }
    
}
