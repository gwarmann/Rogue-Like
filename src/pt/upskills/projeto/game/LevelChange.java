package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.map.Floor;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class LevelChange {

    public static Map<Position, ImageTile> stairsNext = new HashMap<>();
    public static Map<Position,ImageTile> stairsPrevious = new HashMap<>();

    static int level = 0;

    public static void setLevel(int level) { LevelChange.level = level; }

    public static int getLevel() { return level; }

    public static void changeLevelNum(int level, int room){
        Engine.gui.clearImages();
        Engine.gui.deleteObservers();
        Engine.tiles.clear();
        Engine.solids.clear();
        Enemy.enemies.clear();
        ItemBar.artifacts.clear();
        RoomChange.setRoom(0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Engine.tiles.add(new Floor(new Position(i, j)));
            }
        }
        Engine.readMapFile(level,room , Engine.tiles);
        Engine.gui.newImages(Engine.tiles);
        Engine.gui.go();
    }

    public static void changeLevel(){
        if(stairsNext.containsKey(Hero.getNewPosition())){
            level++;
            changeLevelNum(level, 0);
            stairsNext.clear();
            return;
        }
        if(stairsPrevious.containsKey(Hero.getNewPosition())){
            level--;
            changeLevelNum(level, RoomChange.getLastRoom());
            Hero.setNewPosition(new Position(4,4));
            stairsPrevious.clear();
        }
    }

}
