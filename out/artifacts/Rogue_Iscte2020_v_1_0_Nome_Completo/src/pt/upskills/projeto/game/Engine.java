package pt.upskills.projeto.game;


import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.*;
import pt.upskills.projeto.objects.artifacts.FireBall;
import pt.upskills.projeto.objects.artifacts.GoodMeat;
import pt.upskills.projeto.objects.artifacts.Hammer;
import pt.upskills.projeto.objects.artifacts.Sword;
import pt.upskills.projeto.objects.enemies.*;
import pt.upskills.projeto.objects.map.DoorOpen.*;
import pt.upskills.projeto.objects.map.Grass;
import pt.upskills.projeto.objects.map.*;
import pt.upskills.projeto.objects.status.Black2;
import pt.upskills.projeto.rogue.utils.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Engine {
    public static List<ImageTile> tiles = new ArrayList<>();
    public static List<ImageTile> status = new ArrayList<>();

    public static HashMap<Position,ImageTile> solids = new HashMap<>();
    public static ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
    public static Engine engine = new Engine();

    public void init(){

        for(int i=0; i<10; i++){
            status.add(new Black2(new Position(i, 1)));
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                tiles.add(new Floor(new Position(i, j)));
            }
        }

        FireBar.fireBar();
        HealthBar.healthBar();

        readMapFile(0,0, tiles);

        gui.newImages(tiles);
        gui.newStatusImages(status);
        gui.newStatusImages(HealthBar.health);
        gui.newStatusImages(FireBar.fire);
        gui.go();

    }


    public static void readMapFile(int level, int room, List<ImageTile> tiles){
        try {
            ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
            Scanner scanner = new Scanner(new File("levels/level" + level + "/room" + room + ".txt"));
            int a = 0;
            Hero hero = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] coded = line.split("");
                for (int i = 0; i < coded.length; i++) {
                    switch (coded[i]) {
                            // map
                        case "W":
                            Wall wall = new Wall(new Position(i, a));
                            tiles.add(wall);
                            solids.put(new Position(i, a), wall );
                            break;
                        case "w":
                            WallDecorated wallDecorated = new WallDecorated(new Position(i, a));
                            tiles.add(wallDecorated);
                            solids.put(new Position(i, a), wallDecorated );
                            break;
                        case "b":
                            BookShelves bookShelves = new BookShelves(new Position(i, a));
                            tiles.add(bookShelves);
                            solids.put(new Position(i, a), bookShelves );
                            break;
                        case "$":
                            Statue statue = new Statue(new Position(i, a));
                            tiles.add(statue);
                            solids.put(new Position(i, a), statue );
                            break;
                        case ".":
                            tiles.add(new FloorSpecial(new Position(i, a)));
                            break;
                        case ":":
                            tiles.add(new FloorDecorated(new Position(i, a)));
                            break;
                        case "g":
                            tiles.add(new Grass(new Position(i, a)));
                            break;
                        case "t":
                            tiles.add(new GrassTrampled(new Position(i, a)));
                            break;
                        case "M":
                            Moon moon = new Moon(new Position(i, a));
                            tiles.add(moon);
                            solids.put(new Position(i, a), moon );
                            break;
                        case "N":
                            Noon noon = new Noon(new Position(i, a));
                            tiles.add(noon);
                            solids.put(new Position(i, a), noon );
                            break;
                        case "K":
                            Killer killer = new Killer(new Position(i, a));
                            tiles.add(killer);
                            solids.put(new Position(i, a), killer );
                            break;
                        case "l":
                            tiles.add(new Scroll(new Position(i, a)));
                            break;

                            // doors
                        case "0":
                            DoorLocked doorLocked = new DoorLocked(new Position(i, a));
                            tiles.add(doorLocked);
                            solids.put(new Position(i, a), doorLocked);
                            break;
                        case "9":
                            DoorClosed doorClosed = new DoorClosed(new Position(i, a));
                            tiles.add(doorClosed);
                            RoomChange.doorsPrevious.put(new Position(i, a), doorClosed);
                            break;
                        case "1":
                            DoorOpen1 doorOpen1 = new DoorOpen1(new Position(i, a));
                            tiles.add(doorOpen1);
                            RoomChange.doorsAltRightNext.put(new Position(i, a), doorOpen1);
                            break;
                        case "2":
                            DoorOpen2 doorOpen2 = new DoorOpen2(new Position(i, a));
                            tiles.add(doorOpen2);
                            RoomChange.doorsAltRightPrevious.put(new Position(i, a), doorOpen2);
                            break;
                        case "3":
                            DoorOpen3 doorOpen3 = new DoorOpen3(new Position(i, a));
                            tiles.add(doorOpen3);
                            RoomChange.doorsAltLeftNext.put(new Position(i, a), doorOpen3);
                            break;
                        case "4":
                            DoorOpen4 doorOpen4 = new DoorOpen4(new Position(i, a));
                            tiles.add(doorOpen4);
                            RoomChange.doorsAltLeftPrevious.put(new Position(i, a), doorOpen4);
                            break;
                        case "5":
                            GateLocked gateLocked = new GateLocked(new Position(i, a));
                            tiles.add(gateLocked);
                            solids.put(new Position(i, a), gateLocked);
                            break;
                        case "6":
                            GateOpen gateOpen = new GateOpen(new Position(i, a));
                            tiles.add(gateOpen);
                            RoomChange.gatesPrevious.put(new Position(i, a), gateOpen);
                            break;
                        case "7":
                            StairsDown stairsDown = new StairsDown(new Position(i, a));
                            tiles.add(stairsDown);
                            LevelChange.stairsNext.put(new Position(i, a), stairsDown);
                            break;
                        case "8":
                            StairsUp stairsUp = new StairsUp(new Position(i, a));
                            tiles.add(stairsUp);
                            LevelChange.stairsPrevious.put(new Position(i, a), stairsUp);
                            break;

                            // enemies
                        case "S":
                            tiles.add(new Skeleton(new Position(i, a)));
                            break;
                        case "B":
                            tiles.add(new Bat(new Position(i, a)));
                            break;
                        case "T":
                            tiles.add(new Trap(new Position(i, a)));
                            break;
                        case "c":
                            tiles.add(new Chest(new Position(i, a)));
                            break;
                        case "&":
                            tiles.add(new BadGuy(new Position(i, a)));
                            break;
                        case "C":
                            tiles.add(new Crab(new Position(i, a)));
                            break;


                            // artifacts
                        case "s":
                            Sword sword = new Sword(new Position(i, a));
                            tiles.add(sword);
                            ItemBar.artifacts.put(new Position(i, a), sword);
                            break;
                        case "h":
                            Hammer hammer = new Hammer(new Position(i, a));
                            tiles.add(hammer);
                            ItemBar.artifacts.put(new Position(i, a), hammer);
                            break;
                        case "f":
                            FireBall fireBall = new FireBall(new Position(i, a));
                            tiles.add(fireBall);
                            ItemBar.artifacts.put(new Position(i, a), fireBall);
                            break;
                        case "G":
                            GoodMeat goodMeat = new GoodMeat(new Position(i, a));
                            tiles.add(goodMeat);
                            ItemBar.artifacts.put(new Position(i, a), goodMeat);
                            break;

                            // hero
                        case "H":
                            hero = new Hero(new Position(i, a));
                            gui.addObserver(hero);
                            break;
                    }
                }
                a++;

            }
            tiles.add(hero);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TitleCard.showTitleCard();
        while (true){
            gui.update();
        }
      }

}
