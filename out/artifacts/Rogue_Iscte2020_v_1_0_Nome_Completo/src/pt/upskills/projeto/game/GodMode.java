package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.screens.ControlsRogue;
import pt.upskills.projeto.objects.screens.GodModeRogue;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class GodMode implements Observer {

    public static void startGodMode(){
        Engine.gui.setImageToFillRogueWindow(new GodModeRogue(new Position(0,0)));
        GodMode godMode = new GodMode();
        Engine.gui.addObserver(godMode);
        Engine.gui.go();
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_SPACE) {
            if(LevelChange.getLevel() != 0) {
                Engine.gui.setImageToFillRogueWindow(null);
                Engine.gui.clearStatus();
                Engine.gui.deleteObservers();
                Engine.status.clear();
                Engine.engine.init();
                Hero.setHealth(16);
                FireBar.setnFire(3);
            } else {
                Engine.gui.setImageToFillRogueWindow(null);
                LevelChange.setLevel(0);
                Engine.gui.deleteObservers();
                Controls.startNewGame();
                Hero.setHealth(16);
                FireBar.setnFire(3);
            }
        }
    }
}

