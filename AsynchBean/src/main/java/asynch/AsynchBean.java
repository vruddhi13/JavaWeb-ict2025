/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package asynch;

import jakarta.annotation.Resource;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.ejb.SessionContext;
import jakarta.inject.Inject;
import static java.lang.Math.log;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
@Stateless
@LocalBean
public class AsynchBean {
    private static final Logger log = Logger.getLogger(AsynchBean.class.getName());
    
    @Inject AsynchBean self;
    @Resource SessionContext ctx;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public int compute(){
        AsynchBean me = ctx.getBusinessObject(AsynchBean.class);
        System.out.println("!!! Compute method START on thread: " + Thread.currentThread().getName());
        try {
            
            self.goLoopA();
            self.goLoopB();
            
        } catch (InterruptedException e) {
            log.severe(e.toString());
        }
        System.out.println("!!! Compute method END on thread: " + Thread.currentThread().getName());
        return 0;
    }
    
    @Asynchronous
    public void goLoopA() throws InterruptedException{
        System.out.println("-> goLoopA START on thread: " + Thread.currentThread().getName());  
        for(int i=0; i<10 ; i++){
            Thread.sleep(1000);
            System.out.println("i= "+i);
        }
        System.out.println("<- goLoopA END on thread: " + Thread.currentThread().getName());
    }
    
    @Asynchronous
    public void goLoopB() throws InterruptedException{
        System.out.println("-> goLoopB START on thread: " + Thread.currentThread().getName()); 
        for(int j=0; j<10; j++){
            Thread.sleep(1000);
            System.out.println("j= "+j);
        }
        System.out.println("<- goLoopB END on thread: " + Thread.currentThread().getName());
    }
}
