package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Fire_old implements ImageTile {

    private Position position;

    public Fire_old(Position position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return "Fire_old";
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

}
