package pt.upskills.projeto.objects.status;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class Health implements ImageTile {

    private Position position;

    public Health(Position position) {
        this.position = position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public abstract String getName();

    @Override
    public Position getPosition() { return position; };
}

