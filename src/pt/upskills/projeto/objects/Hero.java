package pt.upskills.projeto.objects;
import pt.upskills.projeto.game.*;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.artifacts.FireBall;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.map.DoorClosed;
import pt.upskills.projeto.objects.map.GateOpen;
import pt.upskills.projeto.objects.map.Grass;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Hero implements ImageTile, Observer {

    private static Position position;

    private static Position lastPosition;

    private static int health = 16;

    private static int dano = 6;

    public Hero(Position position) {
        Hero.position = position;
    }

    private static int godMode = 0;

    public static void setGodMode(int godMode) {
        Hero.godMode = godMode;
    }

    public static int getHealth() { return health; }

    public static int getDano() { return dano; }

    public static void setHealth(int health) { Hero.health = health; }

    public static void setDano(int dano) { Hero.dano = dano; }

    @Override
    public String getName() {
        return "Hero";
    }

    @Override
    public Position getPosition() { return position; }

    public static Position getNewPosition() { return position; }

    public static Position getLastPosition() { return lastPosition; }

    @Override
    public void setPosition(Position position) {
        Hero.position = position;
    }

    public static void setNewPosition(Position position) {
        Hero.position = position;
    }


    public static void danoRecebido(int dano) {
        health = health - dano;
        System.out.println("Hero health: " + health);
        HealthBar.setHealthBar();
    }

    public static void movement(int X, int Y) {
        if (Engine.solids.containsKey(new Position(X, Y))) {
        } else if (Enemy.enemies.containsKey(new Position(X, Y))) {
            ImageTile enemy = Enemy.enemies.get(new Position(X, Y));
            ((Enemy) enemy).danoRecebido(getDano());
        } else {
            lastPosition = position;
            position = new Position(X, Y);
        }
    }


    public static int getGodMode() {
        return godMode;
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        Engine.solids.remove(position);
        Engine.gui.removeImage(this);

        if (keyCode == KeyEvent.VK_S) { movement(position.getX(), position.getY() + 1); }
        if (keyCode == KeyEvent.VK_W) { movement(position.getX(), position.getY() - 1); }
        if (keyCode == KeyEvent.VK_A) { movement(position.getX() - 1, position.getY()); }
        if (keyCode == KeyEvent.VK_D) { movement(position.getX() + 1, position.getY()); }

        Engine.solids.put(position, this);

        if (keyCode == KeyEvent.VK_DOWN) { FireBall.throwBall(Direction.DOWN); }
        if (keyCode == KeyEvent.VK_UP) { FireBall.throwBall(Direction.UP); }
        if (keyCode == KeyEvent.VK_LEFT) { FireBall.throwBall(Direction.LEFT); }
        if (keyCode == KeyEvent.VK_RIGHT) { FireBall.throwBall(Direction.RIGHT); }

        if (keyCode == KeyEvent.VK_1) { ItemBar.remove(7); }
        if (keyCode == KeyEvent.VK_2) { ItemBar.remove(8); }
        if (keyCode == KeyEvent.VK_3) { ItemBar.remove(9); }

        if (keyCode == KeyEvent.VK_4) { ItemBar.equip(7); }
        if (keyCode == KeyEvent.VK_5) { ItemBar.equip(8); }
        if (keyCode == KeyEvent.VK_6) { ItemBar.equip(9); }


        for(ImageTile enemy: Engine.tiles){
            if(enemy instanceof Enemy){
                ((Enemy) enemy).update();
                break;
            }
        }
        ItemBar.pickup();
        Grass.trampled();
        Engine.gui.addImage(this);
        DoorClosed.openDoor();
        GateOpen.openGate();
        LevelChange.changeLevel();
        Win.win();
        if(godMode != 666){
            Death.dying();
        }
    }
}
