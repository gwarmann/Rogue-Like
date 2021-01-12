package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.*;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class ItemBar {

    public static Map<Position,ImageTile> artifacts = new HashMap<>();

    public static Map<Position,ImageTile> items = new HashMap<>();

    public static void pickup() {
        if (artifacts.containsKey(Hero.getNewPosition())) {
            if (artifacts.get(Hero.getNewPosition()) instanceof FireBall) {
                if (FireBar.getnFire() < 3) {
                    Engine.gui.removeImage(artifacts.get(Hero.getNewPosition()));
                    Engine.status.remove(artifacts.get(Hero.getNewPosition()));

                    FireBar.addFireBar();
                    artifacts.remove(Hero.getNewPosition());
                }
            } else if (artifacts.get(Hero.getNewPosition()) instanceof GoodMeat) {
                if (Hero.getHealth() < 16) {
                    Engine.gui.removeImage(artifacts.get(Hero.getNewPosition()));
                    Engine.status.remove(artifacts.get(Hero.getNewPosition()));

                    HealthBar.breaker();
                    artifacts.remove(Hero.getNewPosition());
                }
            } else {
                if (ItemBar.items.size() < 3) {
                    Engine.gui.removeImage(artifacts.get(Hero.getNewPosition()));
                    Engine.status.remove(artifacts.get(Hero.getNewPosition()));

                    addItemBar(artifacts.get(Hero.getNewPosition()));
                    artifacts.remove(Hero.getNewPosition());
                }
            }
        }
    }


    public static void addItemBar(ImageTile item) {
        System.out.println(item + " added to inventory");
        if (items.containsKey(new Position(7,1))) {
        } else { add(item,7); return; }

        if (items.containsKey(new Position(8,1))) {
        } else { add(item,8); return; }

        if (items.containsKey(new Position(9,1))) {
        } else { add(item,9); }
    }

    public static void add(ImageTile item, int X) {
        item.getPosition().setX(X);
        item.getPosition().setY(1);
        items.put(item.getPosition(), item);

        Engine.status.add(item);
        Engine.gui.addStatusImage(item);
        System.out.println("Inventory size: " + items.size());
    }

    public static void remove(int X) {
        if(artifacts.containsKey(Hero.getLastPosition())){
        }else {
            if(ItemBar.items.containsKey(new Position(X,1))) {
                ImageTile artifact = ItemBar.items.get(new Position(X, 1));
                Engine.status.remove(artifact);
                Engine.gui.removeStatusImage(artifact);

                artifact.setPosition(Hero.getLastPosition());

                Engine.tiles.add(artifact);
                Engine.gui.addImage(artifact);

                artifacts.put(Hero.getLastPosition(), artifact);
                ItemBar.items.remove(new Position(X, 1));

            }
        }
    }

    public static void equip(int X) {
        if(ItemBar.items.containsKey(new Position(X,1))) {
            ImageTile artifact = ItemBar.items.get(new Position(X, 1));

            if(artifact instanceof Hammer){
                Hero.setDano(Hero.getDano() + 4);
                Engine.status.remove(artifact);
                Engine.gui.removeStatusImage(artifact);
                ItemBar.items.remove(new Position(X, 1));
                System.out.println("Strenght: " + (Hero.getDano() - 4) + " plus " + 4);
            }
            if(artifact instanceof Sword){
                Hero.setDano(Hero.getDano() + 2);
                Engine.status.remove(artifact);
                Engine.gui.removeStatusImage(artifact);
                ItemBar.items.remove(new Position(X, 1));
                System.out.println("Strenght: " + (Hero.getDano() - 2) + " plus " + 2);
            }
        }
    }
}

