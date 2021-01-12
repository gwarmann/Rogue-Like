package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorLocked extends Map {

    public DoorLocked(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "DoorLocked0";
        } else if(LevelChange.getLevel() == 2){return "DoorLocked2";
        } else{ return "DoorLocked";
        }
    }
}
