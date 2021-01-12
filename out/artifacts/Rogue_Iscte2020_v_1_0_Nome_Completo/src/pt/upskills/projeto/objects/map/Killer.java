package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.rogue.utils.Position;

public class Killer extends Map {

    public Killer(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        return "Killer";
    }

}

