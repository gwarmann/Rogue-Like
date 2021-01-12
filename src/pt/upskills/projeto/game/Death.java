package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.screens.GameOverRogue;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Death implements Observer {

    public static void dying(){
        if(Hero.getHealth() <= 0){
            Engine.gui.clearImages();
            Engine.gui.clearStatus();
            Engine.gui.deleteObservers();
            Engine.tiles.clear();
            Engine.status.clear();
            Engine.solids.clear();
            Enemy.enemies.clear();
            ItemBar.items.clear();
            ItemBar.artifacts.clear();
            RoomChange.setRoom(0);
            Engine.gui.setImageToFillRogueWindow(new GameOverRogue(new Position(0,0)));
            for(int i=0; i<10; i++){
                Engine.status.add(new Black(new Position(i, 1)));
            }
            Death death = new Death();
            Engine.gui.addObserver(death);
            Engine.gui.newImages(Engine.tiles);
            Engine.gui.newStatusImages(Engine.status);
            Engine.gui.go();
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_SPACE) {
            Engine.gui.setImageToFillRogueWindow(null);
            NewGame.startNewGame();
        }
    }
}
