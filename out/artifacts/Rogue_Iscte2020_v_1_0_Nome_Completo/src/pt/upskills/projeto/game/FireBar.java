package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.artifacts.FireBall;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.objects.status.Black2;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;

public class FireBar {

    public static ArrayList<ImageTile> fire = new ArrayList<>();

    private static int nFire = 3;

    public static int getnFire() {
        return nFire;
    }

    public static void fireBar(){
            fire.add(new FireBall(new Position(2, 1)));
            fire.add(new FireBall(new Position(1, 1)));
            fire.add(new FireBall(new Position(0, 1)));
    }

    public static void removeFireBar() {
        nFire--;
        System.out.println("Fire Balls left: " + nFire);

        switch (nFire){
            case 2: fire.add(new Black2(new Position(2, 1))); break;
            case 1: fire.add(new Black2(new Position(1, 1))); break;
            case 0: fire.add(new Black2(new Position(0, 1)));break;
        }

        Engine.gui.newStatusImages(fire);
    }

    public static void setnFire(int nFire) {
        FireBar.nFire = nFire;
    }

    public static void addFireBar() {
        nFire++;
        System.out.println("Fire Balls left: " + nFire);

        switch (nFire){
            case 3: fire.add(new FireBall(new Position(2, 1))); break;
            case 2: fire.add(new FireBall(new Position(1, 1))); break;
            case 1: fire.add(new FireBall(new Position(0, 1)));break;
        }

        Engine.gui.newStatusImages(fire);
    }

}

