import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.sql.*;

/**
 * Write a description of class uas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class uas extends Actor
{
    /**
     * Act - do whatever the uas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_algo", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select keyboard from move where id = 1");
            while (rs.next()) {
                String keyboard = rs.getString("keyboard");
                if (keyboard.equals("w")) {
                    setLocation(getX(), getY()-15);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("connection error");
                    }
                    
                }
                
                if (keyboard.equals("s")) {
                    setLocation(getX(), getY()+15);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("connection error");
                    }
                }
                
                if (keyboard.equals("d")) {
                    setLocation(getX()+15, getY());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("connection error");
                    }
                }
                
                if (keyboard.equals("a")) {
                    setLocation(getX()-15, getY());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("connection error");
                    }
                }
            }
            conn.close();
        } catch (SQLException se) {
            System.out.println("connection error");
        }
    }
}
