package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Artifact;
import pt.upskills.projeto.objects.artifacts.FireBall;
import pt.upskills.projeto.objects.artifacts.Fire_old;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;

public class FireBallThread extends Thread {

    private Direction direction;
    private FireTile fireTile;

    public FireBallThread(Direction direction, FireTile fireTile) {
        this.direction = direction;
        this.fireTile = fireTile;
    }

    @Override
    public void run() {
            boolean control = true;
            while (control) {
                Position nextPosition = fireTile.getPosition().plus(direction.asVector());
                fireTile.setPosition(nextPosition);
                try {
                    if (fireTile.validateImpact()) {
                        // FireBall continue
                        sleep(300);
                    } else {
                        // FireBall should explode and stop is job
                        Fire_old fire_old = new Fire_old(fireTile.getPosition());
                        Engine.gui.addImage(fire_old);
                        sleep(500);
                        Engine.gui.removeImage(fire_old);
                        control = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Remove FireBall of {ImageMatrixGUI}
            ImageMatrixGUI.getInstance().removeImage(fireTile);
        }
}
