/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.Date;

/**
 *
 * @author HP
 */
@Startup
@Singleton
@LocalBean
public class SchedularBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    void initialize() {
        // speakOnSchedule();
    }

    public void hi() {
        // System.out.println("executing on my schedule "+ new Date());
        return;
    }

    @Schedule(dayOfWeek = "*", month = "*", year = "*", hour = "0-23", minute = "58", second = "*/5")
    void speakOnSchedule() {
        System.out.println("executing on my schedule " + new Date());
    }
    
    public static void main(String[] args) {
        
        SchedularBean bn = new SchedularBean();
    }
    
}
