package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class FloorDecorated extends Map {

    public FloorDecorated(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "FloorDecorated0";
        } else if(LevelChange.getLevel() == 2){return "FloorDecorated2";
        } else{ return "FloorDecorated";
        }
    }

}

