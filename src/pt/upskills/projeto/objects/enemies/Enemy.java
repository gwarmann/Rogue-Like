package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.ItemBar;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Artifact;
import pt.upskills.projeto.objects.artifacts.FireBall;
import pt.upskills.projeto.objects.artifacts.GoodMeat;
import pt.upskills.projeto.objects.artifacts.Key;
import pt.upskills.projeto.objects.map.DoorOpen.DoorOpen1;
import pt.upskills.projeto.objects.map.GateLocked;
import pt.upskills.projeto.objects.map.TrapTrigered;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Enemy implements ImageTile {

    private Position position;

    private int dano;

    private int health;

    public static Map<Position,ImageTile> enemies = new HashMap<>();

    public Enemy(Position position, int health, int dano) {
        this.position = position;
        this.health = health;
        this.dano = dano;
    }

    public int getHealth() { return health; }

    public int getDano() { return dano; }

    public void setPosition(Position position) { this.position = position; }

    public void setHealth(int health) { this.health = health; }

    @Override
    public abstract String getName();

    @Override
    public Position getPosition() { return position; }

    public void update(){
        for (ImageTile enemy : Engine.tiles) {
            if (enemy instanceof Enemy) {
                if (((Enemy) enemy).getHealth() > 0) {
                    ((Enemy) enemy).movement();
                } else {
                    Engine.tiles.remove(enemy);
                    Engine.gui.removeImage(enemy);
                    enemies.remove(enemy.getPosition());
                    if (enemy instanceof Trap) {
                        Engine.tiles.add(new TrapTrigered(enemy.getPosition()));
                        Engine.gui.addImage(new TrapTrigered(enemy.getPosition()));
                    } else {
                        drop(enemy.getPosition());
                    }
                    break;
                }
            }
        }
    }

    public void danoRecebido(int dano) {
        setHealth((getHealth() - dano));
    }

    public void movement() {
        enemies.remove(getPosition());
        Engine.gui.removeImage(this);
        int range = 4;
            if(Hero.getNewPosition().getX() - getPosition().getX() < range
                    && getPosition().getX() - Hero.getNewPosition().getX()  < range
                    && Hero.getNewPosition().getY() - getPosition().getY() < range
                    && getPosition().getY() - Hero.getNewPosition().getY()  < range) {
                agressive();
            } else {
                passive();
            }
        enemies.put(getPosition(), this);
        Engine.gui.addImage(this);
    }

    public void passive() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0: passiveMovement(getPosition().getX(), getPosition().getY() + 1);break;
            case 1: passiveMovement(getPosition().getX(), getPosition().getY() - 1);break;
            case 2: passiveMovement(getPosition().getX() + 1, getPosition().getY());break;
            case 3: passiveMovement(getPosition().getX() - 1, getPosition().getY());break;
        }
    }

    public void passiveMovement(int X, int Y){
        if (Engine.solids.containsKey(new Position(X, Y))) {
        } else if(enemies.containsKey(new Position(X, Y))) {
        } else {
            setPosition(new Position(X, Y));}
    }

    public void agressive(){
        if (getPosition().getY() != Hero.getNewPosition().getY()) {
            if (Engine.solids.containsKey(new Position(getPosition().getX(), getPosition().getY() + 1))) {
                if (new Position(getPosition().getX(), getPosition().getY() + 1).equals(Hero.getNewPosition())) {
                    Hero.danoRecebido(this.getDano());
                }
            } else if(enemies.containsKey(new Position(getPosition().getX(), getPosition().getY() + 1))) {
            } else {
                if (getPosition().getY() < Hero.getNewPosition().getY()) {
                    setPosition(new Position(getPosition().getX(), getPosition().getY() + 1));
                }
            }
            if (Engine.solids.containsKey(new Position(getPosition().getX(), getPosition().getY() - 1))) {
                if (new Position(getPosition().getX(), getPosition().getY() - 1).equals(Hero.getNewPosition())) {
                    Hero.danoRecebido(this.getDano());
                }
            } else if(enemies.containsKey(new Position(getPosition().getX(), getPosition().getY() - 1))) {
            } else {
                if (getPosition().getY() > Hero.getNewPosition().getY()) {
                    setPosition(new Position(getPosition().getX(), getPosition().getY() - 1));
                }
            }
        }
        if (getPosition().getX() != Hero.getNewPosition().getX()) {
            if (Engine.solids.containsKey(new Position(getPosition().getX() + 1, getPosition().getY()))) {
                if (new Position(getPosition().getX() + 1, getPosition().getY()).equals(Hero.getNewPosition())) {
                    Hero.danoRecebido(this.getDano());
                }
            } else if(enemies.containsKey(new Position(getPosition().getX() + 1, getPosition().getY()))) {
            } else {
                if (getPosition().getX() < Hero.getNewPosition().getX()) {
                    setPosition(new Position(getPosition().getX() + 1, getPosition().getY()));
                }
            }
            if (Engine.solids.containsKey(new Position(getPosition().getX() - 1, getPosition().getY()))) {
                if (new Position(getPosition().getX() - 1, getPosition().getY()).equals(Hero.getNewPosition())) {
                    Hero.danoRecebido(this.getDano());
                }
            } else if(enemies.containsKey(new Position(getPosition().getX() - 1, getPosition().getY()))) {
            } else {
                if (getPosition().getX() > Hero.getNewPosition().getX()) {
                    setPosition(new Position(getPosition().getX() - 1, getPosition().getY()));
                }
            }
        }
    }

    public void drop(Position position) {
        int enemies = 0;
        for (ImageTile image : Engine.tiles) {
            if(image instanceof Enemy) { enemies++; }
            if(image instanceof Trap){ enemies--; }
            if(image instanceof DoorOpen1){ enemies++; }
            if(image instanceof BadGuy){ enemies++; }
            if(image instanceof GateLocked){ enemies++; }

        }

        if(ItemBar.artifacts.containsKey(position)){
            Engine.gui.removeImage(ItemBar.artifacts.get(position));
            Engine.tiles.remove(ItemBar.artifacts.get(position));
            ItemBar.artifacts.remove(position);
        }

        if (enemies == 0) {
            Key key = new Key(position);
            Engine.gui.addImage(key);
            Engine.tiles.add(key);
            ItemBar.artifacts.put(position, key);
        } else {
            randomDrop(position);
        }
    }

    public void randomDrop(Position position){
        Random random = new Random();
        int woo = random.nextInt(5);
        if (woo == 0) {
            GoodMeat goodMeat = new GoodMeat(position);
            Engine.tiles.add(goodMeat);
            Engine.gui.addImage(goodMeat);
            ItemBar.artifacts.put(position, goodMeat);
        }
        if (woo == 1) {
            FireBall fire = new FireBall(position);
            Engine.tiles.add(fire);
            Engine.gui.addImage(fire);
            ItemBar.artifacts.put(position, fire);
        }
    }
}


