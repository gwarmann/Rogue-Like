package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.FireBallThread;
import pt.upskills.projeto.game.FireBar;
import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

public class FireBall implements FireTile {

    private Position position;

    public FireBall(Position position) {
        this.position = position;
    }

    private static int dano = 8;

    public static int getDano() { return dano; }


    @Override
    public boolean validateImpact() {
        if(Engine.solids.containsKey(this.position)){
            return false;
        } else if (Enemy.enemies.containsKey(this.position)) {
            ImageTile enemy = Enemy.enemies.get(this.position);
            ((Enemy) enemy).danoRecebido(getDano());
            return false;
        } return true;
    }

    public static void throwBall(Direction direction) {
        if(FireBar.getnFire() > 0) {
            FireBall fire = new FireBall(Hero.getNewPosition());
            FireBallThread fireBallThread = new FireBallThread(direction, fire);
            fireBallThread.start();

            Engine.tiles.add(fire);
            Engine.gui.addImage(fire);


            FireBar.removeFireBar();
        }
    }


    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "FireBall";
    }
}
