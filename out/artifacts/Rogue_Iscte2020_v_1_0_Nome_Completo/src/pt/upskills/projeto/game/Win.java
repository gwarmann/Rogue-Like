package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.map.Scroll;
import pt.upskills.projeto.objects.screens.GameOverRogue;
import pt.upskills.projeto.objects.screens.YouWinRogue;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Win implements Observer {

    public static void win() {
        for (ImageTile c : Engine.tiles) {
            if (c instanceof Scroll) {
                if (c.getPosition().getY() == Hero.getNewPosition().getY() && c.getPosition().getX() == Hero.getNewPosition().getX()) {
                    Engine.gui.clearImages();
                    Engine.gui.clearStatus();
                    Engine.gui.deleteObservers();
                    Engine.tiles.clear();
                    Engine.status.clear();
                    Engine.solids.clear();
                    Enemy.enemies.clear();
                    ItemBar.items.clear();
                    ItemBar.artifacts.clear();
                    LevelChange.setLevel(0);
                    RoomChange.setRoom(0);
                    Engine.gui.setImageToFillRogueWindow(new YouWinRogue(new Position(0, 0)));
                    for (int i = 0; i < 10; i++) {
                        Engine.status.add(new Black(new Position(i, 1)));
                    }
                    Win win = new Win();
                    Engine.gui.newStatusImages(Engine.status);
                    Engine.gui.addObserver(win);
                    Engine.gui.go();
                    break;
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_SPACE) {
            Engine.gui.setImageToFillRogueWindow(null);
            TitleCard.showTitleCard();
        }
    }
}
