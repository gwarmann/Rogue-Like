package pt.upskills.projeto.objects.screens;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class Screen implements ImageTile {

    private Position position;

    public Screen(Position position) {
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
