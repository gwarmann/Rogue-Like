package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Artifact;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.map.*;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomChange {

    static int room = 0;

    static int lastRoom;

    public static int getLastRoom() { return lastRoom; }

    public static void setRoom(int room) { RoomChange.room = room; }

    public static int getRoom() { return room; }

    public static Map<Position,ImageTile> doorsNext = new HashMap<>();
    public static Map<Position,ImageTile> doorsPrevious = new HashMap<>();
    public static Map<Position,ImageTile> doorsAltRightNext = new HashMap<>();
    public static Map<Position,ImageTile> doorsAltRightPrevious = new HashMap<>();
    public static Map<Position,ImageTile> doorsAltLeftNext = new HashMap<>();
    public static Map<Position,ImageTile> doorsAltLeftPrevious = new HashMap<>();
    public static Map<Position,ImageTile> gatesNext = new HashMap<>();
    public static Map<Position,ImageTile> gatesPrevious = new HashMap<>();


    public static void changeRoomNum(int room){
        Engine.gui.clearImages();
        Engine.gui.deleteObservers();
        Engine.tiles.clear();
        Engine.solids.clear();
        Enemy.enemies.clear();
        LevelChange.stairsPrevious.clear();
        LevelChange.stairsNext.clear();
        ItemBar.artifacts.clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Engine.tiles.add(new Floor(new Position(i, j)));
            }
        }
        Engine.readMapFile(LevelChange.getLevel(), room, Engine.tiles);
        Engine.gui.newImages(Engine.tiles);
        Engine.gui.go();
    }

    public static void changeRoom(){
        if(doorsNext.containsKey(Hero.getNewPosition())){
            room++;
            changeRoomNum(room);
            doorsNext.clear();
            return;
        }
        if(doorsPrevious.containsKey(Hero.getNewPosition())){
            room--;
            changeRoomNum(room);
            Hero.setNewPosition(new Position(4,1));
            doorsPrevious.clear();
            return;
        }
        if(doorsAltRightNext.containsKey(Hero.getNewPosition())){
            room = room + 10;
            changeRoomNum(room);
            doorsAltRightNext.clear();
            return;
        }
        if(doorsAltRightPrevious.containsKey(Hero.getNewPosition())){
            room = room - 10;
            changeRoomNum(room);
            Hero.setNewPosition(new Position(8,7));
            doorsAltRightPrevious.clear();
            return;
        }

        if(doorsAltLeftNext.containsKey(Hero.getNewPosition())){
            room = room + 20;
            changeRoomNum(room);
            doorsAltLeftNext.clear();
            return;
        }
        if(doorsAltLeftPrevious.containsKey(Hero.getNewPosition())){
            room = room - 20;
            changeRoomNum(room);
            Hero.setNewPosition(new Position(1,3));
            doorsAltLeftPrevious.clear();
            return;
        }
        if(gatesNext.containsKey(Hero.getNewPosition())){
            room = room + 50;
            lastRoom = room;
            changeRoomNum(room);
            gatesNext.clear();
            return;
        }
        if(gatesPrevious.containsKey(Hero.getNewPosition())){
            room = room - 50;
            changeRoomNum(room);
            gatesPrevious.clear();
            Hero.setNewPosition(new Position(4,1));
        }
    }
}
