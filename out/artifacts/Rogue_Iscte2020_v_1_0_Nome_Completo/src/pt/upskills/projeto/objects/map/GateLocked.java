package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class GateLocked extends Map {

    public GateLocked(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "GateLocked0";
        } else if(LevelChange.getLevel() == 2){return "GateLocked2";
        } else{ return "GateLocked";
        }
    }

}
