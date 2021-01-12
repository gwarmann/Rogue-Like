package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.ItemBar;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.*;
import pt.upskills.projeto.objects.map.DoorOpen.DoorOpen1;
import pt.upskills.projeto.objects.map.GateLocked;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.Random;

public class BadGuy extends Enemy {

    public BadGuy(Position position) {
        super(position, 25, 3);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "BadGuy0";
        } else if(LevelChange.getLevel() == 2){return "BadGuy2";
        } else{ return "BadGuy";
        }
    }

    public void movement() {
        enemies.remove(getPosition());
        Engine.gui.removeImage(this);
            if (getPosition().getY() != Hero.getNewPosition().getY()) {
                if (Engine.solids.containsKey(new Position(getPosition().getX() + 1, getPosition().getY() + 1))) {
                    danoPeriferico();

                } else {
                    if (getPosition().getY() < Hero.getNewPosition().getY()) {
                        setPosition(new Position(getPosition().getX() + 1, getPosition().getY() + 1));
                    }
                }
                if (Engine.solids.containsKey(new Position(getPosition().getX() + 1, getPosition().getY() - 1))) {
                    danoPeriferico();

                } else {
                    if (getPosition().getY() > Hero.getNewPosition().getY()) {
                        setPosition(new Position(getPosition().getX() + 1, getPosition().getY() - 1));
                    }
                }
            }
            if (getPosition().getX() != Hero.getNewPosition().getX()) {
                if (Engine.solids.containsKey(new Position(getPosition().getX() - 1, getPosition().getY() + 1))) {
                    danoPeriferico();

                } else {
                    if (getPosition().getX() < Hero.getNewPosition().getX()) {
                        setPosition(new Position(getPosition().getX() - 1, getPosition().getY() + 1));
                    }
                }
                if (Engine.solids.containsKey(new Position(getPosition().getX() - 1, getPosition().getY() - 1))) {
                    danoPeriferico();

                } else {
                    if (getPosition().getX() > Hero.getNewPosition().getX()) {
                        setPosition(new Position(getPosition().getX() - 1, getPosition().getY() - 1));
                    }
                }
            }
        enemies.put(getPosition(), this);
        Engine.gui.addImage(this);
    }

    public void danoPeriferico(){
        if (new Position(getPosition().getX() - 1, getPosition().getY() - 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX() - 1, getPosition().getY() + 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX() + 1, getPosition().getY() - 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX() + 1, getPosition().getY() + 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX(), getPosition().getY() - 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX(), getPosition().getY() + 1 ).equals(Hero.getNewPosition())
                || new Position(getPosition().getX() - 1, getPosition().getY()).equals(Hero.getNewPosition())
                || new Position(getPosition().getX() + 1, getPosition().getY()).equals(Hero.getNewPosition())
        ) {
            Hero.danoRecebido(this.getDano());
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

            if(image instanceof BadGuy || image instanceof GateLocked){ enemies--;}
        }

        if(ItemBar.artifacts.containsKey(position)){
            Engine.gui.removeImage(ItemBar.artifacts.get(position));
            Engine.tiles.remove(ItemBar.artifacts.get(position));
            ItemBar.artifacts.remove(position);
        }

        if (enemies == 0) {
            SkullKey skullkey = new SkullKey(position);
            Engine.gui.addImage(skullkey);
            Engine.tiles.add(skullkey);
            ItemBar.artifacts.put(position, skullkey);
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
