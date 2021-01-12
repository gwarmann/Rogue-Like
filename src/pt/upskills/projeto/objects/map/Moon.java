package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.rogue.utils.Position;

public class Moon extends Map {

    public Moon(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        return "Moon";
    }

}

