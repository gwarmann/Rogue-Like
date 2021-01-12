package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.status.*;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;

public class HealthBar {

    public static ArrayList<ImageTile> health = new ArrayList<>();

    public static void healthBar() {
       health.add(new Green(new Position(3, 1)));
       health.add(new Green(new Position(4, 1)));
       health.add(new Green(new Position(5, 1)));
       health.add(new Green(new Position(6, 1)));
    }


    public static void setHealthBar() {
        switch (Hero.getHealth()){
            case 16:
                health.add(new Green(new Position(6, 1)));
                health.add(new Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                break;
            case 15:
                health.add(new Red75Green(new Position(6, 1)));
                health.add(new Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                break;
            case 14:
                health.add(new RedGreen(new Position(6, 1)));
                health.add(new Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                break;
            case 13:
                health.add(new Red25Green(new Position(6, 1)));
                health.add(new Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                break;

            case 12:
                health.add(new Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                break;
            case 11:
                health.add(new Red75Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                break;
            case 10:
                health.add(new RedGreen(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                break;
            case 9:
                health.add(new Red25Green(new Position(5, 1)));
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                break;

            case 8:
                health.add(new Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                break;
            case 7:
                health.add(new Red75Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                break;
            case 6:
                health.add(new RedGreen(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                break;
            case 5:
                health.add(new Red25Green(new Position(4, 1)));
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                break;

            case 4:
                health.add(new Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                health.add(new Red(new Position(4, 1)));
                break;
            case 3:
                health.add(new Red75Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                health.add(new Red(new Position(4, 1)));
                break;
            case 2:
                health.add(new RedGreen(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                health.add(new Red(new Position(4, 1)));
                break;
            case 1:
                health.add(new Red25Green(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                health.add(new Red(new Position(4, 1)));
                break;

            case 0:
                health.add(new Red(new Position(3, 1)));
                health.add(new Red(new Position(6, 1)));
                health.add(new Red(new Position(5, 1)));
                health.add(new Red(new Position(4, 1)));
                break;
        }
    
    Engine.gui.newStatusImages(health);

    }

    public static void breaker() {
         if (Hero.getHealth() <= 12) {
             Hero.setHealth(Hero.getHealth() + 4);
             setHealthBar();
             System.out.println("Hero health: " + Hero.getHealth());
         }
         if (Hero.getHealth() == 13) {
             Hero.setHealth(Hero.getHealth() + 3);
             setHealthBar();
             System.out.println("Hero health: " + Hero.getHealth());
         }
         if (Hero.getHealth() == 14) {
             Hero.setHealth(Hero.getHealth() + 2);
             setHealthBar();
             System.out.println("Hero health: " + Hero.getHealth());
         }
         if (Hero.getHealth() == 15) {
             Hero.setHealth(Hero.getHealth() + 1);
             setHealthBar();
             System.out.println("Hero health: " + Hero.getHealth());
         }

    }
}
