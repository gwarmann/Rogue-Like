package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class Map implements ImageTile {

    private Position position;

    public Map(Position position) {
        this.position = position;
    }

    @Override
    public abstract String getName();

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) { this.position = position; }

}
