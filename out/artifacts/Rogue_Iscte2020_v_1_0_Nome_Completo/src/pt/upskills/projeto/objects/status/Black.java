package pt.upskills.projeto.objects.status;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Black extends Health {

    public Black(Position position) {
        super( position );
    }

    @Override
    public String getName() {
        return "Black";
    }

}

