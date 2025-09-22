/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;
import jakarta.ejb.Remote;
/**
 *
 * @author HP
 */
@Remote
public interface TimerEJBRemote {
    void speakonTimeout();
    void hi();
}
