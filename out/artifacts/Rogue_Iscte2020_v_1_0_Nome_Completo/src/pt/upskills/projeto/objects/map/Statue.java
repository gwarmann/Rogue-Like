package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Statue extends Map {

    public Statue(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        return "Statue";
    }

}

