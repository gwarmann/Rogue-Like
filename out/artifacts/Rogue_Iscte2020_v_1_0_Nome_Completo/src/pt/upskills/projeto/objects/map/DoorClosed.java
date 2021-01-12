package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.ItemBar;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.game.RoomChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Artifact;
import pt.upskills.projeto.objects.artifacts.Key;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorClosed extends Map {

    public DoorClosed(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "DoorClosed0";
        } else if(LevelChange.getLevel() == 2){return "DoorClosed2";
        } else{ return "DoorClosed";
        }
    }


    public static void openDoor(){
        pushDoor(Hero.getNewPosition().getX(), Hero.getNewPosition().getY() - 1);
        pushDoor(Hero.getNewPosition().getX(), Hero.getNewPosition().getY() + 1);
        pushDoor(Hero.getNewPosition().getX() + 1, Hero.getNewPosition().getY());
        pushDoor(Hero.getNewPosition().getX() - 1, Hero.getNewPosition().getY());

        RoomChange.changeRoom();
    }
    public static void pushDoor(int X, int Y){
        if (Engine.solids.containsKey(new Position(X,Y))) {
            if (Engine.solids.get(new Position(X, Y)).getName().equals("DoorLocked")
                    || Engine.solids.get(new Position(X, Y)).getName().equals("DoorLocked0")
                    || Engine.solids.get(new Position(X, Y)).getName().equals("DoorLocked2")
            ) {
                unlockDoor(new Position(X, Y));
            }
        }
    }

    public static void unlockDoor(Position door){
        for (ImageTile key : Engine.status) {
            if (key instanceof Key) {
                if (key.getPosition().getX() == 9) {
                    useKey(door,9);
                    break;
                }
                if (key.getPosition().getX() == 8) {
                    useKey(door,8);
                    break;
                }
                if (key.getPosition().getX() == 7) {
                    useKey(door,7);
                    break;
                }
            }
        }
    }

    public static void useKey(Position door, int X){
        ImageTile keyToRemove = ItemBar.items.get(new Position(X, 1));
        Engine.status.remove(keyToRemove);
        Engine.gui.removeStatusImage(keyToRemove);
        ItemBar.items.remove(new Position(X, 1));

        Engine.solids.remove(door);
        RoomChange.doorsNext.put(door,new DoorClosed(door));
        Engine.gui.addImage(new DoorClosed(door));
    }
}


