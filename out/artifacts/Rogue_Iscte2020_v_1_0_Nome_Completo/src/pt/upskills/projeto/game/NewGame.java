package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.screens.GodModeRogue;
import pt.upskills.projeto.objects.screens.NewGameRogue1;
import pt.upskills.projeto.objects.screens.NewGameRogue2;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class NewGame implements Observer {

    public static void startNewGame(){
        if(LevelChange.getLevel() == 0) {
            Engine.gui.setImageToFillRogueWindow(new NewGameRogue1(new Position(0,0)));
        }else{
            Engine.gui.setImageToFillRogueWindow(new NewGameRogue2(new Position(0,0)));
        }
        NewGame newGame = new NewGame();
        Engine.gui.addObserver(newGame);
        Engine.gui.go();
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_G) {
            Hero.setGodMode(666);
            System.out.println("aii");
        }
        if (keyCode == KeyEvent.VK_1) {
            if (Hero.getGodMode() == 666) {
                GodMode.startGodMode();
            } else {
                Engine.gui.setImageToFillRogueWindow(null);
                LevelChange.setLevel(0);
                Engine.gui.deleteObservers();
                Controls.startNewGame();
                Hero.setHealth(16);
                FireBar.setnFire(3);
            }
        }
        if (LevelChange.getLevel() != 0) {
            if (keyCode == KeyEvent.VK_2) {
                if (Hero.getGodMode() == 666) {
                    GodMode.startGodMode();
                } else {
                    Engine.gui.setImageToFillRogueWindow(null);
                    Engine.gui.clearStatus();
                    Engine.gui.deleteObservers();
                    Engine.status.clear();
                    Engine.engine.init();
                    Hero.setHealth(16);
                    FireBar.setnFire(3);
                }
            }
        }

    }

}

