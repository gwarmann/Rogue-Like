package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.rogue.utils.Position;

public class StairsDown extends Map {
    public StairsDown(Position position) {
        super(position);
    }

    @Override
    public String getName() { return "StairsDown"; }
}
