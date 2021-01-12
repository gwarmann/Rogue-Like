package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.ItemBar;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.game.RoomChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Key;
import pt.upskills.projeto.objects.artifacts.SkullKey;
import pt.upskills.projeto.rogue.utils.Position;

public class GateOpen extends Map {

    public GateOpen(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "GateOpen0";
        } else if(LevelChange.getLevel() == 2){return "GateOpen2";
        } else{ return "GateOpen";
        }
    }

    public static void openGate(){
        pushGate(Hero.getNewPosition().getX(), Hero.getNewPosition().getY() - 1);
        pushGate(Hero.getNewPosition().getX(), Hero.getNewPosition().getY() + 1);
        pushGate(Hero.getNewPosition().getX() + 1, Hero.getNewPosition().getY());
        pushGate(Hero.getNewPosition().getX() - 1, Hero.getNewPosition().getY());

        RoomChange.changeRoom();
    }
    public static void pushGate(int X, int Y){
        if (Engine.solids.containsKey(new Position(X,Y))) {
            if (Engine.solids.get(new Position(X, Y)).getName().equals("GateLocked")
                    || Engine.solids.get(new Position(X, Y)).getName().equals("GateLocked0")
                    || Engine.solids.get(new Position(X, Y)).getName().equals("GateLocked2")
            ) {
                unlockGate(new Position(X, Y));
            }
        }
    }

    public static void unlockGate(Position gate){
        for (ImageTile key : Engine.status) {
            if (key instanceof SkullKey) {
                if (key.getPosition().getX() == 9) {
                    useKey(gate,9);
                    break;
                }
                if (key.getPosition().getX() == 8) {
                    useKey(gate,8);
                    break;
                }
                if (key.getPosition().getX() == 7) {
                    useKey(gate,7);
                    break;
                }
            }
        }
    }

    public static void useKey(Position gate, int X){
        ImageTile keyToRemove = ItemBar.items.get(new Position(X, 1));
        Engine.status.remove(keyToRemove);
        Engine.gui.removeStatusImage(keyToRemove);
        ItemBar.items.remove(new Position(X, 1));

        Engine.solids.remove(gate);
        RoomChange.gatesNext.put(gate,new GateOpen(gate));
        Engine.gui.addImage(new GateOpen(gate));
    }
}


