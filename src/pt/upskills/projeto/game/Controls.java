package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.screens.ControlsRogue;
import pt.upskills.projeto.objects.screens.NewGameRogue2;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Controls implements Observer {

    public static void startNewGame(){
        Engine.gui.setImageToFillRogueWindow(new ControlsRogue(new Position(0,0)));
        Controls controls = new Controls();
        Engine.gui.addObserver(controls);
        Engine.gui.go();
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_SPACE) {
            Engine.gui.setImageToFillRogueWindow(null);
            LevelChange.setLevel(0);
            Engine.gui.clearStatus();
            Engine.gui.deleteObservers();
            Engine.status.clear();
            Engine.engine.init();
            Hero.setHealth(16);
            FireBar.setnFire(3);
        }
    }
}

