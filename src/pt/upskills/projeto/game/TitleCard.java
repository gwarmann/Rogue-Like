package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.screens.TitleScreenRogue;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class TitleCard implements Observer {

    public static void showTitleCard(){
        Engine.gui.setImageToFillRogueWindow(new TitleScreenRogue(new Position(0,0)));
        for (int i = 0; i < 10; i++) {
            Engine.status.add(new Black(new Position(i, 1)));
        }
        TitleCard titleCard = new TitleCard();
        Engine.gui.newStatusImages(Engine.status);
        Engine.gui.addObserver(titleCard);
        Engine.gui.go();
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_SPACE) {
            Engine.gui.setImageToFillRogueWindow(null);
            Engine.gui.deleteObservers();
            NewGame.startNewGame();
        }
    }
}
