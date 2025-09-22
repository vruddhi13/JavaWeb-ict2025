/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;
import jakarta.ejb.Startup;
import jakarta.ejb.Singleton;
import jakarta.ejb.Timeout;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.ScheduleExpression;


/**
 *
 * @author HP
 */
@Startup
@Singleton
public class TimerEJB implements TimerEJBRemote{
    
    @Resource TimerService ts;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    void setTimer()
    {
        try {
            //Single Action Timer
            Timer atimer = ts.createTimer(10000, null);
            Timer timer = ts.createSingleActionTimer(30000, new TimerConfig());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Date date = sdf.parse("09/22/2025 11:45");
            // System.out.println(date.toString());
            Timer timer1 = ts.createSingleActionTimer(date, new TimerConfig());
            //Timer intervalTimer= ts.createTimer(5000, 3000, null);
            ScheduleExpression se = new ScheduleExpression();

            se.dayOfWeek("Mon");
            se.hour("*");
            se.minute("9");
            se.second("*/5");
            Timer scheduleTimer = ts.createCalendarTimer(se);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    @Timeout
    public void speakonTimeout(){
        System.out.println("My time expired at "+new Date().toString());
    }
    
    public void hi(){
        return;
    }
    
//    public static void main(String[] args) {
//        
//        TimerEJB ejb = new TimerEJB();
//        ejb.setTimer();
//    }
}
