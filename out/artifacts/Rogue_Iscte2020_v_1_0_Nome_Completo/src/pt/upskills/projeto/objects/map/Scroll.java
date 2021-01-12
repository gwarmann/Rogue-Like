package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class Scroll extends Map {

    public Scroll(Position position) {
        super(position);
    }

    @Override
    public String getName() {
       return "Scrools";
    }


}
