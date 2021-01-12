package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.FireBar;
import pt.upskills.projeto.game.HealthBar;
import pt.upskills.projeto.game.ItemBar;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.enemies.BadGuy;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.enemies.Trap;
import pt.upskills.projeto.objects.map.DoorOpen.DoorOpen;
import pt.upskills.projeto.objects.map.DoorOpen.DoorOpen1;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Artifact implements ImageTile {

    private Position position;

    public Artifact(Position position) {
        this.position = position;
    }

    public Position getPosition(){ return position; };

    public void setPosition(Position position) { this.position = position; }


}

